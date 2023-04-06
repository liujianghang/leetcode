package day1;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class SwapPairs {
    //TODO：有两个位置的索引，直接交换位置即可
    // 递归算法
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head; // 直接return这个head
        }
        ListNode next = head.next;
        ListNode nextnext = swapPairs(next.next);
        // 交换
        next.next = head;
        head.next = nextnext;
        return next;
    }

    // TODO 模拟算法 运用到了一个虚拟头节点 方便操作
    public ListNode swapPairs2(ListNode head){
        ListNode dumpHead = new ListNode(-1); //设置一个虚拟节点
        dumpHead.next = head;

        ListNode cur = dumpHead;
        ListNode temp; // 临时结点，用以保存两个结点后面的结点
        ListNode firstNode;
        ListNode secondNode;
        while (cur.next!=null&&cur.next.next!=null){
            firstNode = cur.next;
            secondNode = firstNode.next;
            temp = secondNode.next;
            cur.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = temp;
            cur = firstNode;
        }
        return dumpHead.next;
    }
}
