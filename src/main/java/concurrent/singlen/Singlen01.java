package concurrent.singlen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singlen01 {

    private static volatile Singlen01 singlen01=null;

    private Singlen01(){
        System.out.println("Singlen01初始化。。。");
    }


    //DCL(double check lock)双端检索机制
    public static Singlen01 getInstance(){
        if(singlen01 == null){
            synchronized (Singlen01.class){
                if(singlen01 == null){
                    singlen01 = new Singlen01();
                }
            }

        }
        return singlen01;
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++) {
            service.submit(()->{
                getInstance();
            });
        }

        if(Thread.activeCount()>2){
            Thread.yield();
        }
        service.shutdown();
        System.out.println("main结束。。");

    }
}
