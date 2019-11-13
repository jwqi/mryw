package com.jwqi.mryw.utils;

import com.alibaba.fastjson.JSON;
import com.jwqi.mryw.bo.AccessTokenBO;
import com.jwqi.mryw.bo.Constains;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccessTokenUtil {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Constains constains;

    private static String accessToken;

    public String getAccessToken() {
        if (accessToken != null && !"".equals(accessToken)) {
            logger.info("access_token存在：" + accessToken);
        } else {
            String retMsg = HttpClient.doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + constains.getAppid() + "&secret=" + constains.getSecret());
            logger.info("获取access_token：" + retMsg);
            accessToken = JSON.parseObject(retMsg, AccessTokenBO.class).getAccess_token();
        }

        return accessToken;
    }

    public String getAccessToken2() {
        String retMsg = HttpClient.doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + constains.getAppid() + "&secret=" + constains.getSecret());
        logger.info("获取access_token：" + retMsg);
        accessToken = JSON.parseObject(retMsg, AccessTokenBO.class).getAccess_token();
        return accessToken;
    }
}
