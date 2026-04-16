package LeetCode.Add_Two_Numbers;

/**
 * LeetCode — Add Two Numbers
 * <p>
 * Problem summary:
 * Two non-empty linked lists represent two non-negative integers where each node contains a single digit.
 * The digits are stored in reverse order (least-significant digit first). Add the two numbers and return
 * the sum as a linked list in the same reverse order. The input lists do not contain leading zeros,
 * except the number 0 itself.
 * <p>
 * Example:
 *   l1 = 2 -> 4 -> 3   (342)
 *   l2 = 5 -> 6 -> 4   (465)
 *   result = 7 -> 0 -> 8 (807)
 * <p>
 * This class includes:
 * - A minimal {@code ListNode} definition for singly-linked lists.
 * - {@link #additionResult(ListNode, ListNode)} implementing the digit-wise addition with carry.
 * - Small helpers to build and print lists for demonstration in {@link #main(String[])}.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = fromArray(new int[]{9, 9});
        ListNode l2 = fromArray(new int[]{1});
        ListNode result = additionResult(l1, l2);
        printList(result);
    }

    /**
     * Singly-linked list node used for representing digits in reverse order.
     */
    public static class ListNode {
        /** digit value for this node (0–9) */
        int val;
        /** reference to the next digit node (more significant digit) */
        ListNode next;

        ListNode(int x) { val = x; }
    }

    /**
     * Adds two numbers represented by linked lists where digits are stored in reverse order.
     * <p>
     * Algorithm:
     * - Traverse both lists simultaneously, summing corresponding digits and an incoming carry.
     * - Create a new node for each resulting digit (sum % 10) and advance pointers.
     * - After the loop, if a carry remains, append a final node.
     * <p>
     * Time complexity: O(max(m, n)) where m and n are the lengths of the two lists.
     * Space complexity: O(1) auxiliary (output list not counted), since we create only the result nodes.
     *
     * @param l1 head of the first number list (least-significant digit first)
     * @param l2 head of the second number list (least-significant digit first)
     * @return head of the resulting sum list (least-significant digit first)
     */
    public static ListNode additionResult(ListNode l1, ListNode l2) {
        // Dummy head simplifies edge cases (e.g., first insertion and final carry).
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0; // carry from the previous digit addition

        // Loop until both lists are fully traversed
        while (l1 != null || l2 != null) {
            // Extract current digit values; if a list is exhausted, use 0
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Sum the two digits plus any carry from the previous step
            int sum = carry + x + y;
            // New carry is the tens place of the sum
            carry = sum / 10;

            // Create a node with the ones place of the sum and advance the tail
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Advance input pointers if possible
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // If a carry remains after processing all digits, append it as a new node
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    /**
     * Builds a linked list from an array of digits in the given order.
     * Example: {@code {2,4,3}} -> {@code 2->4->3}
     *
     * Note: This does not reverse the array; pass digits in the intended storage order.
     *
     * @param digits array of digit values (each 0–9)
     * @return head of the constructed list, or {@code null} if the array is null/empty
     */
    private static ListNode fromArray(int[] digits) {
        if (digits == null || digits.length == 0) return null;
        ListNode head = new ListNode(digits[0]);
        ListNode curr = head;
        for (int i = 1; i < digits.length; i++) {
            curr.next = new ListNode(digits[i]);
            curr = curr.next;
        }
        return head;
    }

    /**
     * Prints the linked list in a compact arrow-separated format, e.g., {@code 0->0->1}.
     * Useful for quick visual verification.
     *
     * @param node head of the list to print
     */
    private static void printList(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            node = node.next;
            if (node != null) sb.append("->");
        }
        System.out.println(sb);
    }
}
