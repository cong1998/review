package sort;

import java.util.Arrays;

public class QuicklySort {

    public static void main(String[] args) {
        int array[] = new int[7];

        for(int i = 0;i<7;i++){
            array[i] =(int) (Math.random()*1000);
        }
        System.out.println("排序前："+ Arrays.toString(array));
        quicklySort(array);

        System.out.println("排序后："+Arrays.toString(array));
    }
    public static void quicklySort(int array[]){
        int temp = 0;
        for(int i =0;i<array.length-1;i++){
            for(int j = i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }
}
