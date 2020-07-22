package com.chouchou.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chouchou.model.Image;
import com.chouchou.service.ImageService;

import static com.chouchou.security.Keys.*;

@RestController
@RequestMapping("/upload")
public class UploadController {
	
	@Autowired
	ImageService _service;
	
	
	@RequestMapping(value="/singleUpload")
    public String singleUpload(){
        return "singleUpload";
    }
    @RequestMapping(value="/singleSave", method=RequestMethod.POST )
    public @ResponseBody String singleSave(@RequestParam("file") MultipartFile file ){
        String fileName = null;
        if (!file.isEmpty()) {
            try {
                fileName = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                BufferedOutputStream buffStream = 
                        new BufferedOutputStream(new FileOutputStream(new File("C:/cp/" + fileName)));
                buffStream.write(bytes);
                buffStream.close();
                return "You have successfully uploaded " + fileName;
            } catch (Exception e) {
                return "You failed to upload " + fileName + ": " + e.getMessage();
            }
        } else {
            return "Unable to upload. File is empty.";
        }
    }
    
    
    @RequestMapping(value="/multipleUpload")
    public String multiUpload(){
        return "multipleUpload";
    }
    

    @RequestMapping(value="/multipleSave", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Image multipleSave(@RequestParam("file") MultipartFile[] files){
        String fileName = null;
        String msg = "";
        Image img= new Image();
        if (files != null && files.length >0) {
            for(int i =0 ;i< files.length;){
                try {
                    fileName = files[i].getOriginalFilename();
                    byte[] bytes = files[i].getBytes();
                    
                    File dir = new File(IMAGE_LOCAL_PATH);
                    if (!dir.exists()) dir.mkdirs();
                    
                    BufferedOutputStream buffStream = 
                            new BufferedOutputStream(new FileOutputStream(new File(IMAGE_LOCAL_PATH + fileName)));
                    buffStream.write(bytes);
                    buffStream.close();
                    
                    
                    img=new Image(fileName, null, null, "C:/cp/" + fileName);
                    this._service.savOrUpdate(img);
                    return img;
                } catch (Exception e) {
                    return img;
                }
            }
        } 
        return  img;
    }

}
