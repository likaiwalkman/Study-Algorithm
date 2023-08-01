package clsloader.demo;

import clsloader.StaticHolder;

public class CustomizedClsLoaderThread extends Thread {
    public CustomizedClsLoaderThread(){
        //super();
    }

    @Override
    public void run() {

        while (true){

            StaticHolder staticHolder = new StaticHolder();
            int increment = StaticHolder.increment(123);
            System.out.println(increment);
            try {
                Class<?> clz = Class.forName("clsloader.StaticHolder");
                Thread.sleep(5000000);
            }catch (Exception e){
                Thread.interrupted();
                System.out.println("interrupt");
            }
        }

    }
}
