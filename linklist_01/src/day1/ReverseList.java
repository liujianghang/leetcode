package day1;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 * .
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        // TODO  双指针法 不需要重新定义一个内存空间，只需要改变索引的方向
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        // TODO 递归的方法(依次对相邻的结点进行操作)
        return reverse(null, head);
    }

    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev; // prev已经是最后一个节点了
        }
        ListNode temp = null;
        temp = cur.next;
        cur.next = prev;
        return reverse(cur, temp);
    }
}
