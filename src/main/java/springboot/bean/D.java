package springboot.bean;

import org.springframework.stereotype.Service;

@Service
public class D {

    public void d(){

    }

    public D(){
        System.out.println("raw d hashCode:" + this.hashCode());
    }

}
