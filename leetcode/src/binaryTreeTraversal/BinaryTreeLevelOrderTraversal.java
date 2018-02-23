package binaryTreeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utility.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    // BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer>  list = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode currNode = queue.poll();


                list.add(currNode.val);
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }


                // OR another way BUT DO NOT FORGET CHECK list.size() != 0 OTHERWISE THERE WILL BE AN EMPTY [] in res.
/*                if (currNode != null) {
                    list.add(currNode.val);
                    queue.offer(currNode.left);
                    queue.offer(currNode.right);
                }
            }
            if (list.size() != 0) {
                res.add(list);
            }*/
            }
            res.add(list);
        }
        return res;
    }

    // DFS
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, TreeNode root, int numOfLevel) {
        if (root == null) {
            return;
        }
        if (numOfLevel >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(numOfLevel).add(root.val);
        helper(res, root.left, numOfLevel + 1);
        helper(res, root.right, numOfLevel + 1);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(2);

        BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> res = obj.levelOrder(root);
        System.out.println("\nBFS Solution:");
        res.forEach(System.out::println);

        res = obj.levelOrderDFS(root);
        System.out.println("\nDFS Solution:");
        res.forEach(System.out::println);
/*        for (List<Integer> list : res) {
            System.out.print("[");
            for (int i = 0; i < list.size(); ++i) {
                System.out.print(list.get(i));
                if (i != list.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]\n");
        }*/
    }
}
