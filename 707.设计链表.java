/*
 * @lc app=leetcode.cn id=707 lang=java
 *
 * [707] 设计链表
 */

// @lc code=start
public class ListNode {
    int val;
    ListNode next;
    ListNode (int x) {
        val = x;
    }
}

class MyLinkedList {
    private ListNode head;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new ListNode(0);
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        ListNode cur = this.head;
        while (index != 0) {
            cur = cur.next;
            index--;            
        }
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (size == 0) {
            head.val = val;
        } else {
            ListNode toAdd = new ListNode(val);
            toAdd.next = this.head;
            this.head = toAdd;
        }
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (size == 0) {
            head.val = val;
        } else {
            ListNode toAdd = new ListNode(val);            
            ListNode cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = toAdd;
        }
        size++;
    }
    
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            addAtHead(val);
        } else if (index == this.size) {
            addAtTail(val);
        } else {
            ListNode toAdd = new ListNode(val);
            ListNode cur = head;
            while (index > 1) {
                cur = cur.next;
                index--;
            }
            toAdd.next = cur.next;
            cur.next = toAdd;            
            size++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >=0 && index < size) {
            if (index == 0) {
                head = head.next;
            } else {
                ListNode toDelete = head;
                while (index > 1) {
                    toDelete = toDelete.next;
                    index--;
                }
                toDelete.next = toDelete.next.next;
            }
            size--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end

