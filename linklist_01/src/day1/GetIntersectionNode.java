package day1;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 */
public class GetIntersectionNode {
    // TODO:这里的关键是要找到指针相等的那个结点，而不是数值相等
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        // 首先需要求两个链表各自的长度
        int lenA = 0, lenB = 0;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        // 比较A和B的链表的长度 让A为最长链表的头 lenA为其长度
        if (lenB > lenA) {
            // 1. swap (lenA,lenB)
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            // 2. swap (curA,curB)
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        // 求长度查
        int gap = lenA - lenB;
        // 让curA和curB在同一起点上(末尾对其)
        while (gap > 0) {
            curA = curA.next;
            gap--;
        }
        // 遍历curA和curB 有相同的则返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
