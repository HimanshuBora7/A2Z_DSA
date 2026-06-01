package LinkedList;

class Node {
    int data;
    Node next;

    Node(int data1) {
        this.data = data1;
        this.next = null;
    }

    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }
}

public class LL03 {
    private static Node convertToLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    private static void traversalLL(Node head) {
        Node mover = head;

        while (mover != null) {
            System.out.print("--> " + mover.data + "--> ");
            mover = mover.next;
        }
    }

    private static Node insertAtHead(Node head, int data) {

        Node newHead = new Node(data);

        newHead.next = head;
        return newHead;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        Node head1 = convertToLL(arr);
        System.out.println("head" + head1.data);

        Node head2 = insertAtHead(head1, 50);
        traversalLL(head2);
    }
}
