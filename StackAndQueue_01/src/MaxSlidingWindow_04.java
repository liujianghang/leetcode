import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow_04 {
    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 返回 滑动窗口中的最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        // 存放结果元素的数组
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int num = 0;
        // 自定义队列
        MyQueue1 myQueue1 = new MyQueue1();
        // 先将前k个元素放入到队列中
        for (int i = 0; i < k; i++) {
            myQueue1.add(nums[i]);
        }
        res[num++] = myQueue1.peek();
        for (int i=k;i<nums.length;i++){
            // 去掉滑动框首的数
            myQueue1.poll(nums[i-k]);
            // 加入滑动框尾的数
            myQueue1.add(nums[i]);
            // 记录一次更新后的队首最大值(从队列中获取)
            res[num++] = myQueue1.peek();
        }
        return res;
    }
}

class MyQueue1 {
    Deque<Integer> deque = new LinkedList<>();

    //弹出元素时，比较当前窗口要弹出的数值是否等于队列出口的数值，如果相等则说明是那个最大的元素在队列首，则弹出
    //同时判断队列当前是否为空
    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
    //保证队列元素单调递减
    //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.pollLast();
        }
        deque.offer(val);
    }

    //队列队顶元素始终为最大值
    int peek() {
        return deque.peek();
    }
}
