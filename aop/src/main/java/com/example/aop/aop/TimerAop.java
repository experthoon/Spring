package com.example.aop.aop;

//특정 메서드의 실행 시간

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

// Bean 과 configuration 의 차이점
// 빈 같은 경우 클래스에 붙일 수 없음 메소드에서 쓸 수 있음
// configuration 하나의 클래스에 여러가지 빈이 등록

@Aspect
@Component
public class TimerAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))") //컨트롤러 하위에 있는 메소드
    private void cut(){}

    @Pointcut("@annotation(com.example.aop.annotation.Timer)") //패키지 하위에 있는 타이머 메소드만
    private void enableTimer(){}

    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        //실행 전
        StopWatch stopWatch = new StopWatch();
        //실행 시작
        stopWatch.start();


        Object result = joinPoint.proceed();

        stopWatch.stop();
        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
    }
}
