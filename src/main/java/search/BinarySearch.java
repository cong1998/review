package search;

import java.util.ArrayList;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[]{1,3,88,88,88,99,123};
        int search = binarySearch(array, 0, array.length - 1, 88);
        System.out.println(search);

        ArrayList<Integer> list = binarySearch2(array, 0, array.length - 1, 99);
        System.out.println(list);
    }

    public static int binarySearch(int array[],int left ,int right,int value){

        if(left > right){
            return -1;
        }
        int mid = (left+right)/2;
        int midVal = array[mid];

        if(value > midVal){
          return  binarySearch(array,mid+1,right,value);
        }else if(value < midVal){
           return binarySearch(array,left,mid-1,value);
        }else{
            return mid;
        }
    }


    public static ArrayList<Integer> binarySearch2(int array[], int left , int right, int value){

        if(left > right){
            return new ArrayList<>();
        }
        int mid = (left+right)/2;
        int midVal = array[mid];

        if(value > midVal){
            return  binarySearch2(array,mid+1,right,value);
        }else if(value < midVal){
            return binarySearch2(array,left,mid-1,value);
        }else{
            ArrayList<Integer> list = new ArrayList<>();
            int index = mid-1;
            while(index >0 && midVal == array[index]){

                list.add(index);
                index --;
            }

            list.add(mid);

            index = mid+1;
            while(index<array.length && midVal == array[index]){
                list.add(index);
                index ++;
            }
            return list;
        }
    }
}
