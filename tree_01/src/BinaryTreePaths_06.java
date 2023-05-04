import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_06 {
    /**
     * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径
     * 叶子节点 是指没有子节点的节点。
     * 输入：root = [1,2,3,null,5]
     * 输出：["1->2->5","1->3"]
     */
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>(); // 村最终的结果
        if (root == null) {
            return res;
        }
        ArrayList<Integer> paths = new ArrayList<>(); // 作为结果中的路径 这个路径是一直维护的
        traversal(root, paths, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val); // 前序遍历 中
        // 遇到叶子结点
        if (root.left == null && root.right == null) {
            StringBuffer sb = new StringBuffer(); // StringBuilder用来拼接字符串，速度更快
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1)); // 连接最后一个结点
            res.add(sb.toString()); // 收集一个路径
            return;
        }
        // 递归和回溯同时进行，所以需要放在一个花括号里面
        if (root.left != null) {
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1); // 回溯
        }
        if (root.right != null) {
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1); // 去掉末尾
        }
    }
}
