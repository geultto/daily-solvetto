package LeeHyungGeol.java.programmers.여행경로;

import java.util.*;

public class Solution {
	private static ArrayList<String> list = new ArrayList<>();
	private static boolean[] visited;

	public String[] solution(String[][] tickets) {
		visited = new boolean[tickets.length];

		dfs(tickets, "ICN", "ICN", 0,tickets.length);

		Collections.sort(list);

		return list.get(0).split(" ");
	}

	static void dfs(String[][] tickets, String now, String route, int count, int size){
		if (count == size) {
			list.add(route);
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			if (!visited[i] && now.equals(tickets[i][0])) {
				visited[i] = true;
				dfs(tickets, tickets[i][1], route+" "+tickets[i][1], count+1, size);
				visited[i] = false;
			}
		}
	}
}
