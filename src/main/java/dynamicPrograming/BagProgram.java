package dynamicPrograming;

import java.util.ArrayList;
import java.util.List;

public class BagProgram {

    public static void main(String[] args) {
        Product p1 = new Product("吉他",1500,1);
        Product p2 = new Product("小提琴",3000,4);
        Product p3 = new Product("钢琴",2000,3);

        Product[] pros = new Product[]{p1,p2,p3};

        List<Product> products = fill(pros, 4);

        System.out.println(products);


    }

    /**
     *
     * @param products
     * @param capacity 背包的容量
     * @return
     */
    public static List<Product> fill(Product[] products,int capacity){

        List<Product> list = new ArrayList<>();

        int[][] v = new int[products.length + 1][capacity + 1];
        for(int i = 0;i<capacity;i++){
            v[i][0] = 0;
            v[0][i] = 0;
        }

        int [][] path = new int[products.length + 1][capacity + 1];
        for(int i = 1;i<v.length;i++){
            for(int j = 1;j<v[i].length ; j++){

                if(products[i - 1].weight > j  ){
                    v[i][j] = v[i - 1][j];
                }else if(products[i - 1].weight <= j){
                    v[i][j] = Math.max(v[i - 1][j] ,products[i - 1].price + v[i - 1][j-products[i - 1].weight]);
                    if(v[i - 1][j] < products[i - 1].price + v[i - 1][j-products[i - 1].weight]){
                        path[i][j] = 1;
                    }
                }
            }
        }



        for(int i =0;i<v.length;i++){
            for(int j = 0;j<v[i].length;j++){
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }

        int i = path.length - 1;
        int j = path[0].length-1;

        while(j>0 && i > 0 ){
            if(path[i][j] == 1){
                list.add(products[i-1]);
                j = j - products[i-1].weight;
            }
            i--;
        }

        return list;
    }



}



class Product{

    public String name;
    public int price;

    public int weight;

    public Product(String name, int price,int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}