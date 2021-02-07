package sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {

        int array[] = {9,8,5,7,6,3,4,2,1};
        heapSort(array);
        System.out.println(Arrays.toString(array));

    }

    public static void heapSort(int[] array){

        for(int i = array.length/2 - 1; i>=0;i--){
            adjust(array,i,array.length);
        }

        int temp = 0;
        for(int j = array.length-1;j>0;j--){
            temp = array[0];
            array[0] = array[j];
            array[j] = temp;
            adjust(array,0,j);
        }

    }

    private static void adjust(int[] array, int index, int length){

        int temp = array[index];

        for(int i = 2*index+1;i<length;i = i*2+1){
            if(i+1<length && array[i] < array[i+1]){
                i++;
            }
            if(array[i] > temp){
                array[index] = array[i];
                index = i;
            }else{
                break;
            }
        }
        array[index] = temp;
    }

}
