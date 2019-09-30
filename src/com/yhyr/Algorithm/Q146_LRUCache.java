package com.yhyr.Algorithm;

import java.util.LinkedHashMap;

/**
 * Subject: LRU缓存
 * @author yhyr
 * @since 2019/09/30 15:10
 */
public class Q146_LRUCache {
    LinkedHashMap<Integer, Integer> linkedHashMap;
    int capacity;

    public Q146_LRUCache(int capacity) {
        linkedHashMap = new LinkedHashMap<>(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (linkedHashMap.keySet().contains(key)) {
            return linkedHashMap.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (linkedHashMap.keySet().contains(key)) {
            linkedHashMap.put(key, value);
            return;
        }
        if (linkedHashMap.size() == this.capacity) {
            int k = linkedHashMap.keySet().iterator().next();
            linkedHashMap.remove(k);
        }
        linkedHashMap.put(key, value);
    }

    public static void main(String[] args) {
        Q146_LRUCache cache = new Q146_LRUCache( 2);

        cache.put(2, 6);
        cache.put(1, 2);
        cache.get(1);
        cache.put(1, 3);
        cache.get(4);

    }
}
