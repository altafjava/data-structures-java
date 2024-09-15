package com.altafjava.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleUndirectedGraphBFS {

	public static void main(String[] args) {
		int graph[][] = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 } }, vertices = 5;	// Cycle graph 
//		int graph[][] = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } }, vertices = 5; // Non cycle graph
//		int graph[][] = { { 0, 1 }, { 1, 2 }, { 3, 4 }, { 5, 6 } }, vertices = 7; // Undirected graph with multiple components
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < vertices; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < graph.length; i++) {
			addEdge(adjList, graph[i]);
		}
		boolean hasCycle = detectCycleBFS(vertices, adjList);
		System.out.println(hasCycle);
	}

	private static boolean detectCycleBFS(int vertices, List<List<Integer>> adjList) {
		boolean[] visited = new boolean[vertices];
		for (int i = 0; i < vertices; i++) {
			if (!visited[i]) {
				if (bfs(i, vertices, adjList, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean bfs(int startNode, int vertices, List<List<Integer>> adjList, boolean[] visited) {
		Queue<Pair> q = new LinkedList<>();
		Pair pair = new Pair(startNode, -1);
		q.add(pair);
		visited[startNode] = true;
		while (!q.isEmpty()) {
			Pair pollPair = q.poll();
			int node = pollPair.node;
			int parent = pollPair.parent;
			for (Integer neigbour : adjList.get(node)) {
				if (!visited[neigbour]) {
					q.add(new Pair(neigbour, node));
					visited[neigbour] = true;
				} else if (neigbour != parent) {
					return true;
				}
			}
		}
		return false;
	}

	private static void addEdge(List<List<Integer>> adjList, int[] uv) {
		int u = uv[0];
		int v = uv[1];
		adjList.get(u).add(v);
		adjList.get(v).add(u);
	}

}

class Pair {
	int node;
	int parent;

	public Pair(Integer node, int parent) {
		this.node = node;
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Pair [node=" + node + ", parent=" + parent + "]";
	}

}
