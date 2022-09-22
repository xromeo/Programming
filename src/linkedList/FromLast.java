package linkedList;
import java.util.Objects;

public class FromLast<T> {

    Node<T> getFromLast(LinkedList<T> list, int n){
        Node<T> slow = list.getFirst();
        Node<T> fast = list.getFirst();


        while(n > 0){
            fast = fast.getNext();
            n--;
        }

        while(Objects.nonNull(fast.getNext())){
            slow = slow.getNext();
            fast = fast.getNext(); 
        }
        return slow;

    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.insertLast("data1");
        list.insertLast("data2");
        list.insertLast("data3");
        Node<String> mid = new FromLast<String>().getFromLast(list, 2);
        System.out.println(mid.getData());
    }
    
}
