package com.vivo.swaggeruidemo.service;

import com.vivo.swaggeruidemo.annotation.AnalysisActuator;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 类描述：服务接口实现
 *
 * @author 汤旗
 * @date 2018-12-24
 */
@Service
public class HelloWorldServiceImpl implements IHelloWorldService {

    @Override
    @AnalysisActuator(note = "获取聊天信息方法")
    public String getHelloMessage(String name) {
        return "Hello " + Optional.ofNullable(name).orElse("World!");
    }

}
