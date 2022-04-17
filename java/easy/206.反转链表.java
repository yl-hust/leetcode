/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    //迭代法,最优解 O(n)O(1)
    public ListNode reverseList(ListNode head) {
        ListNode pre = null; //缓存前一个结点
        ListNode cur = head; //当前节点
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre; //当前节点指向前节点（反转）
            pre = cur; //当前节点赋值给前一个节点
            cur = temp; //当前节点迭代
        }      
        return pre;
    }

    // //递归法，不好理解，O(n)+O(n)
    // public ListNode reverseList(ListNode head) {  
    //     if(head == null || head.next == null){
    //         return head;
    //     }        
    //     ListNode newHead = reverseList(head.next);

    //     head.next.next = head;
    //     head.next = null;
    //     return newHead;
    // }

}
// @lc code=end

