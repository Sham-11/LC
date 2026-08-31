/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] ans = {-1, -1};

        if (head == null || head.next == null || head.next.next == null) {
            return ans;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;

        int position = 2;

        int first = -1;
        int prevCritical = -1;
        int minDist = Integer.MAX_VALUE;
        int maxDist = -1;

        while (next != null) {

            // Check if current node is a critical point
            boolean isCritical =
                    (curr.val > prev.val && curr.val > next.val) ||
                    (curr.val < prev.val && curr.val < next.val);

            if (isCritical) {

                // First critical point
                if (first == -1) {
                    first = position;
                }

                // We already have a previous critical point
                if (prevCritical != -1) {
                    int distance = position - prevCritical;

                    minDist = Math.min(minDist, distance);
                    maxDist = position - first;
                }

                prevCritical = position;
            }

            prev = curr;
            curr = next;
            next = next.next;
            position++;
        }

        if (maxDist == -1) {
            return ans;
        }

        ans[0] = minDist;
        ans[1] = maxDist;

        return ans;
    }
}