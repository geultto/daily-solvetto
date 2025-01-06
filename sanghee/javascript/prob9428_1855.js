function solution(n, words) {
  const wordList = [];

  for (let i = 0; i < words.length; i++) {
    if (
      wordList.includes(words[i]) ||
      (wordList.length > 0 && wordList.at(-1).at(-1) !== words[i][0])
    ) {
      return [(i % n) + 1, Math.floor(i / n) + 1];
    }

    wordList.push(words[i]);
  }

  return [0, 0];
}