package com.altafjava.bootcamp.day21;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
146. LRU Cache
https://leetcode.com/problems/lru-cache/description/

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
Implement the LRUCache class:

    LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    int get(int key) Return the value of the key if the key exists, otherwise return -1.
    void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to
    the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.

Example 1:
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4

Constraints:
    1 <= capacity <= 3000
    0 <= key <= 104
    0 <= value <= 105
    At most 2 * 105 calls will be made to get and put.
*/
public class LRUCache<K, V> {
	private int capacity;
	private Map<K, V> cache;
	private Deque<K> order;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<>();
		order = new LinkedList<>();
	}

	public V get(K key) {
		if (cache.containsKey(key)) {
			order.remove(key);
			order.addFirst(key);
			return cache.get(key);
		}
		return null;
	}

	public void put(K key, V value) {
		if (cache.size() >= capacity) {
			K leastRecentlyUsed = order.removeLast();
			cache.remove(leastRecentlyUsed);
		}
		cache.put(key, value);
		order.addFirst(key);
	}

	public static void main(String[] args) {
		LRUCache<Integer, String> lruCache = new LRUCache<>(3);
		lruCache.put(1, "One");
		lruCache.put(2, "Two");
		lruCache.put(3, "Three");
		System.out.println("Initial Cache: " + lruCache.order);
		lruCache.get(1); // Accessing key 1, making it the most recently used
		System.out.println("Cache after accessing key 1: " + lruCache.order);
		lruCache.put(4, "Four"); // Adding a new entry, causing eviction of the least recently used entry (key 2)
		System.out.println("Cache after adding key 4: " + lruCache.order);
	}
}
