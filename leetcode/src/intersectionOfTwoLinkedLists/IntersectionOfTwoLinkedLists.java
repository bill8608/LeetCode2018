package intersectionOfTwoLinkedLists;

import utility.ListNode;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int headALen = getLinkedListLength(headA);
        int headBLen = getLinkedListLength(headB);

        int diff = headALen - headBLen;

        if (diff < 0) {
            diff = - diff;
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
        }

        while (diff > 0) {
            headA = headA.next;
            diff--;
        }

        while (headA != null && headB != null) {
            if (headA.val == headB.val) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    private int getLinkedListLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(3);
        headA.next.next = new ListNode(4);
        headA.next.next.next = new ListNode(6);

        ListNode headB = new ListNode(2);
        headB.next = new ListNode(4);
        headB.next.next = new ListNode(6);

        IntersectionOfTwoLinkedLists intersectionObj = new IntersectionOfTwoLinkedLists();
        ListNode intersection = intersectionObj.getIntersectionNode(headA, headB);

        while(intersection != null) {
            System.out.print(intersection.val);
            System.out.print(" -> ");
            intersection = intersection.next;
        }
        System.out.print("null");
    }
}
