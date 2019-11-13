package com.jwqi.mryw.controller;

import com.jwqi.mryw.Repository.MessageRepository;
import com.jwqi.mryw.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/message")
public class MessageController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("/saveMessage")
    public String saveMessage(@RequestBody Message message) {
        String msg = "";
        try {
            messageRepository.save(message);
            msg = "设置成功";
        } catch (Exception e) {
            logger.error("设置失败", e);
            msg = "设置失败";
        }
        return msg;
    }
}
