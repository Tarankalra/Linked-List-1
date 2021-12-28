public class CycleInLL {

    // TC - O(n)
    // Space - O(1)
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
        // finding the point where are meeting
        // running slow with 1 speed, fast with 2 speed
        // if they are equal at any point, then that means there's a cycle
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
