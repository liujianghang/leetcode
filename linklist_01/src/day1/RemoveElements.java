package day1;

public class RemoveElements {
    /**
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     * 题意：删除链表中等于给定值 val 的所有节点。
     * 示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
     * 示例 2： 输入：head = [], val = 1 输出：[]
     * 示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
     */
    public ListNode removeElementss(ListNode head, int val) {
        // TODO: 重点就在于找到前驱
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 删除过程
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.next.val == val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
