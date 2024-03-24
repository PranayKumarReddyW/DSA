public class SingleLinkedListBasics {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        Node head = array2LL(arr);
        printLL(head);
        System.out.println(lengthOfLL(head));
        System.out.println(searchInLL(head, 5));
        head = deleteHead(head);
        printLL(head);
        head = deleteTail(head);
        printLL(head);
        head = array2LL(arr);
        head = deleteAtPosition(head, 5);
        printLL(head);
        head = insertAtHead(head, 0);
        printLL(head);
        head = insertAtTail(head, 6);
        printLL(head);
        head = insertBeforeK(head, 3, 21);
        printLL(head);
    }

    static Node array2LL(int arr[]) {
        Node head = new Node(-1);
        Node temp = head;
        for (int i = 0; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = temp.next;
        }
        return head.next;
    }

    static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static int lengthOfLL(Node head) {
        Node temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    static boolean searchInLL(Node head, int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    static Node deleteHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        return head.next;
    }

    static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;

        }
        temp.next = null;
        return head;
    }

    // 1 based indexing and the position is valid
    static Node deleteAtPosition(Node head, int pos) {
        if (pos == 1) {
            return deleteHead(head);
        }
        Node temp = head;
        int count = 1;
        while (count != pos - 1) {
            temp = temp.next;
            count++;
        }
        temp.next = temp.next.next;
        return head;
    }

    static Node insertAtHead(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            return newNode;
        }
        Node temp = head;
        newNode.next = temp;
        return newNode;
    }

    static Node insertAtTail(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            return newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    static Node insertBeforeK(Node head, int K, int val) {
        Node newNode = new Node(val);
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == K) {
                newNode.next = temp.next;
                temp.next = newNode;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }

}
