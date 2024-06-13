package cn.atsuc.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author csuporg
 * @date 2024/5/9 23:49
 * @email s202011105851@163.com
 * @description
 */
@Component
@Aspect  // 生成代理对象
public class aopUserProxy {
    @Before(value = "execution(* cn.atsuc.spring.aop.aopUser.add(..))")
    public void before() {
        System.out.println("before ... ");
    }

    @After(value = "execution(* cn.atsuc.spring.aop.aopUser.add(..))")
    public void after() {
        System.out.println("after ... ");
    }

    @AfterReturning(value = "execution(* cn.atsuc.spring.aop.aopUser.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning ... ");
    }

    @AfterThrowing(value = "execution(* cn.atsuc.spring.aop.aopUser.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing ... ");
    }

    @Around(value = "execution(* cn.atsuc.spring.aop.aopUser.add(..))")
    public void around(ProceedingJoinPoint process) throws Throwable {
        System.out.println("around ... ");
        process.proceed();
        System.out.println("after around ... ");
    }
}
