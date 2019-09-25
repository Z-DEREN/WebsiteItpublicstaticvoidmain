package com.zdr.sun.controller.MessagingController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Messaging")
public class MessagingController {
    @RequestMapping(value = "/no1")
    public String no1() {
	return "Chat/Messaging";
    }

    @RequestMapping(value = "/no2")
    public String no2() {
	return "Chat/test";
    }

}
