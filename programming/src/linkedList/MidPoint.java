package linkedList;
import java.util.Objects;

public class MidPoint<T> {

    Node<T> getMidPoint(LinkedList<T> list){
        Node<T> slow = list.getFirst();
        Node<T> fast = list.getFirst();

        while(Objects.nonNull(fast.getNext()) && Objects.nonNull(fast.getNext().getNext())){
            slow = slow.getNext();
            fast = fast.getNext().getNext(); 
        }
        return slow;

    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.insertLast("data1");
        list.insertLast("data2");
        Node<String> mid = new MidPoint<String>().getMidPoint(list);
        System.out.println(mid.getData());
    }
    
}
