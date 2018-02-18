package mergeKSortedLists;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        ListNode pre = new ListNode(-1);
        ListNode dummy = pre;

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        while(!pq.isEmpty()) {
            dummy.next = pq.poll();
            dummy = dummy.next;
            if (dummy.next != null) {
                pq.offer(dummy.next);
            }
        }
        return pre.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode node1 = new ListNode(3);
        node1.next = new ListNode(6);
        node1.next.next = new ListNode(8);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(7);

        ListNode[] lists = new ListNode[]{node1, node2};

        ListNode res = mergeKSortedLists.mergeKLists(lists);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
