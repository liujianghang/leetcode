public class CanConstruct_06 {
    /**
     * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
     *
     * 如果可以，返回 true ；否则返回 false 。
     *
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     * @param ransomNode
     * @param magazine
     * @return
     */
    public boolean conConstruct(String ransomNode, String magazine) {
        // 定义一个哈希映射数组
        int[] record = new int[26];

        // 先遍历magazine
        for (char c : magazine.toCharArray()) {
            record[c - 'a'] += 1;
        }
        // 后遍历ransomNode
        for (char c : ransomNode.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        // 如果数组中存在负数，说明ransomNode字符串中总存在magazine中没有的字符
        for (int i : record) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "eqweqwr";
        String b = "eqweq";
        CanConstruct_06 canConstruct06 = new CanConstruct_06();
        boolean res = canConstruct06.conConstruct(a, b);
        System.out.println(res);
    }
}
