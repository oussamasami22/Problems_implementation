package BTS;
public class Main {
    public static void main(String[] args) {
        // Create a Binary Search Tree instance
        BinarySearchTree bst = new BinarySearchTree();

        // Insert nodes into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Print the tree in-order (will print nodes in sorted order)
        System.out.println("In-order traversal:");
        bst.inorder();
        System.out.println();

        // Search for a key in the tree
        int searchKey = 40;
        Node searchResult = bst.search(searchKey);
        if (searchResult != null) {
            System.out.println("Key " + searchKey + " found in the tree.");
        } else {
            System.out.println("Key " + searchKey + " not found in the tree.");
        }

        // Delete a node from the tree
        bst.delete(20);
        System.out.println("In-order traversal after deleting 20:");
        bst.inorder();
        System.out.println();

        // Delete another node
        bst.delete(30);
        System.out.println("In-order traversal after deleting 30:");
        bst.inorder();
        System.out.println();

        // Delete another node
        bst.delete(50);
        System.out.println("In-order traversal after deleting 50:");
        bst.inorder();
    }
}
