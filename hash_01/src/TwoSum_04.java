import java.util.HashMap;

public class TwoSum_04 {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 你可以按任意顺序返回答案。
     */
    public int[] twoSum(int[] nums, int target) {
        // TODO：本题需要用到hashmap key是遍历过的数，value是其下标
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];// 遍历当前元素，在map中寻找是否有匹配的key
            if (map.containsKey(temp)) {
                res[1] = i;
                res[0] = map.get(temp);
                break;
            }
            // 否则就加入这个便利的数
            map.put(nums[i], i);
        }
        return res;
    }
}
