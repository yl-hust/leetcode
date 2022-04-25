import java.util.HashMap;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
class LRUCache {
    /**
     * 由于LinkedList的remove(Object)或remove(index)方法是O(n)，所以AC不过
     */      
    int cap;
    LinkedList<Integer> ll = new LinkedList<>();     // save cache key
    HashMap<Integer, Integer> map = new HashMap<>(); // save cache
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

