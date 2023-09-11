package springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A {
    private B b;

    @Autowired
    public void setB(B b) {
        this.b = b;
    }

    public B getB() {
        return b;
    }
}
