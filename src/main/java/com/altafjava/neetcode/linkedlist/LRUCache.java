package com.altafjava.neetcode.linkedlist;

import java.util.HashMap;
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
public class LRUCache {
	private int capacity;
	private Node head;
	private Node tail;
	private Map<Integer, Node> map;

	private class Node {
		int key;
		int value;
		Node next;
		Node prev;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("[");
			Node cn = this;
			while (cn!=null && cn != tail) {
				sb.append(cn.value + " ");
				cn = cn.next;
			}
			sb.append("]");
			return sb.toString();
		}
	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>(capacity);
		this.head = new Node(-1, -1);
		this.tail = new Node(-1, -1);
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);
			addFirst(node);
			return node.value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			remove(node);
			addFirst(node);
		} else {
			if (map.size() == capacity) {
				map.remove(tail.prev.key);
				remove(tail.prev);
			}
			Node newNode = new Node(key, value);
			addFirst(newNode);
			map.put(key, newNode);
		}
	}
	
	private void addFirst(Node node) {
		head.next.prev = node;
		node.next = head.next;
		node.prev = head;
		head.next = node;
	}

	private void remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(2);
		System.out.println("Initial Cache: " + lruCache.head.next);
		lruCache.put(1, 1);
		System.out.println("After insert 1: " + lruCache.head.next);
		lruCache.put(2, 2);
		System.out.println("After insert 2: " + lruCache.head.next);
		lruCache.get(1);
		System.out.println("After accessing key 1: " + lruCache.head.next);
		lruCache.put(3, 3);
		System.out.println("After adding key 3: " + lruCache.head.next);
		lruCache.put(4, 4);
		System.out.println("After adding key 4: " + lruCache.head.next);
	}
}
