/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
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
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     // 遍历链表，得到size
    //     int size = 0;
    //     ListNode node = head;
    //     while(node != null) {
    //         size++;
    //         node = node.next;            
    //     }
    //     // 处理删除头节点        
    //     if (size - n == 0) {
    //         node = head.next;
    //         head.next = null;
    //         return node;
    //     }
    //     // 找到size-n-1的节点node
    //     node = head;
    //     for(int i = 0; i < size-n-1; i++) {
    //         node = node.next;
    //     }
    //     node.next = node.next.next;
    //     return head;
    // }

    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     ListNode dummy = new ListNode(0);
    //     dummy.next = head;
    //     int size = 0;
    //     ListNode node = head;
    //     while (node != null) {
    //         size++;
    //         node = node.next;
    //     }
    //     node = dummy;
    //     while (size - n > 0) {
    //         size--;
    //         node = node.next;
    //     }
    //     node.next = node.next.next;
    //     return dummy.next;
    // }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head); // dummy node point to head
        ListNode fast = head;
        ListNode slow = dummy;
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
// @lc code=end

