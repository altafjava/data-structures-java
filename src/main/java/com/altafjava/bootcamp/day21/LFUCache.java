package com.altafjava.bootcamp.day21;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/*
460. LFU Cache
https://leetcode.com/problems/lfu-cache/description/

Design and implement a data structure for a Least Frequently Used (LFU) cache.
Implement the LFUCache class:
    LFUCache(int capacity) Initializes the object with the capacity of the data structure.
    int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
    void put(int key, int value) Update the value of the key if present, or inserts the key if not already present.
    When the cache reaches its capacity, it should invalidate and remove the least frequently used key before
    inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency),
    the least recently used key would be invalidated.

To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the
smallest use counter is the least frequently used key. When a key is first inserted into the cache, its use counter
is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put
operation is called on it. The functions get and put must each run in O(1) average time complexity.

Example 1:
Input
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]

Explanation
// cnt(x) = the use counter for key x
// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
LFUCache lfu = new LFUCache(2);
lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
lfu.get(1);      // return 1
                 // cache=[1,2], cnt(2)=1, cnt(1)=2
lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                 // cache=[3,1], cnt(3)=1, cnt(1)=2
lfu.get(2);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,1], cnt(3)=2, cnt(1)=2
lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                 // cache=[4,3], cnt(4)=1, cnt(3)=2
lfu.get(1);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,4], cnt(4)=1, cnt(3)=3
lfu.get(4);      // return 4
                 // cache=[4,3], cnt(4)=2, cnt(3)=3

Constraints:
    1 <= capacity <= 104
    0 <= key <= 105
    0 <= value <= 109
    At most 2 * 105 calls will be made to get and put.
*/
public class LFUCache {

	public static void main(String[] args) {
		LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1); // cache=[1,_], cnt(1)=1
        lfu.put(2, 2); // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lfu.get(1)); // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3); // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        System.out.println(lfu.get(2)); // return -1 (not found)
        System.out.println(lfu.get(3)); // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4); // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        System.out.println(lfu.get(1)); // return -1 (not found)
        System.out.println(lfu.get(3)); // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lfu.get(4)); // return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3
	}

	private Map<Integer, Integer> keyToValue;
	private Map<Integer, Integer> keyToCount;
	private Map<Integer, LinkedHashSet<Integer>> countToKeys;
	private int capacity;
	private int minFrequency;

	public LFUCache(int capacity) {
		keyToValue = new HashMap<>();
		keyToCount = new HashMap<>();
		countToKeys = new HashMap<>();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (keyToValue.containsKey(key)) {
			int count = keyToCount.get(key);
			keyToCount.put(key, count + 1);
			countToKeys.get(count).remove(key);
			if (count == minFrequency && countToKeys.get(count).isEmpty()) {
				minFrequency++;
			}
//			countToKey.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
			LinkedHashSet<Integer> set = countToKeys.get(count + 1);
			if (set == null) {
				set = new LinkedHashSet<>();
				countToKeys.put(count + 1, set);
			}
			set.add(key);
			return keyToValue.get(key);
		}
		return -1;
	}

	public void put(int key, int value) {
		if (keyToValue.containsKey(key)) {
			keyToValue.put(key, value);
			get(key);
		} else {
			if (keyToValue.size() >= capacity) {
				int evictedKey = countToKeys.get(minFrequency).iterator().next();
				countToKeys.get(minFrequency).remove(evictedKey);
				keyToValue.remove(evictedKey);
				keyToCount.remove(evictedKey);
			}
			keyToValue.put(key, value);
			keyToCount.put(key, 1);
//			countToKey.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
			LinkedHashSet<Integer> set = countToKeys.get(1);
			if (set == null) {
				set = new LinkedHashSet<>();
				countToKeys.put(1, set);
			}
			set.add(key);
			minFrequency = 1;
		}
	}
}
