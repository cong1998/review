package concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class QueueDemo {

    private volatile boolean FLAG = true;

    private AtomicInteger atomicInteger = new AtomicInteger();

    private BlockingQueue blockingQueue = null;

    public QueueDemo(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    public void product(){
        try{
           while(FLAG){
               int data = atomicInteger.incrementAndGet();
               boolean b = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
               if(b){
                   System.out.println(data+"数据存储成功...");
               }else{
                   System.out.println(data+"数据存储失败...");
               }
               TimeUnit.SECONDS.sleep(1L);
           }
        }catch (Exception e){

        }
    }

    public void consumer(){
        try{
            while(FLAG){
                Object data = blockingQueue.poll(2L, TimeUnit.SECONDS);
                if(data!=null){
                    System.out.println(data+"数据取出成功...");
                }else{
                    FLAG = false;
                    System.out.println(data+"数据取出失败...");
                    return ;
                }
            }
        }catch (Exception e){

        }
    }

    public void stop(){
        this.FLAG=false;
    }

    public static void main(String[] args) throws Exception {
        QueueDemo queueDemo = new QueueDemo(new ArrayBlockingQueue(10));
        new Thread(()->{
            System.out.println("生产开始...");
            queueDemo.product();
        }).start();

        new Thread(()->{
            System.out.println("消费开始...");
            queueDemo.consumer();
        }).start();

        TimeUnit.SECONDS.sleep(5L);
        //5秒过后结束
        queueDemo.stop();
    }
}
