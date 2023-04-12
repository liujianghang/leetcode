package day1;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 */
public class DetectCycle {
    // TODO:这题是很明显的快慢指针的方法 如果有环 快慢指针一定会相遇
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            // slow 一次走一步 fast一次走两步
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast){ // 有环必会相遇
                ListNode index1 = fast;
                ListNode index2 = head;
                // 根据等式公式得到的，两个指针，从头节点和相遇节点，个走一步，直到相遇，即为环入口
                while (index1!=index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
