package com.jwqi.mryw.scheduler;

import com.alibaba.fastjson.JSON;
import com.jwqi.mryw.Repository.MessageRepository;
import com.jwqi.mryw.bo.ResultBO;
import com.jwqi.mryw.bo.TemplateMessageBO;
import com.jwqi.mryw.entity.Message;
import com.jwqi.mryw.utils.AccessTokenUtil;
import com.jwqi.mryw.utils.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
public class SendMessageTask {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AccessTokenUtil accessTokenUtil;

    @Autowired
    private MessageRepository messageRepository;

    @Scheduled(cron = "0/30 * * * * *")
    public void scheduled(){
        Date date = new Date();
        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
        List<Message> msgs =  messageRepository.findUnsendMessage(currentTime);
        for (Message msg: msgs) {
            TemplateMessageBO templateMessageBO = new TemplateMessageBO();
            templateMessageBO.setTouser(msg.getOpenId());
            templateMessageBO.setTemplate_id("cT4L02cREfczGqo3LeuhAExlpuiPh18r2HeSHROM9E8");
            templateMessageBO.setPage("pages/detail/detail");
            TemplateMessageBO.Data data = templateMessageBO.new Data();
            TemplateMessageBO.Data.thing1 thing1 = data.new thing1();
            thing1.setValue("每日阅读");
            data.setThing1(thing1);
            TemplateMessageBO.Data.thing2 thing2 = data.new thing2();
            thing2.setValue("散文");
            data.setThing2(thing2);
            TemplateMessageBO.Data.time3 time3 = data.new time3();
            time3.setValue(msg.getDateTime());
            data.setTime3(time3);
            TemplateMessageBO.Data.thing4 thing4 = data.new thing4();
            thing4.setValue("亲，记得阅读散文哦");
            data.setThing4(thing4);
            templateMessageBO.setData(data);
            String content = JSON.toJSONString(templateMessageBO);
            logger.info("消息内容："+ content);;
            String accessToken = accessTokenUtil.getAccessToken();
            String retMsg = HttpClient.doPost("https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token="+accessToken, content);
            logger.info("消息发送返回："+ retMsg);;
            if("42001".equals(JSON.parseObject(retMsg, ResultBO.class).getErrcode())){
                accessToken = accessTokenUtil.getAccessToken2();
                retMsg = HttpClient.doPost("https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token="+accessToken, content);
                logger.info("消息发送返回："+ retMsg);;
            }
            messageRepository.updateMessageStatusById(msg.getId(), JSON.parseObject(retMsg, ResultBO.class).getErrcode());
        }

    }
}
