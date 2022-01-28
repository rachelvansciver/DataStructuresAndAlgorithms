public class TestBST {
    public static void main(String[] args) {
        Integer[] numbers = {5, -1, 9, 4, 0, -3, 7, 11, 14, 6, 8};
        BST<Integer> intTree = new BST<Integer>(numbers);
        System.out.println("Pre-order: ");
        intTree.preorder();
        System.out.println("\nIn-Order: ");
        intTree.inorder();
        System.out.println("\nPost-Order: ");
        intTree.postorder();

    }
}

