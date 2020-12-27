package concurrent.spinLock;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLock01 {


      private AtomicReference<Thread> atomicReference = new AtomicReference<>();

      public void myLock(){
          System.out.println(Thread.currentThread().getName()+"\t myLock is running...");

          Thread currentThread = Thread.currentThread();
          while(!atomicReference.compareAndSet(null,currentThread)){

          }
      }

      public void myUnLock(){
          System.out.println(Thread.currentThread().getName()+"\t myUnLock is running...");
          atomicReference.compareAndSet(Thread.currentThread(),null);
      }

    public static void main(String[] args) {
        SpinLock01 spinLock01 =new SpinLock01();

        new Thread(()->{
            spinLock01.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock01.myUnLock();
        },"t1").start();

        new Thread(()->{
            spinLock01.myLock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock01.myUnLock();
        },"t2").start();
    }
}
