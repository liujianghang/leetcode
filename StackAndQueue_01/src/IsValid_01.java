import java.util.Deque;
import java.util.LinkedList;

public class IsValid_01 {
    /** 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。**/
    public boolean isValid(String s){
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            // 碰到左括号，就把相应的右括号入栈
            if (ch=='('){
                deque.push(')');
            }else if (ch=='{'){
                deque.push('}');
            }else if (ch=='['){
                deque.push(']');
            }else if (deque.isEmpty()||deque.peek()!=ch){ // 如果是空的，或者不匹配的情况
                return false;
            }else { // 匹配的情况
                 deque.pop();
            }
        }
        // 最后判断栈中的元素是否匹配
        return deque.isEmpty();
    }
}
