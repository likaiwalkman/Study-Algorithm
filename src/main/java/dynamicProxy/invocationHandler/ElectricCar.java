package dynamicProxy.invocationHandler;

/**
 * Created by kai_li on 2016/2/4.
 */
public class ElectricCar implements Vehicle, Rechargable {
    public void recharge() {
        System.out.println("Electric Car is Recharging...");
    }

    public void drive() {
        System.out.println("Electric Car is Moving silently...");
    }
}
