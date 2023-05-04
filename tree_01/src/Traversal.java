import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Traversal {
    // TODO:递归实现三种遍历
//  列表存储树
    class TraversalRecursion {
        // 前序遍历
        public List<Integer> preorderTraversal(TreeNode root) {
            // 可以增加的数组
            ArrayList<Integer> result = new ArrayList<>();
            preorder(root, result);
            return result;
        }

        public void preorder(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            result.add(root.val);
            preorder(root.left, result);
            preorder(root.right, result);
        }

        // 中序遍历
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorder(root, res);
            return res;
        }

        void inorder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            inorder(root.left, list);
            list.add(root.val);             // 注意这一句
            inorder(root.right, list);
        }

        // 后序遍历
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            postorder(root, res);
            return res;
        }

        void postorder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            postorder(root.left, list);
            postorder(root.right, list);
            list.add(root.val);             // 注意这一句
        }
    }

    // TODO:对树进行迭代遍历 需要利用到栈
    class TraversalIteration {
        public List<Integer> preorderTraversal(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.right!=null){
                    stack.push(node.right);
                }
                if (node.left!=null){
                    stack.push(node.left);
                }
            }
            return result;
        }
        // 中序遍历顺序: 左-中-右 入栈顺序： 左-右
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()){
                if (cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }else{
                    cur = stack.pop();
                    result.add(cur.val);
                    cur = cur.right;
                }
            }
            return result;
        }
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                // 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.left != null){
                    stack.push(node.left);
                }
                if (node.right != null){
                    stack.push(node.right);
                }
            }
            Collections.reverse(result);
            return result;
        }
    }
}
