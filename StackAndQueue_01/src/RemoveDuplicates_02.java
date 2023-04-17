import java.util.ArrayDeque;

public class RemoveDuplicates_02 {
    /**
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     */
    public String removeDuplicates(String S){
        // TODO:本题用栈最好实现
        ArrayDeque<Character> deque = new ArrayDeque<>();
        char ch;
        for (int i = 0; i < S.length(); i++) {
            ch =S.charAt(i);
            if (deque.isEmpty()||deque.peek()!=ch){
                deque.push(ch);
            }else {
                deque.pop();
            }
        }
        String str = "";
        while (!deque.isEmpty()){
            str = deque.pop()+str;
        }
        return str;
    }
}
