package binaryTreePreorderTraversal;

import utility.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    // Iterative stack solution
    public List<Integer> PreorderTraversalStack(TreeNode root) {
        List<Integer>  res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while(node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                res.add(node.val);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
        return res;
    }

    // DFS
    public List<Integer> PreorderTraversalDFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }

    // Divide and conquer
    public List<Integer> PreorderTraversalDivideAndConquer(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<Integer> left = PreorderTraversalDivideAndConquer(root.left);
        List<Integer> right = PreorderTraversalDivideAndConquer(root.right);

        res.add(root.val);
        res.addAll(left);
        res.addAll(right);

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(2);

        binaryTreePreorderTraversal.BinaryTreePreorderTraversal obj = new binaryTreePreorderTraversal.BinaryTreePreorderTraversal();

        // Iterative stack solution
        List<Integer> res = obj.PreorderTraversalStack(root);
        System.out.println("Iterative stack solution");
        res.stream().forEach(System.out::println);

        // DFS
        res = obj.PreorderTraversalDFS(root);
        System.out.println("\nDFS solution");
        res.stream().forEach(System.out::println);

        // Divide and conquer
        res = obj.PreorderTraversalDivideAndConquer(root);
        System.out.println("\nDivide and conquer");
        res.stream().forEach(System.out::println);
    }
}

