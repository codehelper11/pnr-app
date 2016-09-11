package com.droid.app.controller;

import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vinay on 10/9/16.
 */
@RestController
public class PingController{

    @RequestMapping("/ping")
    public String ping(){
        return System.currentTimeMillis()+"";
    }


}
