package recursion;


/**
 * 递归--->迷宫
 */
public class Labyrinth {

    public static void main(String[] args) {

        int [][] map = new int[8][7];

        //给地图添加围墙
        for(int i = 0 ;i<7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for(int j = 0;j<8;j++){
            map[j][0] = 1;
            map[j][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;

        findWay(map,1,1);
        System.out.println("该地图是：");
        for(int i = 0;i<8;i++){
            for(int j = 0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }


    }

    /**
     * //0表示没有走过的路   1 代表墙   2代表可以走通的路   3代表不能走通的路
     * @param map  地图
     * @param i   指定从哪儿开始寻找
     * @param j
     * @return
     */
    public static boolean findWay(int[][] map,int i,int j){

        //设定终点地址
        if(map[6][5] == 2){
            return true;
        }else{

            if(map[i][j] == 0){
                map[i][j] = 2;

                //设定行驶路径为下右上左
                if(findWay(map,i+1,j)){
                    return true;
                }else if(findWay(map,i,j+1)){
                    return true;
                }else if(findWay(map,i-1,j)){
                    return true;
                }else if(findWay(map,i,j-1)){
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else{
                return  false;
            }
        }

    }
}
