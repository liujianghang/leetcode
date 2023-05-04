import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TraversalLevel {
    /**
     * resList是一层一层的列表
     */
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        //checkFun01(root,0);
        checkFun02(root);
        return resList;
    }

    // DFS--递归方式
    public void checkFun01(TreeNode node, Integer deep) {
        if (node == null) {
            return;
        }
        deep++;
        if (resList.size() < deep) {
            // resList的层数不够用了
            // 当层级增加时，list的Item也在增加， 利用list的索引值进行层级界定
            // 这里相当于增加一层
            ArrayList<Integer> item = new ArrayList<>();
            resList.add(item);
        }
        // deep-1是因为索引
        resList.get(deep - 1).add(node.val);
        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }
    // BFS--迭代方式 借助队列
    public void checkFun02(TreeNode node){
        if (node==null){
            return;
        }
        LinkedList<TreeNode> que = new LinkedList<>();
        que.offer(node);

        while (!que.isEmpty()){
            ArrayList<Integer> itemList = new ArrayList<>();
            int nums = que.size();
            while (nums>0){
                TreeNode tempNode = que.poll();
                itemList.add(tempNode.val);
                if (tempNode.left!=null) que.offer(tempNode.left);
                if (tempNode.right!=null) que.offer(tempNode.right);
                nums--;
            }
            resList.add(itemList);
        }
    }
}
