package serializeAndDeserializeBinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeAndDeserializeBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    sb.append("#");
                }
                sb.append(",");
            }
        }
        return sb.substring(0, sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < strs.length; i += 2) {
            TreeNode node = queue.poll();
            if (!strs[i].equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.valueOf(strs[i]));
                node.left = leftNode;
                queue.offer(leftNode);
            }
            if (i + 1 < strs.length && !strs[i + 1].equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.valueOf(strs[i + 1]));
                node.right = rightNode;
                queue.offer(rightNode);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree obj = new SerializeAndDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serialStr = obj.serialize(root);
        System.out.println(serialStr);

        System.out.println("\ndeserialize");
        TreeNode newRoot = obj.deserialize(serialStr);
        String serialStr2 = obj.serialize(root);
        System.out.println(serialStr2);
    }
}
