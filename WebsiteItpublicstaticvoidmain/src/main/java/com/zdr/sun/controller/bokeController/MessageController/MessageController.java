package com.zdr.sun.controller.bokeController.MessageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZhangTianDe
 * @date 2019/6/10 17:14
 */
@Controller
@RequestMapping("/MessageInterface")
public class MessageController {
    @RequestMapping("/Message")
    public String ToMessage(){
        System.out.println("进留言页了");

        return "tools/boke/weniian/gbook";
    }
}
