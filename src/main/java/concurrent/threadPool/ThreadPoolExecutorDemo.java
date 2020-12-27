package concurrent.threadPool;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

    ExecutorService service = new ThreadPoolExecutor(2,
            5,
            1L,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(3),
           Executors.defaultThreadFactory(),
                   new ThreadPoolExecutor.AbortPolicy());

           for(int i = 0;i<8;i++){
           service.execute(()->{
               System.out.println("正在执行+"+ Thread.currentThread().getName());
           });
       }
       service.shutdown();
    }
}
