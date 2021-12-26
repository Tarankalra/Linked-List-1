public class RemoveNthNodeFromLL {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // TC- O(n)
    // SC - O(1)
    // One pass solution
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        ListNode fast = head;
        int count = 1;

        // running loop so that there is difference between slow and the fast pointer
        // placing fast count distance apart from the head node
        while(count<=n && fast!=null) {
            fast = fast.next;
            count++;
        }

        ListNode slow = head;
        // if fast becomes null, that means it exceeded the number
        // e.g. for length 3 node, if we want to remove the nth element, that means fast will go null
        // that y doing head is head's next
        if(fast == null) {
            head = head.next;
            return head;
        }

        // traversing till fast's next doesnt move to null
        // because we want slow to be one step behind the n'th node, in order to maintain the link
        while(fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        // removing the nth node
        slow.next = slow.next.next;
        return head;
    }
}
