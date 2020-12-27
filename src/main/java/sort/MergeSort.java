package sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int array[] = {8,5,6,4,3,2,7,1};
        mergeSort(array,0,array.length-1,new int[array.length]);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int array[],int left,int right,int temp[]){
        if(left < right){
            int mid = (left + right)/2;// 0 7  0 3  4 7  0 1 2 3  4 5 6 7
            mergeSort(array,left,mid,temp);
            mergeSort(array,mid+1,right,temp);
            //mid  代表上面拆分的最小单位,即是中间索引
            merge(array,left,right,mid,temp);
        }
    }

    public static void merge(int array[],int left,int right,int mid,int temp[]){

        int t = 0;
        int i = left;
        int j = mid + 1;

        while(i <= mid && j<=right){

            if(array[i]<=array[j]){
                temp[t] = array[i];
                i++;
                t++;
            }else{
                temp[t] = array[j];
                t++;
                j++;
            }
        }

        while(i<=mid){
            temp[t] = array[i];
            t++;
            i++;
        }
        while(j<=right){
            temp[t] = array[j];
            t++;
            j++;
        }

        int tempLeft = left;
        t = 0;
        while(tempLeft <= right){
            array[tempLeft] = temp[t];
            tempLeft ++;
            t++;
        }

    }
}
