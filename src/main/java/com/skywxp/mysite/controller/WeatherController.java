package com.skywxp.mysite.controller;

import com.skywxp.mysite.utils.WeatherUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/weather")
public class WeatherController {
    //	key: 465ca90eb4dd77197ea9682543215969
   @GetMapping("/getweather")
    public String getWeather(String key,String city){
       return WeatherUtils.getWeather(key,city);
   }


}
