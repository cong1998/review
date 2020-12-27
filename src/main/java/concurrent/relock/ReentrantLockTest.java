package concurrent.relock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//锁的重入，ReentrantLock and synchronized
//获得锁时，访问有锁的无须获取。直接访问
public class ReentrantLockTest {

    private Lock lock = new ReentrantLock();
    private ReentrantReadWriteLock writeRedLock = new ReentrantReadWriteLock();

    public  void get() throws InterruptedException {
        System.out.println("get is running...");
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(5);
            set();
        }finally {
            lock.unlock();
        }
    }

    public void set() {
        System.out.println("set is running...");
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
