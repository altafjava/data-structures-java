package com.altafjava.bootcamp.day11;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		System.out.println(linkedList);
		linkedList.addFirst(10);
		System.out.println(linkedList);
		linkedList.addFirst(20);
		System.out.println(linkedList);
		linkedList.addFirst(30);
		linkedList.addFirst(40);
		System.out.println(linkedList);
		linkedList.addLast(50);
		System.out.println(linkedList);
		linkedList.addLast(60);
		linkedList.addLast(70);
		System.out.println(linkedList);
		linkedList.addMiddle(80, 4);
		System.out.println(linkedList);
		linkedList.addMiddle(90, 9);
		System.out.println(linkedList);
	}
}
