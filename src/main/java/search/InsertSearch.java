package search;

public class InsertSearch {

    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6,7,8,9};
        int index = insertSearch(array,0,array.length-1,9);
        System.out.println(index);
    }

    public static int insertSearch(int[] array,int left,int right,int findVal){

        if(left > right || findVal < array[0] || findVal > array[array.length-1]){
            return -1;
        }

        int mid = (left + right)* (findVal - array[left]) / (array[right] - array[left]);
        if(array[mid] > findVal){
            return insertSearch(array,left,mid - 1,findVal);
        }else if(array[mid] < findVal){
            return insertSearch(array,mid+1,right,findVal);
        }else{
            return mid;
        }

    }
}
