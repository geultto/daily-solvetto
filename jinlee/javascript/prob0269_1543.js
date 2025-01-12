const fs = require("fs");
const path = require("path");
const input = fs
  .readFileSync(
    process.platform === "linux"
      ? "/dev/stdin"
      : path.join(__dirname, "/input.txt"),
  )
  .toString()
  .trim()
  .split("\n");

const isSame = (paper, target, range) => {
  for (let r = 0; r < range; r++) {
    for (let c = 0; c < range; c++) {
      if (paper[r][c] !== target) return false;
    }
  }
  return true;
};

const recursive = (paper, range, answer) => {
  if (range === 1) {
    if (paper[0][0] === -1) {
      answer[0]++;
    } else if (paper[0][0] === 0) {
      answer[1]++;
    } else {
      answer[2]++;
    }
    return;
  }

  if (isSame(paper, paper[0][0], range)) {
    if (paper[0][0] === -1) {
      answer[0]++;
    } else if (paper[0][0] === 0) {
      answer[1]++;
    } else {
      answer[2]++;
    }
  } else {
    for (let i = 0; i < paper.length; i += range / 3) {
      for (let j = 0; j < paper.length; j += range / 3) {
        const newPaper = paper
          .slice(i, i + range / 3)
          .map((row) => row.slice(j, j + range / 3));
        recursive(newPaper, range / 3, answer);
      }
    }
  }
};

const solution = (input) => {
  const N = Number(input[0]);
  const paper = [];
  for (let i = 1; i <= N; i++) {
    paper.push(input[i].split(" ").map(Number));
  }
  const answer = [0, 0, 0];
  recursive(paper, N, answer);

  console.log(answer.join("\n"));
};

solution(input);