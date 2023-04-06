package day1;

import javax.crypto.Cipher;

public class MyLinkedList2 {
    int size;
    // 记录虚拟头节点和虚拟尾结点
    ListNode2 head, tail;

    public MyLinkedList2(int size, ListNode2 head, ListNode2 tail) {
        this.size = 0;
        this.head = new ListNode2(0);
        this.tail = new ListNode2(0);
        // 把头节点和尾结点链接
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        //判断index是否有效
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode2 cur = head;
        // 判断从哪一边开始查找更快
        if (index >= size / 2) {
            // tail开始
            cur = tail;
            for (int i = 0; i < size - index; i++) {
                cur = cur.prev;
            }
        } else {
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        //等价于在第0个元素前添加
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        //等价于在最后一个元素(null)前添加
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        //index大于链表长度
        if (index > size) {
            return;
        }
        //index小于0
        if (index < 0) {
            index = 0;
        }
        size++;
        //找到前驱
        ListNode2 pre = head;
        for (int i = 0; i < index; i++) {

            pre = pre.next;
        }
        //新建结点
        ListNode2 newNode = new ListNode2(val);
        newNode.next = pre.next;
        pre.next.prev = newNode;
        newNode.prev = pre;
        pre.next = newNode;

    }

    public void deleteAtIndex(int index) {
        //判断索引是否有效
        if (index < 0 || index >= size) {
            return;
        }
        //删除操作
        size--;
        ListNode2 pre = this.head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next.next.prev = pre;
        pre.next = pre.next.next;
    }
}
