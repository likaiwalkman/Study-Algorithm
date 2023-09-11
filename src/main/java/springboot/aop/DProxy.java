package springboot.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DProxy {
    //@Pointcut()
    public void pointcut(){

    }

    @Around("execution(public * springboot.bean.D.d())")
    public Object around(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        //得到其方法签名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //获取方法参数类型数组
        Class[] paramTypeArray = methodSignature.getParameterTypes();
        //动态修改其参数
        //注意，如果调用joinPoint.proceed()方法，则修改的参数值不会生效，必须调用joinPoint.proceed(Object[] args)
        Object result = null;
        try {
            result = ((ProceedingJoinPoint)joinPoint).proceed(args);
        }catch (Throwable e){
            System.err.println(e);
        }

        //如果这里不返回result，则目标对象实际返回值会被置为null
        return result;
    }
}
