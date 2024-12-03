// 프로그래머스 https://school.programmers.co.kr/learn/courses/30/lessons/42579
// 느낀 점
// 어떤 결과물을 만들어 낼 것인가에 따라 사용하는 방법이 다르다. 효율적인 결과물을 만들어내는 식을 도출해봐야겠다.
// 메서드를 자유자재로 사용할 줄 알아야 하겠다.
// 혼자 생각하는 힘이 부족하다. 어떻게 기를 수 있을지..?
// 자료구조를 변경해서 푸는 문제를 많이 풀어보고싶다.

function solution1(genres, plays) {
  const playObj = {};
  const genreObj = {};
  const answer = [];

  for (let i = 0; i < genres.length; i++) {
    const genre = genres[i];
    const play = plays[i];

    if (!(genre in genreObj)) {
      genreObj[genre] = [];
      playObj[genre] = 0;
    }

    genreObj[genre].push([i, play]);
    playObj[genre] += play;
  }

  const sortedGenres = Object.keys(playObj).sort((a, b) => {
    return playObj[b] - playObj[a];
  });

  for (let genre of sortedGenres) {
    const sortedSongs = genreObj[genre].sort((a, b) => {
      return a[1] === b[1] ? a[0] - b[0] : b[1] - a[1];
    });

    answer.push(...sortedSongs.slice(0, 2).map((song) => song[0]));
  }

  return answer;
}

// gpt 풀이
// solution1과 차이점
// 1. reduce를 사용하여 genreData 하나만 사용하였다.
// 2. 장르별 데이터를 totalPlays와 songs로 구조화하여 명확히 표현했다.
// 3. 정렬 기준에서 동일한 재생 횟수일 경우 id 기준 정렬을 더 직관적으로 작성했다.
function solution2(genres, plays) {
  const genreData = genres.reduce((acc, genre, index) => {
    const play = plays[index];

    if (!acc[genre]) {
      acc[genre] = { totalPlays: 0, songs: [] };
    }

    acc[genre].totalPlays += play;
    acc[genre].songs.push({ id: index, plays: play });

    return acc;
  }, {});

  // 장르별로 총 재생 횟수 기준으로 정렬
  const sortedGenres = Object.entries(genreData).sort(
    ([, a], [, b]) => b.totalPlays - a.totalPlays
  );

  // 장르별로 상위 두 곡의 id를 가져오기
  const answer = sortedGenres.flatMap(([_, { songs }]) =>
    songs
      .sort((a, b) => b.plays - a.plays || a.id - b.id) // 재생 횟수 > 고유 id 정렬
      .slice(0, 2) // 상위 2곡만 가져오기
      .map((song) => song.id)
  );

  return answer;
}
