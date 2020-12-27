package tree;

public class BinaryTree {

    public static void main(String[] args) {
        Node root = new Node(1,"root");
        Node hero = new Node(2,"root");
        Node people = new Node(3,"root");
        Node teacher = new Node(4,"root");
        Node student = new Node(5,"root");
        Node norse = new Node(6,"root");
        root.leftChild = people;
        root.rightChild = hero;
        people.leftChild = teacher;
        people.rightChild = student;
        hero.rightChild = norse;

        BinaryTreeLinkedList list = new BinaryTreeLinkedList(root);

        list.preOrder();
    }

}

class BinaryTreeLinkedList{
    private Node root;

    public BinaryTreeLinkedList(Node root){
        this.root =root;
    }

    public void preOrder(){
        if(root != null)
            this.root.preOrder();
        else
            System.out.println("该树为空！");
    }

    public void postOrder(){
        if(root != null)
            this.root.postOrder();
        else
            System.out.println("该树为空！");
    }

    public void infixOrder(){
        if(root != null)
            this.root.infixOrder();
        else
            System.out.println("该树为空！");
    }

}

class Node{

    public int id;
    public String name;
    public Node leftChild;
    public Node rightChild;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void preOrder(){
        System.out.println(this);
        if(this.leftChild != null)
           this.leftChild.preOrder();
        if(this.rightChild != null)
           this.rightChild.preOrder();
    }

    public void postOrder(){
        if(this.leftChild != null)
        this.leftChild.postOrder();
        if(this.rightChild != null)
        this.rightChild.postOrder();
        System.out.println(this);
    }

    public void infixOrder(){
        if(this.leftChild != null)
        this.leftChild.infixOrder();
        System.out.println(this);
        if(this.rightChild != null)
        this.rightChild.infixOrder();
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


