public class BasicLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Single linked list
    static Node head = null;

    public static void main(String[] args) {
        // insertion:

        // insertAtHead(10);
        // printLL();
        // insertAtTail(100);
        // printLL();
        // insertAtPos(20, 2);
        // printLL();
        // insertBeforeVal(30, 100);
        // printLL();

        // deletion:

        // deleteHead();
        // printLL();
        // deleteTail();
        // printLL();
        // deletePos(3);
        // printLL();
        // deleteAtVal(1000);
        // printLL();

        // System.out.println(countLL());

        // middle element:
        // middleElement();

    }

    public static void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void insertAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public static void insertAtTail(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
    }

    public static void insertAtPos(int val, int pos) {
        if (head == null) {
            if (pos == 1) {
                head = new Node(val);
                return;
            }
            return;
        }
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            if (count == pos - 1) {
                Node newNode = new Node(val);
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            }
            temp = temp.next;
        }
    }

    public static void insertBeforeVal(int data, int val) {
        // data --> the data to be inserted
        // val --> before this val

        if (head.data == val) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.next.data == val) {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            }
            temp = temp.next;
        }
    }

    public static void deleteHead() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        head = head.next;
    }

    public static void deleteTail() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public static void deletePos(int pos) {
        if (head == null) {
            return;
        }
        if (pos == 1) {
            head = head.next;
            return;
        }
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == pos - 1) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    public static void deleteAtVal(int val) {
        if (head == null) {
            return;
        }
        if (head.data == val) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == val) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    public static int countLL() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void middleElement() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
    }
}
