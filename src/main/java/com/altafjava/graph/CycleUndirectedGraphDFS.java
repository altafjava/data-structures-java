package com.altafjava.graph;

import java.util.ArrayList;
import java.util.List;

public class CycleUndirectedGraphDFS {

	public static void main(String[] args) {
//		int graph[][] = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 } }, vertices = 5; // Cycle graph
//		int graph[][] = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } }, vertices = 5; // Non cycle graph
		int graph[][] = { { 0, 1 }, { 1, 2 }, { 3, 4 }, { 5, 6 } }, vertices = 7; // Undirected graph with multiple components
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < vertices; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < graph.length; i++) {
			addEdge(adjList, graph[i]);
		}
		boolean hasCycle = detectCycleDFS(vertices, adjList);
		System.out.println(hasCycle);
	}

	private static boolean detectCycleDFS(int vertices, List<List<Integer>> adjList) {
		boolean[] visited = new boolean[vertices];
		for (int i = 0; i < vertices; i++) {
			if (!visited[i]) {
				if (dfs(i, -1, adjList, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean dfs(int node, int parent, List<List<Integer>> adjList, boolean[] visited) {
		visited[node] = true;
		for (Integer neighbour : adjList.get(node)) {
			if (!visited[neighbour]) {
				if (dfs(neighbour, node, adjList, visited)) {
					return true;
				}
			} else if (neighbour != parent) {
				return true;
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