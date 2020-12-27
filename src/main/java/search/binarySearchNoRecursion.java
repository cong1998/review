package search;

public class binarySearchNoRecursion {

    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6,7,8,9};
        int index = binarySearch(array,5);
        System.out.println(index);
    }

    public static int binarySearch(int array[],int findVal){

        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int mid = (left+right)/2;
            if(array[mid] == findVal){
                return mid;
            }else if(array[mid] < findVal){
                left = mid + 1;
            }else if(array[mid] > findVal){
                right = mid - 1;
            }
        }
        return -1;
    }
}
