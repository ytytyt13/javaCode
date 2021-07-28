package com.qunar.controller;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yang
 * 2021年02月25日 21:36:00
 */
public class Stringtodate implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        Date parse=null;
        if(source==null) {
            throw new RuntimeException("请您传入参数");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            parse = simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
}
