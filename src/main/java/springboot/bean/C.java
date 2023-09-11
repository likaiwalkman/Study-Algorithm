package springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class C {
    private A a;
    private B b;
    private D d;

    public C(D d){
        System.out.println("injected d hashCode:" + d.hashCode());
        this.d = d;
    }

    @PostConstruct
    public void init1(){
        System.out.println("init-1");
    }

    @PostConstruct
    public void init2(){
        System.out.println("init-2");
    }

    @Autowired
    public void setA(A a) {
        this.a = a;
    }
    @Autowired
    public void setB(B b) {
        this.b = b;
    }

    public void setD(D d) {
        this.d = d;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    public D getD() {
        return d;
    }
}
