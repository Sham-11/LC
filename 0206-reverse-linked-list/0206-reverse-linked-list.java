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
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode prevnode = null;
        ListNode currnode = head;

        while(currnode != null){
            ListNode nextnode = currnode.next;
            currnode.next = prevnode;
            prevnode = currnode;
            currnode = nextnode;
        }

        head = prevnode;
        return head;
    }
}