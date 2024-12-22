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

const dr = [1, -1, 0, 0];
const dc = [0, 0, 1, -1];

const findInitialCoords = (graph) => {
  const R = graph.length,
    C = graph[0].length;

  const ends = [];
  let start;
  const fires = [];
  for (let r = 0; r < R; r++) {
    for (let c = 0; c < C; c++) {
      if (r === 0 && (graph[r][c] === "." || graph[r][c] === "J"))
        ends.push([r, c]);
      else if (c === 0 && (graph[r][c] === "." || graph[r][c] === "J"))
        ends.push([r, c]);
      else if (r === R - 1 && (graph[r][c] === "." || graph[r][c] === "J"))
        ends.push([r, c]);
      else if (c === C - 1 && (graph[r][c] === "." || graph[r][c] === "J"))
        ends.push([r, c]);

      if (graph[r][c] === "J") start = [r, c];

      if (graph[r][c] === "F") fires.push([r, c]);
    }
  }
  return { ends, start, fires };
};

const isDead = (graph) => {
  for (let r = 0; r < graph.length; r++) {
    for (let c = 0; c < graph[0].length; c++) {
      if (graph[r][c] === "J") return false;
    }
  }
  return true;
};

const bfs = (graph, start, fires, ends) => {
  const R = graph.length,
    C = graph[0].length;

  const visited = Array.from({ length: R }, () => Array(C).fill(0));
  visited[start[0]][start[1]] = 1;

  let jQueue = [start];
  let fireQueue = [...fires];

  while (jQueue.length) {
    const newJQueue = [];

    for (let [jr, jc] of jQueue) {
      for (let i = 0; i < 4; i++) {
        const nr = jr + dr[i];
        const nc = jc + dc[i];

        if (nr === -1 || nr === R || nc === -1 || nc === C) {
          return visited[jr][jc];
        }

        if (
          0 <= nr &&
          nr < R &&
          0 <= nc &&
          nc < C &&
          graph[nr][nc] === "." &&
          visited[nr][nc] === 0
        ) {
          graph[jr][jc] = ".";
          graph[nr][nc] = "J";
          visited[nr][nc] = visited[jr][jc] + 1;
          newJQueue.push([nr, nc]);
        }
      }
    }

    jQueue = newJQueue;

    const newFireQueue = [];
    const fireSet = new Set();
    fireQueue.forEach(([fr, fc]) => {
      for (let i = 0; i < 4; i++) {
        const nr = fr + dr[i];
        const nc = fc + dc[i];

        if (
          0 <= nr &&
          nr < R &&
          0 <= nc &&
          nc < C &&
          (graph[nr][nc] === "." || graph[nr][nc] === "J")
        ) {
          graph[nr][nc] = "F";
          visited[nr][nc] = -1;
          fireSet.add(`${nr},${nc}`);
          newFireQueue.push([nr, nc]);
        }
      }
    });
    fireQueue = newFireQueue;

    jQueue = jQueue.filter(([jr, jc]) => !fireSet.has(`${jr},${jc}`));

    if (isDead(graph)) break;
  }

  return "IMPOSSIBLE";
};

const solution = (input) => {
  const [R, C] = input[0].split(" ").map(Number);
  const graph = [];

  for (let i = 1; i <= R; i++) {
    graph.push(input[i].split(""));
  }

  const { start, fires, ends } = findInitialCoords(graph);
  const answer = bfs(graph, start, fires, ends);
  console.log(answer);
};

solution(input);