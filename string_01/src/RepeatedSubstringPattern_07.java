public class RepeatedSubstringPattern_07 {
    /**
     * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        // TODO：使用KMP方法解这道题
        //  数组长度减去最长相同前后缀的长度相当于是第一个周期的长度，也就是一个周期的长度，如果这个周期可以被整除，就说明整个数组就是这个周期的循环
        if (s.equals("") || s == null) return false;
        int len = s.length();
        int[] next = new int[len];
        // 求next数组
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        // 最后判断是否是重复的子字符串，这里 next[len] 即代表next数组末尾的值
        if (next[len - 1] > 0 && len % (len - next[len - 1]) == 0) {
            return true;
        }
        return false;
    }
}
