package LeetCode.Merge_Two_Sorted_Lists;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = build(1, 2, 4);
        ListNode list2 = build(1, 3, 4);
        System.out.println("[1,1,2,3,4,4] => " + toString(mergeTwoLists(list1, list2)));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else  {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        current.next = list1 == null ? list2 : list1;

        return dummyHead.next;
    }

    // Helper: build a linked list from ints
    public static ListNode build(int... values) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        for (int v : values) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper: convert list to string
    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            head = head.next;
            if (head != null) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
