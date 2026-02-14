public class SinglyLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    // Constructor
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    // 1️⃣ Insert at Beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // 2️⃣ Insert at End
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    // 3️⃣ Insert at Position (0-based index)
    public void insertAtPosition(int data, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 0) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    // 4️⃣ Delete from Beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        head = head.next;
        size--;
    }

    // 5️⃣ Delete from End
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        size--;
    }

    // 6️⃣ Delete by Value
    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == value) {
            head = head.next;
            size--;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Value not found");
        } else {
            temp.next = temp.next.next;
            size--;
        }
    }

    // 7️⃣ Search
    public boolean search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value)
                return true;
            temp = temp.next;
        }
        return false;
    }

    // 8️⃣ Get Size
    public int getSize() {
        return size;
    }

    // 9️⃣ Reverse List
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    // 🔟 Find Middle (Slow-Fast Pointer)
    public int findMiddle() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    // 1️⃣1️⃣ Display List
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // 1️⃣2️⃣ Clear List
    public void clear() {
        head = null;
        size = 0;
    }

    // Main method for testing
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtBeginning(5);
        list.insertAtPosition(15, 2);

        list.display();  // 5 -> 10 -> 15 -> 20 -> null

        list.deleteByValue(15);
        list.display();  // 5 -> 10 -> 20 -> null

        System.out.println("Size: " + list.getSize());
        System.out.println("Search 10: " + list.search(10));
        System.out.println("Middle: " + list.findMiddle());

        list.reverse();
        list.display();  // 20 -> 10 -> 5 -> null
    }
}
