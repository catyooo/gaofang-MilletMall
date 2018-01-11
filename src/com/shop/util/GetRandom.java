package com.shop.util;

import java.util.Date;

/**
 * @Author 康健
 * @Date 2017/8/12 11:05
 */
public class GetRandom {

    public static Long getTime() {
        return System.currentTimeMillis();
    }

    public static int random() {
        return (int) ((Math.random()*9+1)*1000);
    }
    public static Long getNumber() {
        return Long.parseLong(String.valueOf(getTime()) + String.valueOf(random()));
    }

}
