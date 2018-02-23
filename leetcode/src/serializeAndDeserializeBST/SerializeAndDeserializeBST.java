package serializeAndDeserializeBST;

import utility.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// The difference from #297 serialize and deserialize binary tree is BST can be more compact without using "#" which is
// required in the question as well. So wel can use the characters of BST and save into string as pre-order
// {root.val, left1.val, left2.val, ..., leftX.val, right1.val, right2.val, ..., rightX.val}
// in the deserialize we can use queue to recursively get root node, left subtree and right subtree
// time complexity is O(nlogn) and the worst case is O(n^2) when the tree is completely unbalanced
public class SerializeAndDeserializeBST {
    private static final String SEP = ",";
    private static final String NULL = "null";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return NULL;
        }
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            sb.append(root.val).append(SEP);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(NULL)) {
            return null;
        }
        String[] strs = data.split(SEP);
        Queue<Integer> queue = new LinkedList<>();
        for (String str : strs) {
            queue.offer(Integer.parseInt(str));
        }
        return getNode(queue);
    }

    // data
    //     5
    //   3   6
    // 2       7
    public TreeNode getNode(Queue<Integer> queue) { // queue: 5, 3, 2, 6, 7
        if (queue.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(queue.poll()); // root: 5
        Queue<Integer> smallerQueue = new LinkedList<>();
        while (!queue.isEmpty() && queue.peek() < root.val) {
            smallerQueue.offer(queue.poll());
        }
        //smallerQueue: 3, 2 store elements smaller than 5 (root)
        root.left = getNode(smallerQueue);

        //queue: 6, 7 store elements bigger than 5 (root)
        root.right = getNode(queue);
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
