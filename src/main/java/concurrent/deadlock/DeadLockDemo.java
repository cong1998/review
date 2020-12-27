package concurrent.deadlock;

public class DeadLockDemo implements Runnable {

    private String lockA;
    private String lockB;

    public DeadLockDemo(String lockA,String lockB){
        this.lockB=lockB;
        this.lockA=lockA;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+"\t正在运行...");

        synchronized (lockA){
            System.out.println("获取"+lockB+"....");
            synchronized (lockB){
                System.out.println("获取成功！");
            }
        }
    }

    public static void main(String[] args) {
        String lockA ="lockA" ;
        String lockB ="lockB" ;
        new Thread(new DeadLockDemo(lockA,lockB),"AAA").start();
        new Thread(new DeadLockDemo(lockB,lockA),"BBB").start();
    }
}
