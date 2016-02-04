package dynamicProxy.invocationHandler;

/**
 * Created by kai_li on 2016/2/4.
 */
public class InspectInvocationProxyTest {
    public static void main(String[] args) {
        ElectricCar car = new ElectricCar();
        ProxyUtils.generateClassFile(car.getClass(), "ElectricCarProxy");
    }
}
