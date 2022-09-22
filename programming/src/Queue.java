import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Stack;

public class Queue<T> {

    Stack<T> one;
    Stack<T> two;

    public Queue() {
        one = new Stack<T>();
        two = new Stack<T>();
    }

    T remove() {
        if (one.empty()) {
            throw new NoSuchElementException();
        }
        move(one, two);
        T value = two.pop();
        move(two, one);
        return value;
    }

    T peek() {
        move(one, two);
        try {
            T value = two.peek();
            move(two, one);
            return value;
        } catch (EmptyStackException e) {

        }

        return null;
    }

    private void move(Stack<T> a, Stack<T> b) {
        try {
            while (Objects.nonNull(a.peek())) {
                b.push(a.pop());
            }
        } catch (EmptyStackException e) {

        }
    }

    void add(T value) {
        one.push(value);
    }

    void print() {
        move(one, two);
        try {
            while (Objects.nonNull(two.peek())) {
                System.out.println(two.peek());
                one.push(two.pop());
            }
        } catch (EmptyStackException e) {

        }

    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.add("1");
        q.add("2");
        q.add("3");
        q.print();

        while (Objects.nonNull(q.peek())) {
            System.out.println(q.remove());            
        }

    }
}
