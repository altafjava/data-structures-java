package com.altafjava.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphBFS {

	private Map<Integer, List<Integer>> adjListMap;

	public GraphBFS() {
		adjListMap=new HashMap<>();
	}
	
	public void addEdge(int u, int v) {
		adjListMap.putIfAbsent(u, new ArrayList<>());
		adjListMap.putIfAbsent(v, new ArrayList<>());
		adjListMap.get(u).add(v);
		adjListMap.get(v).add(u);//For undirected graph
	}
	
	public void bfs(int start) {
		Set<Integer> visited=new HashSet<>();
		visited.add(start);
		Queue<Integer> q=new LinkedList<>();
		q.add(start);
		System.out.print("[");
		while(!q.isEmpty()) {
			Integer poll = q.poll();
			System.out.print(poll+" ");
			for(int neighbour:adjListMap.get(poll)) {
				if(!visited.contains(neighbour)) {
					q.add(neighbour);
					visited.add(neighbour);
				}
			}
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		GraphBFS graph=new GraphBFS();
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		
		graph.bfs(0);
		graph.bfs(3);
	}
	
}
