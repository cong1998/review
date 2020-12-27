package sort;


import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int array[] = new int[8];

        for(int i = 0;i<8;i++){
            array[i] =(int) (Math.random()*1000);
        }
        System.out.println("排序前："+Arrays.toString(array));
        bubbleSort(array);

        System.out.println("排序后："+Arrays.toString(array));
    }

    public static void bubbleSort(int [] array){
        boolean flag = false;
        int temp = 0;
        for(int i =0;i<array.length-1;i++){
            flag = false;
            for(int j = 0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag= true;
                }
            }
            if(!flag){
                break;
            }
        }
    }
}
