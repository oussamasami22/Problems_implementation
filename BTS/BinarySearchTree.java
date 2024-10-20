package BTS;

public class BinarySearchTree {

    private Node root;

    // Constructor to initialize the tree as empty
    public BinarySearchTree() {
        root = null;
    }

    // Public method to insert a key
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Public method to search for a key
    public Node search(int key) {
        return searchRec(root, key);
    }

    // Public method to delete a key
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    // Method for in-order traversal of the tree
    public void inorder() {
        inorderRec(root);
    }

    // Recursive method to insert a key in the tree
    private Node insertRec(Node root, int key) {
        // If the tree is empty, create a new node and return it
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Recur down the tree
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        // Return the unchanged node pointer
        return root;
    }

    // Recursive method to search a key in the tree
    private Node searchRec(Node root, int key) {
        // Base case: root is null or key is present at root
        if (root == null || root.key == key) {
            return root;
        }

        // Key is smaller than root's key
        if (key < root.key) {
            return searchRec(root.left, key);
        }

        // Key is greater than root's key
        return searchRec(root.right, key);
    }

    // Recursive method to delete a key from the tree
    private Node deleteRec(Node root, int key) {
        // Base case: if the tree is empty
        if (root == null) {
            return root;
        }

        // Recur down the tree
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    // Method to find the smallest value in the right subtree (inorder successor)
    private int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    // Recursive method for in-order traversal of the tree
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
}
