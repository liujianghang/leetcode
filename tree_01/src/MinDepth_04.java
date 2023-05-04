public class MinDepth_04 {
    /**
     * 给定一个二叉树，找出其最小深度。
     * <p>
     * 最小深度是从根节点到最近 叶子节点 的最短路径上的节点数量。
     * <p>
     * 说明：叶子节点是指没有子节点的节点
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }
        // 左右都不为null
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
