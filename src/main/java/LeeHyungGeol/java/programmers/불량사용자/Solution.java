package LeeHyungGeol.java.programmers.불량사용자;

import java.util.*;

public class Solution {
	private static Set<String> Answer = new HashSet<>();

	public int solution(String[] user_id, String[] banned_id) {
		dfs(user_id, banned_id, new boolean[user_id.length], "", 0);

		return Answer.size();
	}

	private void dfs(String[] userIds, String[] bannedIds, boolean[] visited, String cases, int count) {
		if (count == bannedIds.length) {
			String[] split = cases.split(" ");
			Arrays.sort(split);
			Answer.add(String.join(" ", split));
			return;
		}

		for (int i = 0; i < userIds.length; ++i) {
			if (!visited[i] && isMatched(bannedIds[count], userIds[i])) {
				visited[i] = true;
				dfs(userIds, bannedIds, visited, cases+" "+userIds[i], count+1);
				visited[i] = false;
			}
		}
	}

	private boolean isMatched(String bannedId, String userId) {
		if (bannedId.length() != userId.length()) {
			return false;
		}

		for (int i = 0; i < bannedId.length(); ++i) {
			if (bannedId.charAt(i) == '*') continue;
			if (bannedId.charAt(i) != userId.charAt(i)) {
				return false;
			}
		}

		return true;
	}
}
