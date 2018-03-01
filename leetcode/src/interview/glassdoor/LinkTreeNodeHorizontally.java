package interview.glassdoor;


/*    Write a function to connect all the adjacent nodes at the same level in a binary tree. Structure of the given Binary Tree node is like following.

        node -> { data, left, right, nextright }

        a

        a -> a

        a ->  a  ->  a


        5

        6  7

        8  9  10*/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Can we implement this without using TreeNode and using Node (the above class) instead ?

// Use recursive
public class LinkTreeNodeHorizontally {
    public Node conectAdjacent1(Node root) {
        if (root == null) {
            return root;
        }
        List<List<Node>> res = helper(root);
        for (int i = 0; i < res.size(); ++i) {
            ListNode pre = null;
            for (int j = 0; j < res.get(i).size(); ++j) {
                pre.node = res.get(i).get(j);
                pre = pre.next;
            }
        }
        return root;
    }

    public List<List<Node>> helper(Node root) {
        List<List<Node>> res = new ArrayList<>();
        helper2(res, root, 0);
        return res;
    }

    public void helper2(List<List<Node>> res, Node root, int depth) {
        if (root == null) {
            return;
        }
        if (depth >= res.size()){
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root);
        helper2(res, root.left, depth + 1);
        helper2(res, root.right, depth + 1);
    }

// Use LinkedList
    public Node conectAdjacent2(Node root) {
        if (root == null) {
            return root;
        } //returns empty when null
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            ListNode pre = null;
            Node currNode = null;
            for (int i = 0; i < size; ++i) {
                if (i == 0) {
                    currNode = queue.poll();
                    pre.node = currNode;
                } else {
                    pre = pre.next;
                    currNode = queue.poll();
                    pre.node = currNode;
                }
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
        }
        return root;
    }

// Using Node
    public Node conectAdjacent3(Node root) {
        if (root == null) {
            return root;
        } //returns empty when null
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; ++i) {
                if (i == 0) {
                    pre = queue.poll();
                } else {
                    pre.nextRight = queue.poll();
                    pre = pre.nextRight;
                }
                if (pre.left != null) {
                    queue.offer(pre.left);
                }
                if (pre.right != null) {
                    queue.offer(pre.right);
                }
            }
        }
        return root;
    }

    class Node {
        public Node right;
        public Node left;
        public Node nextRight;
        public String data;

        //getter setters for each

    }

    class ListNode {
        Node node;
        ListNode next;
        public ListNode(Node node) {
            this.node = node;
        }
    }
}




