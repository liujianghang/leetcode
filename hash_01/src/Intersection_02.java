import java.util.HashSet;

public class Intersection_02 {
    /**
     * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();
        // 便利数组1
        for (int i : nums1) {
            set1.add(i);
        }
        // 遍历数组2的过程中判断哈希表中是否有该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
        // 方法1:将结果集合转为数组
//        return resSet.stream().mapToInt(x -> x).toArray();
        // 方法2:另外申请一个数组存放resSet
        int[] arr = new int[resSet.size()];
        int j = 0;
        for (int i : resSet) {
            arr[j++] = i;
        }
        return arr;
    }
}
