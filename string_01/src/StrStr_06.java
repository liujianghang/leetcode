public class StrStr_06 {
    /**
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1
     * KMP算法
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = next[j - 1]; // 重新调整j的位置,因为仍然有一部分needle的字符串是匹配上的，那么这部分就不用匹配了
            }
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            if (j == needle.length()) {
                return i - needle.length() + 1; //  返回这个匹配的其实位置
            }
        }
        return -1;
    }

    public void getNext(int[] next, String s) {
        // TODO:获得next数组的方法
        int j = 0;
        next[0] = 0;
        // aabaaf
        // 前缀 包含首字母，不包含尾字母 后缀 包含尾字母，不包含首字母
        // j指向前缀末尾位置，i指向后缀末尾位置 j也表示包括i以及i之前的字串的最长前后缀的长度
        // next[i] 表示 i（包括i）之前最长相等的前后缀长度（其实就是j）,其实也是回退的位置
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {  // while表示的是持续回退 因为一次匹配不成功回退后 第二次也可能不成功
                j = next[j - 1];  // 这里回退是看前一位的回退的位置(找前面这个字串的最长相等前后缀)，然后赋值给next[i],这个跳转只是一个相对于匹配上的一个次优情况，还可能再次前后缀匹配不成功，则要继续回退
            }
            if (s.charAt(j) == s.charAt(i)) {  // 如果匹配成功
                j++;
            }
            next[i] = j;
        }
    }

}
