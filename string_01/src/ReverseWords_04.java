public class ReverseWords_04 {
    /*给你一个字符串 s ，请你反转字符串中 单词 的顺序。
        单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
        返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
        注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     */
    public String reverseWords1(String s) {
        // TODO: 创建新字符数组填充。时间复杂度O(n)
        char[] initialArr = s.toCharArray();
        // 新字符数组 ,下面循环添加"单词 "，最终末尾的空格不会返回
        char[] newArr = new char[initialArr.length + 1];
        int newArrPos = 0;
        // 用i来进行整体对源字符数组从后往前遍历
        int i = initialArr.length - 1;
        while (i >= 0) {
            //跳过空格
            //此时i位置是边界或!=空格，先记录当前索引，之后的while用来确定单词的首字母的位置
            while (i >= 0 && initialArr[i] == ' ') {
                i--;
            }
            int right = i;
            //指定区间单词取出(由于i为首字母的前一位，所以这里+1,)，取出的每组末尾都带有一个空格
            while (i >= 0 && initialArr[i] != ' ') {
                i--;
            }
            for (int j = i + 1; j <= right; j++) {
                newArr[newArrPos++] = initialArr[j];
                if (j == right) {
                    newArr[newArrPos++] = ' ';
                }
            }
        }
        //若是原始字符串没有单词，直接返回空字符串；若是有单词，返回0-末尾空格索引前范围的字符数组(转成String返回)
        if (newArrPos == 0) {
            return "";
        } else {
            return new String(newArr, 0, newArrPos - 1);
        }
    }


    public void reverse(char[] chars, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
            chars[i] ^= chars[j];
            chars[j] ^= chars[i];
            chars[i] ^= chars[j];
        }
    }
}
