package com.vivo.swaggeruidemo.aop;

import com.vivo.swaggeruidemo.annotation.AnalysisActuator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 类描述：
 *
 * @author 汤旗
 * @date 2018-12-24
 */
@Aspect
@Component
public class AnalysisActuatorAspect {

    final static Logger log = LoggerFactory.getLogger(AnalysisActuatorAspect.class);

    ThreadLocal<Long> beginTime = new ThreadLocal<>();

    @Pointcut("@annotation(analysisActuator)")
    public void serviceStatistics(AnalysisActuator analysisActuator) {
        log.info("Pointcut running!!");
    }

    @Before("serviceStatistics(analysisActuator)")
    public void doBefore(JoinPoint joinPoint, AnalysisActuator analysisActuator) {
        // 记录请求到达时间
        beginTime.set(System.currentTimeMillis());
        log.info("note:{}", analysisActuator.note());
    }

    @After("serviceStatistics(analysisActuator)")
    public void doAfter(AnalysisActuator analysisActuator) {
        log.info("statistic time:{}, note:{}", System.currentTimeMillis() - beginTime.get(), analysisActuator.note());
    }
}