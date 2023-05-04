import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue1; // 和栈中保持一样序列和方向的队列
    Queue<Integer> queue2; // 辅助队列

    /**
     * Returns whether the queue is empty.
     */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     * 压入元素(添加)：add()、offer() 在超出容量时，add()方法会对抛出异常，offer()返回false
     */
    public void push(int x) {
        queue2.offer(x); // 先将新元素放在辅助队列中
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> queueTemp;
        queueTemp = queue1;
        queue1 = queue2;
        queue2 = queueTemp;
    }
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll(); // 因为queue1中的元素和栈中的保持一致，所以这个和下面两个的操作只看queue1即可
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
