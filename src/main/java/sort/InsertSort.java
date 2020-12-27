package sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int array[] = new int[5];

        for(int i = 0;i<5;i++){
            array[i] =(int) (Math.random()*1000);
        }
        System.out.println("排序前："+ Arrays.toString(array));
        insertSort(array);

        System.out.println("排序后："+Arrays.toString(array));

    }

    public static void insertSort(int array[]){

        int temp = 0;
        int index = 0;
        for(int i = 1;i<array.length;i++){

            temp = array[i];
            index = i - 1;

            while(index >= 0 && temp < array[index]){
                array[index+1] = array[index];
                index --;
            }
            if(index + 1 != i){
                array[index+1] = temp;
            }
            System.out.println(Arrays.toString(array));
        }
    }
}
