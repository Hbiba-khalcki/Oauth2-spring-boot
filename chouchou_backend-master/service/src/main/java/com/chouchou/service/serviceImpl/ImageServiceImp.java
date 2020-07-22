package com.chouchou.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chouchou.dao.ImageRepository;
import com.chouchou.model.Image;
import com.chouchou.service.ImageService;

@Service
public class ImageServiceImp implements ImageService{

	@Autowired
	ImageRepository rep;

	@Override
	public Image savOrUpdate(Image o) {
		return rep.save(o);
	}

	@Override
	public void delete(Long id) {
		rep.deleteById(id);
	}

	@Override
	public List<Image> findAll() {
		return rep.findAll();
	}

	@Override
	public Optional<Image> findByID(long id) {
		return rep.findById(id);
	}
}
