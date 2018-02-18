package LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, DoubleLinkedList> map = new HashMap<>();
    private int count;
    private int capacity;
    private DoubleLinkedList head;
    private DoubleLinkedList tail;

    public class DoubleLinkedList {
        int key;
        int value;
        DoubleLinkedList pre;
        DoubleLinkedList post;
    }

    public void addNode(DoubleLinkedList node) {
        node.pre = head;
        node.post = head.post;
        head.post.pre = head;
        head.post = node;
    }

    public void removeNode(DoubleLinkedList node) {
        DoubleLinkedList pre = node.pre;
        DoubleLinkedList post = node.post;
        pre.post = post;
        post.pre = pre;
    }

    public void moveToHead(DoubleLinkedList node) {
        this.removeNode(node);
        this.addNode(node);
    }

    public DoubleLinkedList popTail() {
        DoubleLinkedList res = tail.pre;
        this.removeNode(res);
        return res;
    }

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        head = new DoubleLinkedList();
        head.pre = null;

        tail = new DoubleLinkedList();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleLinkedList node = map.get(key);
            this.moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            this.moveToHead(map.get(key));
        } else {
            DoubleLinkedList newNode = new DoubleLinkedList();
            newNode.key = key;
            newNode.value = value;
            this.map.put(key, newNode);
            count++;
            if (count > capacity) {
                DoubleLinkedList tail = this.popTail();
                this.map.remove(tail.key);
            }
        }

    }

    public static void main(String[] args) {
/*        LRUCache lruCache = new LRUCache(5);
        System.out.println(lruCache.get(5));
        lruCache.put(5, 25);
        System.out.println(lruCache.get(5));*/

        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
