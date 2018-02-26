package binaryTreeUpsideDown;

import utility.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTreeUpsideDown {
    //tack Solution
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        TreeNode newRoot = root;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            root.left = curr.right;
            curr.left = null;
            curr.right = null;
            root.right = curr;
            root = root.right;
        }
        return newRoot;
    }

    // DFS Solution
    public TreeNode upsideDownBinaryTreeDFS(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTreeDFS(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        BinaryTreeUpsideDown obj = new BinaryTreeUpsideDown();

        System.out.println("Stack Solution");
        TreeNode newRoot = obj.upsideDownBinaryTree(root);
        System.out.println();
        System.out.println(newRoot.val);
        System.out.println(newRoot.left.val + "    " + newRoot.right.val);
        System.out.println("    " + newRoot.right.left.val + "   " + newRoot.right.right.val);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        System.out.println();
        System.out.println("DFS Solution");
        TreeNode newRootDFS = obj.upsideDownBinaryTreeDFS(root2);
        System.out.println(newRootDFS.val);
        System.out.println(newRootDFS.left.val + "    " + newRootDFS.right.val);
        System.out.println("    " + newRootDFS.right.left.val + "   " + newRootDFS.right.right.val);
    }
}
