package tree;

public class ArrBinaryTree {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(array);
        arrayBinaryTree.preOrder(0);
    }



}

class ArrayBinaryTree{

    private int array[];

    public ArrayBinaryTree(int [] array){
        this.array =array;
    }

    public void preOrder(int index){
        if(array == null && array.length == 0){
            return;
        }
        System.out.println(array[index]);

        if( (index * 2)+1 <array.length ){
            this.preOrder((index*2)+1);
        }
        if(index * 2 +2 <array.length){
            this.preOrder(index*2+2);
        }
    }
}

