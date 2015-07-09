package com.grijesh.qrgenerator.controllers;

import com.grijesh.qrkeygenerator.cache.QRKeyKeeper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by grijesh on 8/7/15.
 */

@Controller
public class LoginController {

    @RequestMapping("/login/{id}")
    public String authenticate(@PathVariable String id){
        QRKeyKeeper keyKeeper = QRKeyKeeper.getInstance();
        String value = keyKeeper.get(id);
        System.out.println(value);
        if("inactive".equals(value)){
           return "welcome";
        }
        return "login";
    }

}
