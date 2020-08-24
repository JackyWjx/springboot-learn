package cn.wjx.springboot_aop.aop;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

//@Order(1)   优先级排序
@Aspect
@Component
public class WebLogAspect {

    private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * cn.wjx.springboot_aop.controller.HelloController.*(..))")//切入点描述 这个是controller包的切入点
    public void hellocontrollerLog(){}//签名，可以理解成这个切入点的一个名称

    @Pointcut("execution(public * cn.wjx.springboot_aop.controller.LoginController.*(..))")//切入点描述，这个是uiController包的切入点
    public void loginControllerLog(){}

    @Before("hellocontrollerLog() || loginControllerLog()") //在切入点的方法run之前要干的
    public void logBeforeController(JoinPoint joinPoint) {
        //参数的获取
        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).forEach(arg-> System.out.println(arg));
        //这个RequestContextHolder是Springmvc提供来获得请求的东西
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

        // 记录下请求内容
        logger.info("################URL : " + request.getRequestURL().toString());
        logger.info("################HTTP_METHOD : " + request.getMethod());
        logger.info("################IP : " + request.getRemoteAddr());
        logger.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));

        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
        logger.info("################CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //logger.info("################TARGET: " + joinPoint.getTarget());//返回的是需要加强的目标类的对象
        //logger.info("################THIS: " + joinPoint.getThis());//返回的是经过加强后的代理类的对象

    }

    @After("hellocontrollerLog() || loginControllerLog()") //在切入点的方法run之前要干的
    public void logAfterController(JoinPoint joinPoint) {
        logger.info("方法成功执行");
    }

    @AfterThrowing(pointcut = "hellocontrollerLog() || loginControllerLog()", throwing = "ex")
    public void doAfterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("连接点方法为：" + methodName + ",参数为：" + args + ",异常为：" + ex);

    }


}