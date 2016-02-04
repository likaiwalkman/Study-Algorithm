package dynamicProxy.invocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by kai_li on 2016/2/4.
 */
public class InvocationHandlerImpl implements InvocationHandler {
    private ElectricCar car;

    public InvocationHandlerImpl(ElectricCar car) {
        this.car = car;
    }

    public Object invoke(Object paramObject, Method paramMethod,
                         Object[] paramArrayOfObject) throws Throwable {
        System.out.println("You are going to invoke " + paramMethod.getName() + " ...");
        paramMethod.invoke(car, null);
        System.out.println(paramMethod.getName() + " invocation Has Been finished...");
        return null;
    }
}
