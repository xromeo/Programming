/*
 * Implement a queue using two stacks. Then process q queries, where each query is one of the following 3 types:

Enqueue element x into the end of the queue
Dequeue the element at the front of the queue
Print the element at the front of the queue
Example
Input
The first line contains a single integer, q, denoting the number of queries.

Each line i of the q subsequent lines contains a single query in the form described in the problem statement above. All three queries start with an integer denoting the query type, but only query 1 is followed by an additional space-separated value, x, denoting the value to be enqueued.

1 → enqueue
2 → dequeue
3 → print front of the queue

Output
For each query of type 3, print the value of the element at the front of the queue on a new line.

14
14
Explanation
Perform the following sequence of actions:

Enqueue 42; queue = {42}
Dequeue the value at the head of the queue, 42; queue = {}
Enqueue 14; queue = {14}
Print the value at the head of queue, 14; queue = {14}
Enqueue 28; queue = {14,28}
Print the value at the head of queue, 14; queue = {14,28}
Enqueue 60; queue = {14,28,60}
Enqueue 78; queue = {14,28,60,78}
Dequeue the value at the head of the queue, 14; queue = {28,60,78}
Dequeue the value at the head of the queue, 28; queue = {60,78}
 */

import java.io.*;
import java.util.*;

public class QueueTwoStacks {

    private static class StackQueue<T> {

        private Stack<T> stack = new Stack<>(), auxStack = new Stack<>();

        void enqueue(T elem) {
            stack.push(elem);
        }

        T dequeue() {
            if (auxStack.isEmpty()) {
                if (stack.isEmpty()) {
                    System.out.println("Queue underflow");
                    return null;
                }
                while (!stack.isEmpty()) {
                    auxStack.push(stack.pop());
                }
            }
            return auxStack.pop();
        }

        T peek() {
            if (auxStack.isEmpty()) {
                if (stack.isEmpty()) {
                    System.out.println("Queue underflow");
                    return null;
                }
                while (!stack.isEmpty()) {
                    auxStack.push(stack.pop());
                }
            }
            return auxStack.peek();
        }

    }

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        scan.nextLine(); // Gets rid of the newline char
        List<String> queries = new ArrayList<>(q);

        // Query gathering
        for (int i = 0; i < q; i++) {
            queries.add(scan.nextLine());
        }
        scan.close();

        // Query handling
        int type, val;
        StackQueue<Integer> queue = new StackQueue<>();

        for (String query : queries) {
            type = query.charAt(0);
            if (type == '1') {
                val = Integer.parseInt(query.substring(2));
                queue.enqueue(val);
            } else if (type == '2') {
                queue.dequeue();
            } else {
                System.out.println(queue.peek());
            }
        }
    }
}
