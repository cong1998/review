package linkedList;

import java.util.Deque;
import java.util.LinkedList;

public class CarNode {

    public static void main(String[] args) {
        CarList list = new CarList();
//        list.add(new Node(1,"兰博基尼"));
////        list.add(new Node(2,"宝马"));
////        list.show();

        list.addOrder(new Node(1,"兰博基尼"));
        list.addOrder(new Node(4,"宝马"));
        list.addOrder(new Node(2,"奔驰"));
        list.addOrder(new Node(3,"大众"));
//        list.show();
//        list.delNode(5);
//        System.out.println();
        list.show();
       // list.reverse();
        list.reversePrint();
       // System.out.println(list.getK(1));

    }

}

class Node{
     int no;
     String name;
     Node next;

     public Node(){

     }

     public Node(int no,String name){
         this.no=no;
         this.name = name;
     }


    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}


class CarList{

    private Node head;

    public CarList(){
        this.head = new Node();
    }

    public void add(Node node){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }

    public void show(){

        Node temp = head.next;

        while(temp!=null){
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void addOrder(Node node){
        Node temp = head;
        boolean falg = false;
        while(temp.next != null){
            if(temp.next.no>node.no){
                break;
            }else if(temp.next.no == node.no){
                falg = true;
                break;
            }
            temp = temp.next;
        }
        if(falg){
            System.out.println("node已存在");
        }else{
            node.next = temp.next;
            temp.next = node;
        }

    }


    public void delNode(int no){
        Node temp = head;
        boolean falg = false;
        while(temp.next != null){
            if(temp.next.no == no){
                falg = true;
                break;
            }
            temp = temp.next;
        }
        if(falg){
           temp.next = temp.next.next;
        }else{
            System.out.println("没有找到要删除的节点");
        }
    }

    public int size(){
        Node temp = head.next;

        int count = 0;
        while(temp !=null){
            count ++;
            temp = temp.next;
        }
        return count;
    }


    //获取倒数第k个节点
    public Node getK(int k){
        int size = size();
        Node temp = head;
        int i = 0;
        while(temp.next !=null){
            if(i == (size-k)){
                return temp.next;
            }
            i++;
            temp = temp.next;
        }
        return null;
    }

    //单链表反转
    public void reverse(){
        Node cur = head.next;
        Node reverseNode = new Node();
        Node next = null;

        while(cur!= null){
            next = cur.next;
            cur.next = reverseNode.next;
            reverseNode.next = cur;
            cur = next;
        }
        head.next = reverseNode.next;
    }


    public void reversePrint(){

        Deque<Node> deque = new LinkedList<>();
        Node temp = head;
        while(temp.next != null){
            deque.push(temp.next);
            temp = temp.next;
        }

        while(deque.size()>0){
            System.out.println(deque.pop());
        }
    }
}