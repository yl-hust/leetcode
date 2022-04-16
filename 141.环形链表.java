import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {    
    // public boolean hasCycle(ListNode head) {
    //     HashSet<ListNode> hs = new HashSet<>();
    //     while(head != null){
    //         if(hs.contains(head)){
    //             return true;
    //         } else {
    //             hs.add(head);
    //         }        
    //         head = head.next;
    //     }
    //     return false;        
    // }

    // 快慢指针法
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
// @lc code=end

