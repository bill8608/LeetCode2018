package binaryTreeInorderTraversal;

import utility.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    // Iterative stack solution
    public List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer>  res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        
        while(node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }

    // DFS
    public List<Integer> inorderTraversalDFS(TreeNode root) {
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
        res.add(root.val);
        helper(root.right, res);
    }

    // Divide and conquer
    public List<Integer> inorderTraversalDivideAndConquer(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<Integer> left = inorderTraversalDivideAndConquer(root.left);
        List<Integer> right = inorderTraversalDivideAndConquer(root.right);

        res.addAll(left);
        res.add(root.val);
        res.addAll(right);

        return res;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(2);

        BinaryTreeInorderTraversal obj = new BinaryTreeInorderTraversal();

        // Iterative stack solution
        List<Integer> res = obj.inorderTraversalStack(root);
        System.out.println("Iterative stack solution");
        res.stream().forEach(System.out::println);

        // DFS
        res = obj.inorderTraversalDFS(root);
        System.out.println("\nDFS solution");
        res.stream().forEach(System.out::println);

        // Divide and conquer
        res = obj.inorderTraversalDivideAndConquer(root);
        System.out.println("\nDivide and conquer");
        res.stream().forEach(System.out::println);
    }
}
