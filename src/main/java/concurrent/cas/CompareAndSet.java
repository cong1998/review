package concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CompareAndSet {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5,2019)+"\t current data:"+atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5,2010)+"\t current data:"+atomicInteger.get());
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.get());
    }
}
