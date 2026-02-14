import java.util.*;

public class Binaryrev {

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void populate(Scanner scanner) {
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        boolean left = scanner.nextBoolean();
        if (left) {
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        boolean right = scanner.nextBoolean();
        if (right) {
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }

        System.out.println(indent + node.value);
        display(node.left, indent + "  ");
        display(node.right, indent + "  ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Binaryrev tree = new Binaryrev();
        tree.populate(scanner);
        tree.display();
    }
}
