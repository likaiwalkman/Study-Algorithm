package springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class B {
    private A a;

    @Autowired
    public void setA(A a) {
        this.a = a;
    }

    public A getA() {
        return a;
    }
}
