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

  let lineIdx = 1;
  const graph = Array.from({ length: N + 1 }, () =>
    Array(N + 1).fill(Infinity),
  );

  for (let i = 1; i <= N; i++) {
    graph[i][i] = 0;
  }
  for (let i = 1; i <= N - 1; i++) {
    const [a, b, dist] = input[lineIdx].split(" ").map(Number);
    graph[a][b] = dist;
    graph[b][a] = dist;
    lineIdx++;
  }

  for (let k = 1; k <= N; k++) {
    for (let i = 1; i <= N; i++) {
      for (let j = 1; j <= N; j++) {
        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
      }
    }
  }

  const answer = [];
  for (let i = 0; i < M; i++) {
    const [a, b] = input[lineIdx].split(" ").map(Number);
    answer.push(graph[a][b]);
    lineIdx++;
  }
  console.log(answer.join("\n"));
};

solution(input);