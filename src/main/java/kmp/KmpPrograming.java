package kmp;

public class KmpPrograming {

    public static void main(String[] args) {
        String str1= "abbdabd";
        String str2 = "abd";
        int index = kmpPrograming(str1, str2);
        System.out.println(index);
    }


    public static int kmpPrograming(String str1,String str2){

        int[] next = kmpNext(str2);

        for(int i =0,j=0;i<str1.length();i++){

            while(j>0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }

            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }

            if(j == str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }


    public static int[] kmpNext(String str){

        int next[] = new int[str.length()];
        next[0] = 0;

        for(int i = 1,j=0;i<str.length();i++){

            while(j>0 && str.charAt(i) != str.charAt(j)){
                j = next[ j - 1 ];
            }

            if(str.charAt(i) == str.charAt(j)){
                j++;
            }

            next[i] = j;
        }
        return next;
    }
}
