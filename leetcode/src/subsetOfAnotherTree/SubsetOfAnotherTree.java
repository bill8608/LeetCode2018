package subsetOfAnotherTree;

import utility.TreeNode;

public class SubsetOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (isSame(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s ==  null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public static void main(String[] args) {
        SubsetOfAnotherTree subsetOfAnotherTree = new SubsetOfAnotherTree();
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(1);
        root1.right.right = new TreeNode(2);

        TreeNode tRoot = new TreeNode(4);
        tRoot.left = new TreeNode(1);
        tRoot.right = new TreeNode(2);

        System.out.println(subsetOfAnotherTree.isSubtree(root1, tRoot) == true);

        root1.right.right.left = new TreeNode(0);
        System.out.println(subsetOfAnotherTree.isSubtree(root1, tRoot) == false);
    }
}
