package circleSingleLinkedList;

public class CircleLinkedList {

    public static void main(String[] args) {
        CircleList list = new CircleList();
        list.addChild(5);
        //list.show();
        list.contChild(1,2,5);
    }

}


class Node{
     int no;
     Node next;

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}

class CircleList{

    private Node first;

    public void addChild(int nums){

        if(nums < 1){
            System.out.println("输入有误！");
            return;
        }
        Node current = null;
        for(int i = 1;i <= nums;i++){
            Node child = new Node(i);
            if(i==1){
                first = child;
                current = first;
                first.next = first;
            }else{
                current.next=child;
                child.next = first;
                current = child;
            }

        }
    }

    public void show(){
        if(first == null){
            System.out.println("一个孩子都没有~~");
            return;
        }
        Node temp = first;
        while(temp!=null){
            System.out.println(temp);
            if(temp.next == first){
                break;
            }
            temp = temp.next;
        }
    }


    /**
     *约瑟夫
     * @param k   从第几个开始数
     * @param count   数多少个
     * @param nums    总人数多少
     */
    public void contChild(int k,int count,int nums){

        if(nums<count || k>nums){
            System.out.println("输入有误");
            return ;
        }

        Node helper = null;
        Node temp = first;

        //将helper位移至最后一个节点
        while(true){
            if(temp.next == first){
                helper = temp;
                temp = temp.next;
                break;
            }
            temp = temp.next;
        }

        //向后移动k-1位
        for(int i = 0;i<k-1;i++){
            temp = temp.next;
            helper = helper.next;
        }

        //开始报数count-1，
        while(true){
            if(temp == helper){
                break;
            }

            for(int j = 0;j<count - 1;j++){
                temp = temp.next;
                helper = helper.next;
            }

            System.out.println(temp);
            temp = temp.next;
            helper.next = temp;
        }
        System.out.println("最后一个小孩："+temp);
    }
}