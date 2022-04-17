/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/* *
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            node.next = new ListNode(sum % 10);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            node = node.next;
        }
        if (carry == 1){
            node.next = new ListNode(1);
        }

        return dummy.next;
    }
}
// @lc code=end

