package sparseArray;

import java.io.*;

public class ChessToSparseArray {

    public static void main(String[] args) {

        //创建一个11*11的棋盘，并又一枚黑子和蓝子 ，1代表黑子，2蓝子
        int chess[][] = new int[11][11];
        chess[1][2] = 1;
        chess[2][3] = 2;
        chess[3][4] = 1;

        //   -->转为稀疏数组

        //遍历棋盘子数的数量，以便记录稀疏数组
        int sum = 0;  //记录个数
        for (int[] row : chess) {
            for (int data : row) {
                if (data != 0)
                    sum++;
            }
        }

        //创建稀疏数组,数组大小为[sum+1][3]
        int sparseArray[][] = new int[sum + 1][3];

        //  -->填充稀疏数组数据

        //填充第一行的数据
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        //填充真实数据
        int count = 0;
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                if (chess[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chess[i][j];
                }
            }
        }

        for(int i = 0; i < sparseArray.length; i++){
            System.out.printf("%d\t%d\t%d\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }

        //将稀疏数组写进文件
        try {
            File file = new File("D://sparseArray.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            OutputStream outputStream = new FileOutputStream(file);
            for(int[] row : sparseArray){
                for(int data : row){
                    outputStream.write(String.valueOf(data+ " ").getBytes());
                }
               //String line =  System.getProperty("line.separator");
               //outputStream.write(line.getBytes());
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //从文件中获取稀疏数组的值
        int[][] getSparseArray = getSparseArray();

        //转换成棋盘
        int[][] getchess = new int[getSparseArray[0][0]][getSparseArray[0][1]];
        for(int i = 1;i<getSparseArray.length;i++){
            getchess[getSparseArray[i][0]][getSparseArray[i][1]] = getSparseArray[i][2] ;
        }
        for(int[] row : getchess){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }


    public static int[][] getSparseArray(){
        File file = new File("D://sparseArray.txt");
        if(!file.exists())
            return null;
        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] fileByte = new byte[new Long(file.length()).intValue()];
            inputStream.read(fileByte);
            String parseArray = new String(fileByte);
          //  System.out.println("parseArray=\n"+parseArray);
            inputStream.close();

            String[] datas = parseArray.split(" ");
            int k=0;
            int[][] sparseArray = new int[Math.floorDiv(datas.length,3)][3];
            for(int i = 0;i<sparseArray.length;i++){
                for(int j=0;j<sparseArray[i].length;j++){
                    sparseArray[i][j]=Integer.parseInt(datas[k++]);
                }
            }
            return sparseArray;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
