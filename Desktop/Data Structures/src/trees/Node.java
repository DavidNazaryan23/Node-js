package trees;

import java.util.LinkedList;
import java.util.Queue;

public class Node {

    private int value;
    private Node left;
    private Node right;


    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }


    public void insert(int value){
        if(value == this.value){
            return;
        }
        if(value<this.value){
            if(left == null){
                left = new Node(value);
            } else {
              left.insert(value);
            }
        } else {

            if(right==null){
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }



    }

    public void printInOrder(){

        if(left!=null){
            left.printInOrder();
        }
        System.out.println(this.value);
        if(right!=null){
            right.printInOrder();
        }
    }

    public void printPreOrder(){

        System.out.println(this.value);
        if(left!=null){
            left.printPreOrder();
        }

        if(right!=null){
            right.printPreOrder();
        }
    }

    public void printPostOrder(){


        if(left!=null){
            left.printPostOrder();
        }

        if(right!=null){
            right.printPostOrder();
        }
        System.out.println(this.value);
    }



    public Node get(int value){

        if(value == this.value ){
            return this;
        }

        if(value<this.value){
            if(left!=null){
                return left.get(value);
            }
        } else {
            if(right!=null){
                return right.get(value);
            }
        }


        return null;



    }






    public int min(){
        if(left==null){
            return value;
        }

        return left.min();



    }

    public int max(){
        if(right==null){
            return value;
        }

        return right.max();
    }

}
