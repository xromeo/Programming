import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Weave {
    public static void main(String[] args) {
        Queue<String> q1 = new LinkedList<>();
        q1.add("Omar");
        q1.add("Zoe");
        q1.add("Gabriel");
        q1.add("Lourdes");
        q1.add("Omar");
        System.out.println(q1);
        Queue<String> q2 = new LinkedList<>();
        q2.add("Marlene");
        q2.add("Fabricio");
        q2.add("Alejandro");
        q2.add("Sophia");
        System.out.println(q2);

		new Weave().weave(q1, q2);

    }

    void weave(Queue<String> q1, Queue<String> q2){
   
        Queue<String> q3 = new LinkedList<>();
        while(Objects.nonNull(q1.peek()) && Objects.nonNull( q2.peek())){
            q3.add(q1.remove());
            q3.add(q2.remove());
        }
        while(Objects.nonNull(q1.peek())){
            q3.add(q1.remove());           
        }
        while(Objects.nonNull( q2.peek())){           
            q3.add(q2.remove());
        }
        System.out.println(q3);

    }

}
