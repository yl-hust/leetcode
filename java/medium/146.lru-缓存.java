import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
class LRUCache {
    private class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }
    /**
     * 由于LinkedList的remove(Object)或remove(index)方法是O(n)，所以AC不过 
     * 
     * 理论上说，双向链表的删除的时间复杂度是O(1)，你只需要将要删除的节点的前节
     * 点和后节点相连，然后将要删除的节点的前节点和后节点置为null即可，
     * node.pre.next = node.next;
     * node.next.pre = node.pre;
     * node.pre = null;
     * node.next = null;
     * 但是LinkedList的实现是一个通用的数据结构，因此没有暴露内部的节点Entry对象，
     * remove(Object)传入的Object其实是节点存储的value，这里还需要一个查找过程
     * 
     * 若要实现O(1)，需要自己实现双向链表，remove传入链表节点remove(Node)
     */      
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node dummyHead, dummyTail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        dummyHead = new Node(-1, -1);
        dummyTail = new Node(-1, -1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {        
        if (map.containsKey(key)) {            
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);           
        } else {
            if (map.size() == capacity) {
                // 淘汰LRU: 链表尾部
                Node toRemove = dummyTail.prev;
                removeNode(toRemove);
                map.remove(toRemove.key);
            }
        }
        // 新值插到链表头
        Node newNode = new Node(key, value);
        addToHead(newNode);
        map.put(key, newNode);
    }
    
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.prev = dummyHead;
        node.next = dummyHead.next;

        dummyHead.next.prev = node;
        dummyHead.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

