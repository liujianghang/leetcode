package day1;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {
    // TODO 因为是单链表，这题是很明显的快慢指针法
    //  用虚拟头节点还是可以方便的解题
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;
        // 设置快慢指针
        ListNode fastIndex = dumpHead;
        ListNode slowIndex = dumpHead;
        for (int i = 0; i < n; i++) {
            fastIndex = fastIndex.next;
        }
        while (fastIndex.next != null) {
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }
        slowIndex.next = slowIndex.next.next;
        return dumpHead.next; // 不可以是head 因为删除后dumpHead.next可能指向的是一个空值
    }
}
