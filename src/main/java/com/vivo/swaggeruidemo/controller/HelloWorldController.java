package com.vivo.swaggeruidemo.controller;

import com.vivo.swaggeruidemo.service.IHelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 类描述：控制层
 *
 * @author 汤旗
 * @date 2018-12-24
 */
@RestController
public class HelloWorldController {

    @Autowired
    private IHelloWorldService helloWorldService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String name) {
        return helloWorldService.getHelloMessage(name);
    }
}