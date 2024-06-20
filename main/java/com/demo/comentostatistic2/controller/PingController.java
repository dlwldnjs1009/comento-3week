package com.demo.comentostatistic2.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PingController {

    @RequestMapping(value="/ping", produces = "application/json")
    @ResponseBody
    public Object healthCheck(){
        Map<String, Object> map = new HashMap<>();
        map.put("today", ZonedDateTime.now().getMonth() + ":" + ZonedDateTime.now().getDayOfMonth());
        return map;
    }

}
