package com.chouchou.service;

import com.chouchou.model.Coupon;


public interface CouponService {

    Coupon savOrUpdate(Coupon cpn);

    void delete(Long id);

}
