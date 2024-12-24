package LeeHyungGeol.java.programmers.베스트앨범;

import java.util.*;

public class Solution {
	static class PlayCount implements Comparable<PlayCount>{
		private String genre;
		private int count;
		private int index;

		public PlayCount (String genre, int count) {
			this.genre = genre;
			this.count = count;
		}

		public PlayCount(int count, int index) {
			this.count = count;
			this.index = index;
		}

		public String getGenre() {
			return this.genre;
		}

		public int getCount() {
			return this.count;
		}

		public int getIndex() {
			return this.index;
		}

		public int compareTo(PlayCount that) {
			if (this.getCount() == that.getCount()) {
				return this.getIndex() - that.getIndex();
			}
			return that.getCount() - this.getCount();
		}
	}

	public int[] solution(String[] genres, int[] plays) {
		List<Integer> answer = new ArrayList<>();
		Map<String, Integer> totalPlays = new HashMap<>();
		Map<String, Set<PlayCount>> playCounts = new HashMap<>();

		for (int i = 0; i < genres.length; ++i) {
			totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
			playCounts.computeIfAbsent(genres[i], k -> new TreeSet<>()).add(new PlayCount(plays[i], i));
		}

		List<PlayCount> temp = new ArrayList<>();

		for (String genre : totalPlays.keySet()) {
			temp.add(new PlayCount(genre, totalPlays.get(genre)));
		}

		Collections.sort(temp);

		for (PlayCount key : temp) {
			int count = 0;
			for (PlayCount playCount : playCounts.get(key.getGenre())) {
				if (count == 2) break;
				answer.add(playCount.getIndex());
				++count;
			}
		}

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}
