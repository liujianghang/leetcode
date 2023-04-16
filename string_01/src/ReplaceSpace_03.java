public class ReplaceSpace_03 {
    /*请实现一个函数，把字符串 s 中的每个空格替换成"%20"*/
    public String replaceSpace(String s){
        //TODO 时间和空间复杂度都是O(N)的解法
        if (s==null){
            return null;
        }
        //选用 StringBuilder 单线程使用，比较快，选不选都行
        StringBuilder sb = new StringBuilder();
        //使用 sb 逐个复制 s ，碰到空格则替换，否则直接复制
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
