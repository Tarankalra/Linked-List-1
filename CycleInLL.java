public class CycleInLL {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // slow and fast pointers
    // where they meet, that means there's a loop
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                hasCycle = true;
                break;
            }
        }
        return hasCycle;
    }
}
