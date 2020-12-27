package circleArray;

import java.util.Scanner;

public class CircleArrayQueue {

    public static void main(String[] args) {

        CircleArray circleArray = new CircleArray(4);
        boolean falg  = true;

        while(falg){

            Scanner scanner = new Scanner(System.in);
            char c = scanner.next().charAt(0);
            switch(c){
                case 'g' :
                    System.out.println(circleArray.getData()); break;
                case 'a' : circleArray.addData(scanner.nextInt()); break;
                case 'h' :
                    System.out.println(circleArray.showHeadData()); break;
                case 's' : circleArray.show(); break;
                case 'e' : falg = false; break;
            }
        }
    }

}

class CircleArray{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int maxArrSize){  //4
        maxSize = maxArrSize;
        arr = new int[maxSize];
    }

    public boolean isFull(){
        return (rear+1) % maxSize == front;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public void addData(int n){
        if(this.isFull()){
            throw new RuntimeException("数据已满~~");
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getData(){
        if(isEmpty()){
            throw new RuntimeException("数据为空~~");
        }
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    public int showHeadData(){
        if(isEmpty()){
            throw new RuntimeException("数据为空~~");
        }
        return arr[front];
    }

    public void show(){
        if(isEmpty()){
            throw new RuntimeException("数据为空~~");
        }

        for(int i=front;i<front+getSize();i++){
            System.out.printf("a[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }
    }

    public int getSize(){
        return (rear + maxSize - front) % maxSize;
    }
}