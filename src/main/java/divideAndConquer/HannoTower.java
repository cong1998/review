package divideAndConquer;

public class HannoTower {

    public static void main(String[] args) {
         move(5,'A','B','C');
    }

    public static void move(int nums , char a , char b, char c){ //abc  acb abc
        if(nums == 1 ){
            System.out.println("汉诺塔从 "+ a +"移动到了 "+c);//1abc
        }else{

            move(nums - 1 ,a,c,b);//5-1acb  4-1abc 3-1acb 2-1abc
            System.out.println("汉诺塔从 "+ a +"移动到了 "+c);
            move(nums - 1,b,a,c);//3-1cab
        }
    }
}
