/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
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
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        // 二分法
        if (start == end) {
            return lists[start];
        }
        if (start > end) {
            return null;
        }
        int mid = (start + end) >> 1;
        return mergeTwoLists(merge(lists, start, mid), merge(lists, mid + 1, end));
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                pre.next = a;
                a = a.next;
            } else {
                pre.next = b;
                b = b.next;
            }
            pre = pre.next;
        }
        pre.next = a == null ? b : a;
        return dummy.next;
    }
}
// @lc code=end

