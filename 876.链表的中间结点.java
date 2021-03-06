/*
 * @lc app=leetcode.cn id=876 lang=java
 *
 * [876] 链表的中间结点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // public ListNode middleNode(ListNode head) {
    //     int length = 0;
    //     ListNode node = head;
    //     while (node != null) {
    //         length++;            
    //         node = node.next;
    //     }
    //     node = head;
    //     length = length / 2;
    //     while (length > 0) {
    //         length--;
    //         node = node.next;
    //     }
    //     return node;
    // }

    // 快慢指针法
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }        
        return slow;
    }        
}
// @lc code=end

