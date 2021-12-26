// Time Complexity : O(n)
// Space Complexity : O(n) - by Recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class ReverseLinkedList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static ListNode tail = null;
    public ListNode reverseList(ListNode head) {
        return reverseLinkedListHelper(head);
    }

    public static ListNode reverseLinkedListHelper(ListNode head) {
        if(head == null || head.next == null) {
            tail = head;
            return head;
        }
        // Saving the reversed linked list pointer in another variable
        ListNode head1 = reverseLinkedListHelper(head.next);

        // Creating link between the tail of the reversed linked list and the head of the current list
        tail.next = head;
        // updating tail
        tail = head;
        tail.next = null;
        // new head is the reversed linked list's head
        return head1;
    }
}
