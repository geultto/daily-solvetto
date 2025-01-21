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

const solution = (input) => {
  const [N, M] = input[0].split(" ").map(Number);

  const graph = [];
  for (let i = 1; i <= N; i++) {
    graph.push(input[i].split(" ").map(Number));
  }
  const dp = Array.from({ length: N + 1 }, () => Array(M + 1).fill(0));

  dp[1][1] = graph[0][0];

  for (let r = 1; r <= N; r++) {
    for (let c = 1; c <= M; c++) {
      dp[r][c] =
        Math.max(dp[r - 1][c - 1], dp[r][c - 1], dp[r - 1][c]) +
        graph[r - 1][c - 1];
    }
  }
  console.log(dp[N][M]);
};

solution(input);