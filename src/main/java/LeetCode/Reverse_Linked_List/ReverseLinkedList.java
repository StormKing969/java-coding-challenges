package LeetCode.Reverse_Linked_List;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = buildList(new int[]{1, 2, 3, 4, 5});
        System.out.println(reverseList(head));
    }

    public static ListNode buildList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return curr;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode curr = this;

            while (curr != null) {
                sb.append(curr.val);
                if (curr.next != null) sb.append(" -> ");
                curr = curr.next;
            }

            return sb.toString();
        }
    }
}
