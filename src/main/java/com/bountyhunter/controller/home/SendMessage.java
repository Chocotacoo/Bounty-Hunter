package com.bountyhunter.controller.home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bountyhunter/sendsms")
public class SendMessage {

    @RequestMapping(value = "/send")
    public void sendmessage(){

    }
}