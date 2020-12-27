import java.util.Scanner;

public class Example02 {
    public static void main(String[] args) throws Exception{
       // new B();
       // B.class.newInstance();
       // Thread.currentThread().getContextClassLoader().loadClass("B");
       // Class.forName("B");
    }

   public static void test1(){
       Scanner scanner = new Scanner(System.in);
       String line = scanner.nextLine();
       String[] strings = line.split("[*/+-]");
       for(int i=0;i<strings.length;i++)
           System.out.println(strings[i]);
       scanner.close();
   }
}

class A{

   static {
       System.out.println("static A");
   }

    {
        System.out.println("block A");
    }

    public A() {
        System.out.println("construction A");
    }

}

class B extends A{

    static {
        System.out.println("static B");
    }

    {
        System.out.println("block B");
    }

    public B() {
        System.out.println("construction B");
    }

}
