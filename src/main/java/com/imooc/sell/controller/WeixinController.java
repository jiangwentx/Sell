package com.imooc.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: sell
 * @description: 微信开
 * @author: Mr.Jiang
 * @create: 2018-11-24 20:45
 **/
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {
    @GetMapping("/auth")
    public  void auth(@RequestParam("code") String code){
        log.info("进入auth方法....");
        log.info("code = {}",code);

        //APPID，SECRET填写企业微信公众号的信息,这里没有先不写，后期记得换掉
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code="+code+"&grant_type=authorization_code";
        //get请求
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url,String.class);
        log.info("response={}",response);


    }
}

