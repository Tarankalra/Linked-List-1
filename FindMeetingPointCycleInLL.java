public class FindMeetingPointCycleInLL {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // TC - O(n)
    // Space - O(1)
    // Floyd Cycle Detection Algorithm
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        // finding the point where are meeting
        // running slow with 1 speed, fast with 2 speed
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

        // we are resetting slow to head and fast will also run with same speed
        slow = head;
        while(slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }
        // where they meet that is the meeting point
        return slow;
    }
}
