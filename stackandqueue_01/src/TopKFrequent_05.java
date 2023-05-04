import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent_05 {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     * <p>
     * 基于堆实现，时间复杂度nlog(k)
     */
    public int[] topKFrequent(int[] nums, int k) {
        // TODO:基于大顶堆实现nlog(k)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 在优先级队列中存储二元组(num,cnt),cnt表示元素num在数组中出现的次数
        // 出现次数按照从队头到队尾的顺序是从大到小排，出现次数最多的在队头
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[] {entry.getKey(),entry.getValue()});
        }
        int []ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}
