public class ReverseLeftWords_05 {
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        reverse(chars, chars.length - n, chars.length - 1);
        reverse(chars, 0, chars.length - 1-n);
        return new String(chars);
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            chars[left] ^= chars[right];
            chars[right] ^= chars[left];
            chars[left] ^= chars[right];
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseLeftWords_05 reverseLeftWords05 = new ReverseLeftWords_05();
        System.out.println(reverseLeftWords05.reverseLeftWords("abcdefg", 2));
    }
}
