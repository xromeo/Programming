package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class Tree<T> {

    Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public Tree() {

    }

    public Tree(Node<T> node) {
        this.root = node;
    }

    public void breadthFirstSearch() {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(this.root);

        while (queue.size() > 0) {
            Node<T> node = queue.poll();
            System.out.println("Node:" + node.getData());
            queue.addAll(node.getChildren());
        }
    }

    public void depthFirstSearch() {
        Stack<Node<T>> stack = new Stack<>();
        stack.push(this.root);

        while (stack.size() > 0) {
            Node<T> node = stack.pop();
            System.out.println("Node:" + node.getData());
            Collections.reverse(node.getChildren());
            stack.addAll(node.getChildren());
        }
    }

    public void levelWidth() {
        List<Integer> counters = new ArrayList<>();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(this.root);
        Node<T> stop = new Node<T>(null);
        queue.add(stop);

        int count = 0;
        while (queue.size() > 0) {
            Node<T> node = queue.poll();

            if (Objects.isNull(node.getData()) && count > 0) {

                counters.add(count);
                count = 0;
                queue.add(stop);

            } else {
                count++;
                System.out.println("Node:" + node.getData());
                queue.addAll(node.getChildren());
            }
        }

        counters.stream().forEach(c -> System.out.println(c + "\t"));
    }

    public void height() {

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(this.root);

        int height = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size > 0) {
                Node<T> node = queue.poll();
                queue.addAll(node.getChildren());
                size--;
            }
            height++;
        }

        System.out.println("height:" + height);
    }

    public int height(Node<T> root) {

        if (root == null) {
            return 0;
        }

        int ht = 0;
        for (int i = 0; i < root.getChildren().size(); i++) {
            int h = height(root.getChildren().get(i));
            if (ht < h) {
                ht = h;
            }
        }     
        // recur for the left and right subtree and consider maximum depth
        return 1 + ht;
    }

    public static void main(String[] args) {
        Node<String> node = new Node<String>("root");
        Node<String> node1 = new Node<String>("child1");
        Node<String> node2 = new Node<String>("child2");
        Node<String> node3 = new Node<String>("child3");

        Node<String> node11 = new Node<String>("child11");
        Node<String> node12 = new Node<String>("child12");
        Node<String> node31 = new Node<String>("child31");
        Node<String> node32 = new Node<String>("child32");

        Node<String> node321 = new Node<String>("child321");

        node.add(node1);
        node.add(node2);
        node.add(node3);

        node1.add(node11);
        node1.add(node12);

        node3.add(node31);
        node3.add(node32);

        node32.add(node321);

        Tree<String> tree = new Tree<>(node);
        tree.breadthFirstSearch();

        System.out.println();

        tree.depthFirstSearch();

        System.out.println();

        tree.levelWidth();
        tree.height();

        System.out.println(tree.height(tree.getRoot()));
    }

}
