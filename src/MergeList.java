/**
 * MergeList
 * 
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 
Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeList {

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

       
        SinglyLinkedListNode head = null;
        SinglyLinkedListNode tail = null;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                if (head == null) {
                    head = head1;
                    tail = head1;
                } else {
                    tail.next = head1;
                    tail = tail.next;
                }
                head1 = head1.next;
            } else {
                if (head == null) {
                    head = head2;
                    tail = head2;
                } else {
                    tail.next = head2;
                    tail = tail.next;
                }
                head2 = head2.next;
            }
        }

        while (head1 != null) {
            tail.next = head1;
            tail = tail.next;

            head1 = head1.next;
        }

        while (head2 != null) {
            tail.next = head2;
            tail = tail.next;

            head2 = head2.next;
        }
        return head;

    }

    public static void main(String[] args) {

        SinglyLinkedListNode head1 = new SinglyLinkedListNode(1);
        head1.insert(3);
        head1.insert(7);
        SinglyLinkedListNode head2 = new SinglyLinkedListNode(1);
        head2.insert(2);

        MergeList.mergeLists(head1, head2);

    }
}

/**
 * SinglyLinkedListNode
 */
class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public void insert(int data) {
        SinglyLinkedListNode current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new SinglyLinkedListNode(data);
    }

}