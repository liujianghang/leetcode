public class HasPathSum_09 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        /**
         给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点的路径，
         这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false
         */
        if (root == null) { // 判断根节点
            return false;
        }
        // 若存在这个结点
        targetSum -= root.val;
        // 叶子节点
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        if (root.left != null) {
            boolean left = hasPathSum(root.left, targetSum);
            if (left) {
                return true;
            }
        }
        if (root.right != null) {
            boolean right = hasPathSum(root.right, targetSum);
            if (right) {
                return true;
            }
        }
        return false; // 值不匹配的情况
    }
}
