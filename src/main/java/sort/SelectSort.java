package sort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {

        int array[] = new int[6];

        for(int i = 0;i<6;i++){
            array[i] =(int) (Math.random()*1000);
        }
        System.out.println("排序前："+ Arrays.toString(array));
        selectSort(array);
        System.out.println("排序后："+Arrays.toString(array));
    }

    private static void selectSort(int[] array) {
        int index = 0 ;
        int temp = 0;
        for(int i =0;i<array.length-1;i++){
            temp = array[i];
            index = i;
            for(int j = i+1;j<array.length;j++){

                if(temp>array[j]){
                    temp = array[j];
                    index = j;
                }

            }

            if(index != i ){    //&& temp != array[i]
                array[index] = array[i];
                array[i] = temp;
            }
            System.out.println(Arrays.toString(array));
        }
    }
}
