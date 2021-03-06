package dynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class Test {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Programmer progammer = new Programmer();

        Hacker hacker = new Hacker();
        //cglib 中加强器，用来创建动态代理
        Enhancer enhancer = new Enhancer();
        //设置要创建动态代理的类
        enhancer.setSuperclass(progammer.getClass());
        // 设置回调，这里相当于是对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实行intercept()方法进行拦截

        //Method 1:failed
        /*
        enhancer.setCallbackType(Hacker.class);
        Class enhancerClass = enhancer.createClass();
        Programmer proxy = (Programmer) enhancerClass.newInstance();*/

        //Method 2:success
        enhancer.setCallback(hacker);
        Programmer proxy = (Programmer) enhancer.create();
        proxy.code();
        Integer i = proxy.hardCode();
        System.out.println(i);

    }
}