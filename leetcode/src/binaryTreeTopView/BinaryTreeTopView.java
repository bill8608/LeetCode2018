package binaryTreeTopView;

import utility.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;

public class BinaryTreeTopView {
    public class QItem {
        int hd;
        TreeNode node;
        public QItem(int hd, TreeNode node) {
            this.hd = hd;
            this.node = node;
        }
    }
    public List<Integer> topView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, Integer>  map = new HashMap<>();
        Queue<QItem> queue = new LinkedList<>();
        queue.offer(new QItem(0, root));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                QItem qItem = queue.poll();
                TreeNode node = qItem.node;
                int hd = qItem.hd;
                if (!map.containsKey(hd)) {
                    map.put(hd, node.val);
                }
                if (node.left != null) {
                    queue.offer(new QItem(hd - 1, node.left));
                }
                if (node.right != null) {
                    queue.offer(new QItem(hd + 1, node.right));
                }
            }
        }
        return map.entrySet().stream()
                .sorted((a, b) -> (a.getKey() - b.getKey()))
                .map(x -> x.getValue())
                .collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(2);

        BinaryTreeTopView obj = new BinaryTreeTopView();
        List<Integer> res = obj.topView(root);
        res.stream().forEach(System.out::println);
    }
}
