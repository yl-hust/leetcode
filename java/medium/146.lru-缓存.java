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
    int cap;
    Deque<Integer> ll = new LinkedList<>();     // save cache key
    Map<Integer, Integer> map = new HashMap<>(); // save cache
    public LRUCache(int capacity) {
        cap = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int value = map.get(key);
        moveToFirst(key);
        return value;
    }
    
    public void put(int key, int value) {        
        if (map.containsKey(key)) {            
            // Update value: 删掉老值
            ll.remove(Integer.valueOf(key)); // remove(Object)而不是remove(index)            
        } else {
            if (map.size() == cap) {
                // 淘汰LRU: 链表尾部
                int lru = ll.removeLast();
                map.remove(lru);
            }
        }
        // 新值插到链表头
        ll.addFirst(key);
        map.put(key, value);
    }
    
    private void moveToFirst(Integer key) {
        ll.remove(key);
        ll.addFirst(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

