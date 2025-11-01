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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> st = new HashSet<>();  // arr -> O(1)
        for(int n : nums) {
            st.add(n);
        }

        // skipping nodes which are not in set
        while(head != null && st.contains(head.val)) {
            head = head.next;
        }

        // checking rest
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            if(!st.contains(curr.val)) {
                // moving prev and curr
                prev = curr;
                curr = curr.next;
            } else {
                // skipping curr node
                if(prev != null) {
                    prev.next = curr.next;
                }
                curr = curr.next;
            } 
        }

        return head;
    }
}
/**
TC = O(n)
SC = O(n) */