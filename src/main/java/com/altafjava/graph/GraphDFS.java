package com.altafjava.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphDFS {

	private Map<Integer, List<Integer>> adjListMap;

	public GraphDFS() {
		this.adjListMap = new HashMap<>();
	}

	public void addEdge(int u, int v) {
		adjListMap.putIfAbsent(u, new ArrayList<>());
		adjListMap.putIfAbsent(v, new ArrayList<>());
		adjListMap.get(u).add(v);
		adjListMap.get(v).add(u);
	}

	public void dfs(int start) {
		Set<Integer> visited = new HashSet<>();
		System.out.print("[");
		dfsUtil(start, visited);
		System.out.println("]");
	}

	private void dfsUtil(int node, Set<Integer> visited) {
		visited.add(node);
		System.out.print(node + " ");
		for(int neighbour: adjListMap.get(node)) {
			if(!visited.contains(neighbour)) {
				visited.add(neighbour);
				dfsUtil(neighbour, visited);
			}
		}
	}

	public static void main(String[] args) {
		GraphDFS graph=new GraphDFS();
		graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        
        graph.dfs(0);
        graph.dfs(4);
	}

}
