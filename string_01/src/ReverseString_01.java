public class ReverseString_01 {
    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * <p>
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * <p>
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     */
    public void reverseString1(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            s[l] ^= s[r];  //异或运算 构造 a ^ b 的结果，并放在 a 中
            s[r] ^= s[l];  //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
            s[l] ^= s[r];  //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
            l++;
            r--;
        }
    }
    // 第二种方法用temp来交换数值更多人容易理解些

    public void reverseString2(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
