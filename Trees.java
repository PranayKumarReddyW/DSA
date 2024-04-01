import java.util.*;

public class Trees {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // levelOrderTraversal(root);
        // levelOrderTraversalLevelWise(root);
        // preOrderTraversal(root);
        // inOrderTraversal(root);
        // postOrderTraversal(root);
        // preOrderTraversalIterative(root);
        // inOrderTraversalIterative(root);
        // postOrderTraversalIterative(root);
        // System.out.println("Max Depth is : " + maxDepthOfBinaryTree(root));
        // System.out.println("No of Nodes : " + countNodes(root));
        // System.out.println("Sum of Nodes : " + sumOfNodes(root));
        // System.out.println("Level of Node 5 : " + getLevel(root, 5));
        // printSpecifiedLevel(root, 5);

    }

    public static void levelOrderTraversal(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            System.out.print(temp.data + " ");
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
        System.out.println();
    }

    static void levelOrderTraversalLevelWise(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                }

                q.add(null);
            } else {
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
        }
    }

    static void preOrderTraversal(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void inOrderTraversal(Node root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    static void postOrderTraversal(Node root) {
        if (root == null)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    static void preOrderTraversalIterative(Node root) {
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                System.out.print(curr.data + " ");
                curr = curr.left;
            }
            Node temp = st.pop();
            curr = temp.right;
        }
        System.out.println();
    }

    static void inOrderTraversalIterative(Node root) {
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            Node temp = st.pop();
            System.out.print(temp.data + " ");
            curr = temp.right;
        }
        System.out.println();
    }

    static void postOrderTraversalIterative(Node root) {
        if (root == null)
            return;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            Node temp = st1.pop();
            st2.push(temp);
            if (temp.left != null)
                st1.push(temp.left);
            if (temp.right != null)
                st1.push(temp.right);
        }
        while (!st2.isEmpty()) {
            System.out.print(st2.pop().data + " ");
        }
        System.out.println();
    }

    static int maxDepthOfBinaryTree(Node root) {
        if (root == null)
            return 0;
        return Math.max(maxDepthOfBinaryTree(root.left), maxDepthOfBinaryTree(root.right)) + 1;
    }

    static int countNodes(Node root) {
        if (root == null)
            return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    static int sumOfNodes(Node root) {
        if (root == null)
            return 0;
        return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
    }

    static int getLevel(Node root, int data) {
        if (root == null)
            return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 1;
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp == null) {
                level++;
                if (q.isEmpty()) {
                    return 0;
                }
                q.add(null);
            } else {
                if (temp.data == data) {
                    return level;
                }
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
        }
        return 0;
    }

    static void printSpecifiedLevel(Node root, int level) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        int treeLevel = 1;
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            if (treeLevel == level) {
                while (!q.isEmpty() && q.peek() != null) {
                    Node temp = q.remove();
                    System.out.print(temp.data + " ");
                }
            }
            Node temp = q.remove();
            if (temp == null) {
                treeLevel++;
                if (q.isEmpty()) {
                    break;
                }
                q.add(null);
            } else {
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
        }
    }
}