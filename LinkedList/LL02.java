//insertion deletion in linked list 

package LinkedList;

class Node {
    int data;
    Node next;

    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
    }
}

public class LL02 {

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

    private static Node deleteHead(Node head) {
        Node temp = head;
        head = head.next;
        System.out.println(temp.data + " deleted");
        temp.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        Node head1 = convertToLL(arr);

        System.out.println(head1.data);
        traversalLL(head1);

        Node head2 = deleteHead(head1);
        System.out.println(head2.data);
        traversalLL(head2);
    }
}
