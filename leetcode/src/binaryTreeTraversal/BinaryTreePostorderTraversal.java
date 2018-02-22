package binaryTreeTraversal;

import utility.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    // Iterative stack solution
    public List<Integer> PostorderTraversalStack(TreeNode root) {
        List<Integer>  res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while(node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                res.add(0, node.val);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }
        return res;
    }

    // DFS
    public List<Integer> PostorderTraversalDFS(TreeNode root) {
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
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }

    // Divide and conquer
    public List<Integer> PostorderTraversalDivideAndConquer(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<Integer> left = PostorderTraversalDivideAndConquer(root.left);
        List<Integer> right = PostorderTraversalDivideAndConquer(root.right);

        res.addAll(left);
        res.addAll(right);
        res.add(root.val);

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(2);

        BinaryTreePostorderTraversal obj = new BinaryTreePostorderTraversal();

        // Iterative stack solution
        List<Integer> res = obj.PostorderTraversalStack(root);
        System.out.println("Iterative stack solution");
        res.stream().forEach(System.out::println);

        // DFS
        res = obj.PostorderTraversalDFS(root);
        System.out.println("\nDFS solution");
        res.stream().forEach(System.out::println);

        // Divide and conquer
        res = obj.PostorderTraversalDivideAndConquer(root);
        System.out.println("\nDivide and conquer");
        res.stream().forEach(System.out::println);
    }
}

