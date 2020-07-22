package com.chouchou.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;


@Entity
@Table(name = "COUPON")
public class Coupon {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String code;



    private double price;


    private String status;


    private Date startDate;


    private Date endDate;


    public Coupon() {
    }

    public Coupon(double price, String status, Date endDate) {
        this.price = price;
        this.status = status;
        this.endDate = endDate;
    }

    public Coupon(String code, double price, String status, Date endDate) {
        this.code = code;
        this.price = price;
        this.status = status;
        this.endDate = endDate;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }



    public String generate() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);

    }


    public String createRandomCode(int codeLength){
        char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new SecureRandom();
        for (int i = 0; i < codeLength; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        System.out.println(output);
        return output ;
    }
}