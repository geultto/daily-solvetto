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

const sorting = (graph, indegree) => {
  const queue = [];
  for (let i = 1; i < indegree.length; i++) {
    if (indegree[i] === 0) queue.push(i);
  }
  const answer = [];

  while (queue.length) {
    const cur = queue.shift();
    answer.push(cur);

    for (let next of graph[cur]) {
      indegree[next]--;
      if (indegree[next] === 0) queue.push(next);
    }
  }
  return answer;
};

const solution = (input) => {
  const [N, M] = input[0].split(" ").map(Number);
  const graph = Array.from({ length: N + 1 }, () => []);
  const indegree = Array(N + 1).fill(0);

  for (let i = 1; i <= M; i++) {
    const [a, b] = input[i].split(" ").map(Number);
    graph[a].push(b);
    indegree[b]++;
  }
  const answer = sorting(graph, indegree);
  console.log(answer.join(" "));
};

solution(input);