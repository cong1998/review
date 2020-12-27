package sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int array[] = new int[9];

        for(int i = 0;i<9;i++){
            array[i] =(int) (Math.random()*1000);
        }
        System.out.println("排序前："+ Arrays.toString(array));
        shellSort2(array);
        System.out.println("排序后："+Arrays.toString(array));
    }

    public static void shellSort(int array[]){

        int temp = 0 ;
        for(int step = array.length / 2;step>0;step /= 2){  //4

            for(int i = step;i < array.length;i++){

                for(int j = i-step ; j >= 0 ; j -= step){

                    if(array[j]>array[j+step]){
                        temp = array[j];
                        array[j] = array[j+step];
                        array[j+step] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }

    public static void shellSort2(int[] array){
        int temp = 0 ;
        int index = 0;
        for(int step = array.length / 2;step>0;step /= 2){

            for(int i = step;i<array.length;i++){

               temp = array[i];
               index = i;

               if(array[i]<array[i-step]){
                   while(index-step >= 0 && temp<array[index-step]){
                       array[index] = array[index-step];
                       index -= step;
                   }
               }

               array[index] = temp;
            }
        }
    }
}
