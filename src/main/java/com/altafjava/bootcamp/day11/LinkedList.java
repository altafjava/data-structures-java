package com.altafjava.bootcamp.day11;

public class LinkedList {

	private Node head;

	private class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public void addFirst(int number) {
		if (head == null) {
			head = new Node(number);
		} else {
			Node node = new Node(number);
			node.next = head;
			head = node;
		}
	}

	public void addLast(int number) {
		if (head == null) {
			head = new Node(number);
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			Node node = new Node(number);
			temp.next = node;
		}
	}

	public void addMiddle(int number, int offset) {
		if (offset < 1) {
			System.err.println("Offset should start from 1");
		} else if (offset == 1) {
			addFirst(number);
		} else {
			int count = 2;
			Node temp = head;
			while (temp != null && count < offset) {
				temp = temp.next;
				count++;
			}
			if (temp == null) {
				System.err.println("Current LinkedList size is: " + (count - 2) + " You can't add at: " + offset);
			} else {
				Node node = new Node(number);
				node.next = temp.next;
				temp.next = node;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node temp = head;
		while (temp != null) {
			sb.append(temp.data).append("->");
			temp = temp.next;
		}
		sb.append("]");
		return sb.toString();
	}

}
