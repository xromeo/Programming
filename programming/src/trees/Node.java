package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Node<T> {
    private T data;
    public T getData() {
		return data;
	}

	private List<Node<T>> children;
    public List<Node<T>> getChildren() {
		return children;
	}

	public Node(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    void add(T data){
        Node<T> node = new Node<T>(data);
        this.children.add(node);
    }

    void add(Node<T> node){        
        this.children.add(node);
    }


    void remove(T data){
        this.children = this.children.stream().filter(node -> !node.data.equals(data)).collect(Collectors.toList());
    }
}
