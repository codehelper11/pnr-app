package com.droid.app.controller;

import com.droid.app.entity.Greeting;
import com.droid.app.entity.PnrStatus;
import com.droid.app.service.PnrService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vinay on 19/8/16.
 */
@RestController
public class PnrController {


    private PnrService pnrService;

    public PnrController(PnrService pnrService) {
        this.pnrService = pnrService;
    }

    @RequestMapping("/hello")
    public PnrStatus test(){

        return pnrService.getPnrStatus("8750135595");

    }
}
