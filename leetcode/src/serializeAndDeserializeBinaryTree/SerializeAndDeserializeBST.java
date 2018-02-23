package serializeAndDeserializeBinaryTree;

import utility.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {
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
                node.left = new TreeNode(Integer.valueOf(strs[i]));
                queue.offer(node.left);
            }
            if (i + 1 < strs.length && !strs[i + 1].equals("#")) {
                node.right = new TreeNode(Integer.valueOf(strs[i + 1]));
                queue.offer(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBST obj = new SerializeAndDeserializeBST();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        String serialStr = obj.serialize(root);
        System.out.println(serialStr);

        System.out.println("\ndeserialize");
        TreeNode newRoot = obj.deserialize(serialStr);
        String serialStr2 = obj.serialize(root);
        System.out.println(serialStr2);
    }
}
