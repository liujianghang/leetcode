import java.util.Stack;

class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    /** Initialize your data structure here. */
    public MyQueue(){
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    /** Initialize your data structure here. */
    public void push(int x){
        stackIn.push(x);
    }
    /** Removes the element from in front of queue and returns that element. */
    public int pop(){
        dumpstackIn();
        return stackOut.pop();
    }
    /** Get the front element. */
    /** Stack的peek方法是返回栈顶的元素但不移除它 **/
    public int peek(){
        dumpstackIn();
        return stackOut.peek();
    }
    /** Returns whether the queue is empty. */
    public boolean empty(){
        return stackIn.isEmpty()&& stackOut.isEmpty();
    }
    /** 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中 **/
    private void dumpstackIn(){
        if (!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }
}
