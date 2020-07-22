package com.chouchou.controller;

import com.chouchou.model.Coupon;
import com.chouchou.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    CouponService _serv;

    @RequestMapping(value = "/savOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public String savOrUpdate(@RequestBody Coupon cpn) {
        if (cpn != null) {
            _serv.savOrUpdate(cpn);
            return "{\"status\":\"success\"}";
        } else
            return "{\"status\":\"error\"}";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable Long id) {
        if (id != null) {
            _serv.delete(id);
            return "{\"status\":\"success\"}";
        } else
            return "{\"status\":\"error\"}";
    }
}
