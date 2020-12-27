package recursion;

public class EightQueen {

    int max = 8;
    int[] array = new int[max];
    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.check(0);
    }

    public void check(int n){
        if(n == max){
            print();
            return;
        }
        for(int i = 0;i<max;i++){
            array[n] = i;
            if(judge(n)){
                check(n+1);
            }
        }
    }

    public void print(){

        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public boolean judge(int n){

        for(int i = 0;i<n;i++){
            if(array[n] == array[i] || Math.abs(n - i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }
}
