package findLeavesOfBinaryTree;

import java.util.ArrayList;
import java.util.List;
import utility.TreeNode;

public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(res, root);
        return res;
    }
    private int dfs(List<List<Integer>> res, TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1 + Math.max(dfs(res, root.left), dfs(res, root.right));
        if (res.size() < depth) {
            res.add(new ArrayList<>());
        }
        res.get(depth - 1).add(root.val);

        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        FindLeavesOfBinaryTree obj = new FindLeavesOfBinaryTree();
        List<List<Integer>> res = obj.findLeaves(root);
        res.stream().forEach(System.out::print);
    }

}
