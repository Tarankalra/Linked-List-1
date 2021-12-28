public class FindMeetingPointCycleInLL {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Floyd Cycle Detection Algorithm
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
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

        if(!hasCycle) {
            return null;
        }

        slow = head;
        while(slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
