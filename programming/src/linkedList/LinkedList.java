package linkedList;
import java.util.Objects;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    void insertFirst(T data) {
        Node<T> node = new Node<T>(data, this.head);
        if (Objects.isNull(head)) {
            this.tail = node;
        }
        this.head = node;
    }

    void insertLast(T data) {
        Node<T> node = new Node<T>(data, null);
        if (Objects.isNull(head)) {
            this.head = node;
        } else {
            this.tail.setNext(node);
        }

        this.tail = node;
    }


    int size(){
        int c = 0;
        Node<T> node = head;
        while(Objects.nonNull(node)){
            c++;
            node = node.getNext();
        }
        return c;
    }

    Node<T> getFirst(){
        return this.head;
    }

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.insertFirst("Hola");
        linkedList.insertFirst("Zoe");
        linkedList.insertLast("Rivera");

        System.out.println("s1:" + linkedList.size());
        LinkedList<String> linkedList2 = new LinkedList<>();
        linkedList2.insertLast("Rivera");
        System.out.println("s2:" + linkedList2.size());
    }
}
