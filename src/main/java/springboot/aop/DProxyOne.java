package springboot.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class DProxyOne {
    @Around("execution(public * springboot.bean.D.d())")
    public Object around(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        //得到其方法签名
        Object result = null;
        try {
            result = ((ProceedingJoinPoint)joinPoint).proceed(args);
        }catch (Throwable e){
            System.err.println(e);
        }
        return result;
    }
}
