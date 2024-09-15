package com.altafjava.neetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
207. Course Schedule
https://leetcode.com/problems/course-schedule/description/

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given 
an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you
want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Constraints:
    1 <= numCourses <= 2000
    0 <= prerequisites.length <= 5000
    prerequisites[i].length == 2
    0 <= ai, bi < numCourses
    All the pairs prerequisites[i] are unique.
*/
public class CourseSchedule {

	public static void main(String[] args) {
//		int numCourses = 2, prerequisites[][] = {{1, 0}};
		int numCourses = 2, prerequisites[][] = {{1, 0},{0,1}};
//		int numCourses = 5, prerequisites[][] = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 3, 4 } };
		boolean canFinish = canFinish(numCourses, prerequisites);
		System.out.println(canFinish); // Output: true
	}

	static public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> adjListMap= new HashMap<>();
		createAdjacencyList(numCourses, prerequisites, adjListMap);
		Set<Integer> visited = new HashSet<>();
		int firstNode = prerequisites[0][0];
		Queue<Integer> q = new LinkedList<>();
		q.add(firstNode);
		visited.add(firstNode);
		int count=0;
		while(!q.isEmpty()) {
			Integer pollNode = q.poll();
			count++;
			List<Integer> list = adjListMap.get(pollNode);
			if (list != null) {
				for (int neighbour : list) {
					if (!visited.contains(neighbour)) {
						q.add(neighbour);
						visited.add(neighbour);
					}
				}
			}
		}
		return count==numCourses;
	}

	static private void createAdjacencyList(int numCourses, int[][] edges, Map<Integer, List<Integer>> adjListMap) {
		for (int[] edge : edges) {
			int vertex = edge[0];
			adjListMap.putIfAbsent(vertex, new ArrayList<>());
			adjListMap.get(vertex).add(edge[1]);
		}
	}
}
