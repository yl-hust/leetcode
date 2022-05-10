/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
 */

// @lc code=start
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }        
        // 偶节点头
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            // 奇节点指向下一个奇数节点
            odd.next = even.next;
            odd = odd.next;
            // 偶节点指向下一个偶数节点
            even.next = odd.next;
            even = even.next;
        }
        // 最后一个奇数节点 => 第一个偶节点
        odd.next = evenHead;
        return head;
    }
}
// @lc code=end

