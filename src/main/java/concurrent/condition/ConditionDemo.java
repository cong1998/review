package concurrent.condition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {

    private volatile int number = 5;

    private Lock lock = new ReentrantLock();

    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();
    private Condition condition3=lock.newCondition();

    public void print5(){
        lock.lock();
        try {
            //判断
            while(number != 5){
                condition1.await();
            }
            for(int i=1;i<=5;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i+"次");
            }
            //唤醒
            number =10;
            condition2.signal();


        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }


    public void print10(){
        lock.lock();
        try {
            //判断
            while(number != 10){
                condition2.await();
            }
            for(int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i+"次");
            }
            //唤醒
            number =15;
            condition3.signal();


        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }


    public void print15(){
        lock.lock();
        try {
            //判断
            while(number != 15){
                condition3.await();
            }
            for(int i=1;i<=15;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i+"次");
            }
            //唤醒
            number =5;
            condition1.signal();


        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionDemo conditionDemo = new ConditionDemo();

        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<2;i++){
            executorService.execute(()->{
                conditionDemo.print5();
            });
        }
        for(int i=0;i<2;i++){
            executorService.execute(()->{
                conditionDemo.print10();
            });
        }
        for(int i=0;i<2;i++){
            executorService.execute(()->{
                conditionDemo.print15();
            });
        }
        executorService.shutdown();
    }
}
