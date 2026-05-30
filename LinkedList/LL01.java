package LinkedList;

// initialising ds for linked list which can store both the data and reference to the next element's node

class Node {
    int data;
    Node next;

    // two constructors if address of next node is passed and another one if the
    // adddress is not passed
    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    // what if only data is provided not the adddress then in that case we
    // initialize next with null
    Node(int data1) {
        this.data = data1;
        this.next = null;
    }
}

public class LL01 {

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

    private static void traversal(Node head) {
        Node mover = head;

        while (mover != null) {

            System.out.println("element of linked list " + mover.data);
            mover = mover.next;
        }

    }

    public static void main(String[] args) {

        int[] arr = { 10, 2, 3, 4 };

        Node y = new Node(arr[0]);
        System.out.println("data part " + y.data);
        System.out.println("addresss part " + y.next);

        // converting an array to linked list

        Node ans = convertToLL(arr);
        System.out.println("answer given by function " + ans.data);
        traversal(ans);
    }
}
