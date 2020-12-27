package concurrent.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 1024;
    }

    public static void main(String[] args) throws Exception{
        FutureTask<Integer> futureTask = new FutureTask<>(new CallableDemo());
        new Thread(futureTask,"AA").start();
        //两次线程执行一遍
        //new Thread(futureTask,"BB").start();
        int i=10;

        while(!futureTask.isDone()){

        }

        System.out.println(futureTask.get()+i);

        System.out.println("main结束...");
    }
}
