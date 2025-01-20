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

const isIn = (r, c, h, w) => 0 <= r && r < h && 0 <= c && c < w;

const moves = [
  [1, 0],
  [-1, 0],
  [0, 1],
  [0, -1],
];

const bfs = (graph, visited, start, target) => {
  const queue = [start];
  const H = graph.length,
    W = graph[0].length;

  let area = 1;

  while (queue.length) {
    const [r, c] = queue.shift();

    for (let [dr, dc] of moves) {
      const nr = r + dr;
      const nc = c + dc;

      if (isIn(nr, nc, H, W) && !visited[nr][nc] && graph[nr][nc] === target) {
        area++;
        visited[nr][nc] = true;
        queue.push([nr, nc]);
      }
    }
  }
  return area;
};

const solution = (input) => {
  const [N, M] = input[0].split(" ");
  const graph = input.slice(1).map((row) => row.split(""));

  const visited = Array.from({ length: M }, () => Array(N).fill(false));

  let wArea = 0;
  let bArea = 0;
  for (let r = 0; r < M; r++) {
    for (let c = 0; c < N; c++) {
      if (!visited[r][c]) {
        if (graph[r][c] === "W") {
          visited[r][c] = true;
          wArea += Math.pow(bfs(graph, visited, [r, c], "W"), 2);
        } else {
          visited[r][c] = true;
          bArea += Math.pow(bfs(graph, visited, [r, c], "B"), 2);
        }
      }
    }
  }
  console.log(`${wArea} ${bArea}`);
};

solution(input);