package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

   private Node root;

    public void insert(int value){
        if(root == null){
            root = new Node(value);
        } else {

            root.insert(value);



        }
    }

    public void printTreeInOrder(){
        if (root==null){
            System.out.println("Nothing");
            return;
        }

        root.printInOrder();
    }

    public void printTreePreOrder(){
        if (root==null){
            System.out.println("Nothing");
            return;
        }

        root.printPreOrder();
    }

    public void printTreePostOrder(){
        if (root==null){
            System.out.println("Nothing");
            return;
        }

        root.printPostOrder();
    }

    public void printTreeLevelOrder()
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty())
        {

            Node tempNode = queue.poll();
            System.out.println(tempNode.getValue() + " ");

            if (tempNode.getLeft() != null) {
                queue.add(tempNode.getLeft());
            }

            if (tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
            }
        }
    }


    public Node treeGet (int value){
        return root.get(value);
    }

    public int treeGetMin(){
        return root.min();
    }
    public int treeGetMax(){
        return root.max();
    }


    public void delete(int value){
        root = delete(root,value);
      }

    private Node delete(Node subTree, int value){
        if(subTree==null){
            return null;
        }

        if(value<subTree.getValue()){
            subTree.setLeft(delete(subTree.getLeft(),value));
        } else if(value>subTree.getValue()){
            subTree.setRight(delete(subTree.getRight(),value));
        } else {
            //1 child or no children
            if(subTree.getLeft()==null){
                return subTree.getRight();
            } else if(subTree.getRight() == null){
                return subTree.getLeft();
            }


            //2 childs. find the min value of the right subtree, assign it to the node that
            //needs to be deleted. delete the min node of the right subtree
            subTree.setValue(subTree.getRight().min());
            subTree.setRight(delete(subTree.getRight(),subTree.getValue()));




        }


        return subTree;



    }

}
