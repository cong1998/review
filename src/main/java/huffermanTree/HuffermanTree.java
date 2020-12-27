package huffermanTree;

import java.io.*;
import java.util.*;

public class HuffermanTree {

    public static void main(String[] args) {

        /*String content = "i like you";

        byte[] huffmanBytes = zip(content.getBytes());
        System.out.println(Arrays.toString(huffmanBytes));
        byte[] decodeHuffmanBytes = decode(huffmanBytes, codeTable);
        System.out.println(new String(decodeHuffmanBytes));
        */
        /*fileZip("e://image.jpg","e://image.zip");
        System.out.println("压缩成功~");*/

       decodeZip("e://image.zip","e://image2.jpg");
        System.out.println("解压成功~");
    }



    public static List<Node> createList(byte[] bytes){

        List<Node> nodes = new ArrayList<>();

        Map<Byte,Integer> map = new HashMap<>();
        for(byte b:bytes){
            Integer count = map.get(b);
            if(count == null){
                map.put(b,1);
            }else{
                map.put(b,count+1);
            }
        }

        for(Map.Entry<Byte,Integer> entry : map.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }

    public static Node createHuffermanTree(List<Node> nodes){

        while(nodes.size() > 1){

            Collections.sort(nodes);

            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            Node parent = new Node(null,leftNode.weight+rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parent);

        }
        return nodes.get(0);
    }



    static Map<Byte,String> codeTable = new HashMap<>();
    static StringBuilder sb = new StringBuilder();


    public static void getCode(Node node , String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if(node != null){
            if(node.data == null){
                getCode(node.left,"0",stringBuilder1);
                getCode(node.right,"1",stringBuilder1);
            }else{
                codeTable.put(node.data,stringBuilder1.toString());
            }
        }
    }

    public static Map<Byte,String> getCodeTable(Node root){
        if(root == null){
            return null;
        }
        getCode(root.left,"0",sb);
        getCode(root.right,"1",sb);
        return codeTable;
    }

    public static byte[] getHuffmanBytes(byte[] bytes,Map<Byte,String> huffmanCodeTable){

        StringBuilder sb = new StringBuilder();
        for(byte b : bytes){
            sb.append(huffmanCodeTable.get(b));
        }

        int len = (sb.length() + 7) / 8;

        byte[] huffmanBytes = new byte[len];
        String substr = "";
        int index = 0;
        for(int i = 0;i<sb.length();i+=8){
            if(i+8>sb.length()){
                substr = sb.substring(i);
            }else{
                substr = sb.substring(i,i+8);
            }
            //补码
            huffmanBytes[index] = (byte)Integer.parseInt(substr,2);
            index++;
        }
        return huffmanBytes;
    }


    public static byte[] zip(byte[] bytes){
        List<Node> nodes = createList(bytes);
        Node huffmanTreeRoot = createHuffermanTree(nodes);
        Map<Byte, String> codeTable = getCodeTable(huffmanTreeRoot);
        byte[] huffmanBytes = getHuffmanBytes(bytes, codeTable);
        return huffmanBytes;
    }


    public static String byteToBitString(boolean flag,byte b){

        int temp = b;
        if(flag){
            temp |= 256;
        }
        //补码
        String binaryString = Integer.toBinaryString(temp);
        if(flag){
            return binaryString.substring(binaryString.length()-8);
        }else{
            return binaryString;
        }

    }


    public static byte[] decode(byte[] huffmanBytes , Map<Byte,String> huffmanCodeTable){

        Map<String,Byte> map = new HashMap<>();
        for(Map.Entry<Byte,String> entry : huffmanCodeTable.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(int i =0;i<huffmanBytes.length;i++){
            flag = i==huffmanBytes.length-1;
            String bitString = byteToBitString(!flag, huffmanBytes[i]);
            sb.append(bitString);
        }

        List<Byte> list = new ArrayList<>();
        for(int i = 0;i<sb.length();){
            int count =1;
            Byte value;
            while(true){
                String s;
                if(i+count>sb.length()) {
                    s =sb.substring(i);
                    value = map.get(s);
                    if(value == null){
                        break;
                    }
                }else{
                    s = sb.substring(i, i + count);
                }

                value = map.get(s);
                if(value == null){
                    count++;
                }else{
                    break;
                }
            }
            list.add(value);
            i +=count;
        }

        byte[] bytes = new byte[list.size()];
        for(int i = 0;i<list.size();i++){
            if(list.get(i) != null)
            bytes[i]=list.get(i);
        }
        return bytes;
    }


    public static void fileZip(String srcPath,String dtcPath){

        OutputStream os =null;
        InputStream is = null;
        ObjectOutputStream oos = null;
        try{

            is = new FileInputStream(srcPath);
            byte [] srcBytes = new byte[is.available()];
            is.read(srcBytes);

            byte[] huffmanBytes = zip(srcBytes);

            os = new FileOutputStream(dtcPath);
            oos = new ObjectOutputStream(os);
            oos.writeObject(huffmanBytes);
            oos.writeObject(codeTable);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                is.close();
                oos.close();
                os.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }


    public static void decodeZip(String srcPath,String dtcPath){
        InputStream is = null;
        OutputStream os = null;
        ObjectInputStream ois = null;
        try{
            is = new FileInputStream(srcPath);
            ois = new ObjectInputStream(is);
            byte[] huffmanBytes = (byte[])ois.readObject();
            Map<Byte,String> huffmanCodes = (Map<Byte,String>)ois.readObject();

            byte[] decodeSrc = decode(huffmanBytes, huffmanCodes);


            os = new FileOutputStream(dtcPath);
            os.write(decodeSrc);



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                os.close();
                ois.close();
                is.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class Node implements Comparable<Node>{
    public Byte data;
    public int weight;
    public Node left;
    public Node right;

    public Node(Byte data,int weight){
        this.data =data;
        this.weight =weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(Node node) {
        return this.weight - node.weight;
    }
}
