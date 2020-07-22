package com.chouchou.service.serviceImpl;

import com.chouchou.dao.CouponRepository;
import com.chouchou.model.Coupon;
import com.chouchou.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImp implements CouponService {

    @Autowired
    CouponRepository couponRepository;

    @Override
    public Coupon savOrUpdate(Coupon cpn) {
        return couponRepository.save(cpn);
    }

    @Override
    public void delete(Long id) {
        couponRepository.deleteById(id);
    }

}

