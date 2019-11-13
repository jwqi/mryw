package com.jwqi.mryw.controller;


import com.jwqi.mryw.bo.Constains;
import com.jwqi.mryw.utils.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Constains constains;

    @GetMapping("/getOpenId")
    public String getOpenId(String code) {
        String appid = constains.getAppid();
        String secret = constains.getSecret();
        return HttpClient.doGet("https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code");
    }
}
