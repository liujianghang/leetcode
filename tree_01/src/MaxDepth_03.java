public class MaxDepth_03 {
    /**
     * 给定一个 N 叉树，找到其最大深度。
     * <p>
     * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
     * <p>
     * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）
     */
    public int maxDepth(TreeNode root){
        // TODO:二叉树
        //  n叉树思路是一样的 用递归就行
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
