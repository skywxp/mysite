package com.skywxp.mysite.utils;

import cn.hutool.http.HttpUtil;

import java.util.HashMap;

public class WeatherUtils {
    public static String getWeather(String key,String city){
        HashMap<String,Object> map = new HashMap<>();
        map.put("key",key);
        map.put("city",city);
        String result= HttpUtil.get("https://restapi.amap.com/v3/weather/weatherInfo", map);
        return result;
    }
}
