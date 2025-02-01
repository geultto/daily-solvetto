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

const bfs = (graph) => {
  const visited = Array(graph.length).fill(false);
  const dists = Array(graph.length).fill(0);
  const queue = [[1, 0]];
  visited[1] = true;

  while (queue.length) {
    const [cur, moves] = queue.shift();

    for (let next of graph[cur]) {
      if (!visited[next]) {
        dists[next] = moves + 1;
        visited[next] = true;
        queue.push([next, moves + 1]);
      }
    }
  }
  return dists;
};

const solution = (input) => {
  const [N, M] = input[0].split(" ").map(Number);
  const graph = Array.from({ length: N + 1 }, () => []);

  for (let i = 1; i <= M; i++) {
    const [a, b] = input[i].split(" ").map(Number);
    graph[a].push(b);
    graph[b].push(a);
  }
  const dists = bfs(graph);
  const maxDist = Math.max(...dists);
  const maxNode = dists.findIndex((v) => v === maxDist);
  const cnt = dists.filter((v) => v === maxDist).length;
  console.log(`${maxNode} ${maxDist} ${cnt}`);
};

solution(input);