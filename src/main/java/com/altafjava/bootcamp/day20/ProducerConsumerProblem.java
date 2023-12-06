package com.altafjava.bootcamp.day20;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerProblem {

	public static void main(String[] args) {
		SharedBuffer sharedBuffer = new SharedBuffer(5);
		Producer producer = new Producer(sharedBuffer);
		Consumer consumer = new Consumer(sharedBuffer);
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		producerThread.start();
		consumerThread.start();
	}
}

class SharedBuffer {
	private Queue<Integer> sharedQueue = new LinkedList<>();
	private int capacity;

	public SharedBuffer(int capacity) {
		this.capacity = capacity;
	}

	public void produce(int item) throws InterruptedException {
		synchronized (this) {
			while (sharedQueue.size() == capacity) {
				wait();
			}
			sharedQueue.add(item);
			System.out.println("Producing.. " + item);
			notify();
		}
	}

	public int consume() throws InterruptedException {
		synchronized (this) {
			while (sharedQueue.isEmpty()) {
				wait();
			}
			int item = sharedQueue.poll();
			System.out.println("Consuming.. " + item);
			notify();
			return item;
		}
	}
}

class Producer implements Runnable {
	private SharedBuffer sharedBuffer;

	public Producer(SharedBuffer sharedBuffer) {
		this.sharedBuffer = sharedBuffer;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				sharedBuffer.produce(i);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	private SharedBuffer sharedBuffer;

	public Consumer(SharedBuffer sharedBuffer) {
		this.sharedBuffer = sharedBuffer;
	}

	@Override
	public void run() {
		while (true) {
			try {
				sharedBuffer.consume();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
