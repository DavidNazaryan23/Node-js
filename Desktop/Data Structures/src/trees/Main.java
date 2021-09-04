package trees;

public class Main {

    public static void main(String[] args) {

        BST tree = new BST();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);

        tree.printTreeInOrder();
        System.out.println();

        System.out.println(tree.treeGet(30));
        System.out.println(tree.treeGetMin());
        System.out.println(tree.treeGetMax());

        System.out.println();
        tree.delete(22);
        tree.printTreeLevelOrder();



//        tree.printTreePreOrder();
//        System.out.println();
//        tree.printTreePostOrder();
//        System.out.println();
//        tree.printTreeLevelOrder();
    }
}
