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

    private static void deleteTail(Node head) {
        if (head.next == null || head == null) {
            System.out.println("noting to delete");
            return;
        }
        Node mover = head;

        while (mover.next.next != null) {
            mover = mover.next;

        }
        System.out.println("deleted tail" + mover.next.data);
        mover.next = null;
    }

    private static void deleteKthElem(Node head, int k) {
        // assuming Kth element is not the first or last element of the linked list
        int count = 1;
        Node mover = head;
        Node temp = mover;
        while (count != k) {
            temp = mover;
            mover = mover.next;
            count++;
        }
        temp.next = mover.next;
        System.out.println("removed " + mover.data);
        mover.next = null;

    }

    // deleting a node with specific value

    private static void delelteVal(Node head, int k) {
        Node mover = head;
        Node temp = null;
        while (mover.data != k) {
            temp = mover;
            mover = mover.next;
        }
        if (mover != null) {
            temp.next = mover.next;
            System.out.println("deleted " + mover.data);
            mover.next = null;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        Node head1 = convertToLL(arr);

        // System.out.println(head1.data);
        // traversalLL(head1);

        // Node head2 = deleteHead(head1);
        // System.out.println(head2.data);
        // traversalLL(head2);
        // deleteTail(head1);

        // deleteKthElem(head1, 5);
        delelteVal(head1, 17);
        traversalLL(head1);

    }
}
