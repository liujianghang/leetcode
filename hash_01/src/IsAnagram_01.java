public class IsAnagram_01 {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * <p>
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     *
     * @param s
     * @param t
     * @return boolean
     */
    public boolean isAnagram(String s, String t) {
        // TODO 采用一个hashmap来统计各个字母出现的频率
        //  时间复杂度O(m+n) 空间复杂度O(1)
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int count:record){
            if (count!=0){
                return false;
            }
        }
        return true;
    }
}
