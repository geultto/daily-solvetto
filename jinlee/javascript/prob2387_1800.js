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

//hedgehog
const HEDGEHOG = "S";
const BEVER = "D";
const ROCK = "X";
const EMPTY = ".";
const WATER = "*";
const moves = [
  [1, 0],
  [-1, 0],
  [0, 1],
  [0, -1],
];
const isIn = (r, c, R, C) => 0 <= r && r < R && 0 <= c && c < C;

const findInitialCoords = (graph, R, C) => {
  const water = [];
  const hedgehog = [];

  for (let r = 0; r < R; r++) {
    for (let c = 0; c < C; c++) {
      if (graph[r][c] === HEDGEHOG) {
        hedgehog.push(r, c);
        graph[r][c] = EMPTY;
      } else if (graph[r][c] === WATER) water.push([r, c]);
    }
  }
  return { water, hedgehog };
};

const bfs = (graph, coords, R, C) => {
  const { water, hedgehog } = coords;
  const visited = Array.from({ length: R }, () => Array(C).fill(false));

  let waterQueue = [...water];
  let queue = [[hedgehog, 0]];

  while (queue.length) {
    const newWater = [];
    waterQueue.forEach(([r, c]) => {
      for (let [dr, dc] of moves) {
        const nr = r + dr;
        const nc = c + dc;

        if (
          isIn(nr, nc, R, C) &&
          graph[nr][nc] !== ROCK &&
          graph[nr][nc] !== BEVER &&
          graph[nr][nc] !== WATER
        ) {
          graph[nr][nc] = WATER;
          newWater.push([nr, nc]);
        }
      }
    });
    waterQueue = newWater;

    const newHedgeHog = [];
    for (let [hedgehog, move] of queue) {
      const [r, c] = hedgehog;
      if (graph[r][c] === BEVER) return move;
      for (let [dr, dc] of moves) {
        const nr = r + dr;
        const nc = c + dc;

        if (
          isIn(nr, nc, R, C) &&
          !visited[nr][nc] &&
          (graph[nr][nc] === EMPTY || graph[nr][nc] === BEVER)
        ) {
          visited[nr][nc] = true;
          newHedgeHog.push([[nr, nc], move + 1]);
        }
      }
    }
    queue = newHedgeHog;
  }
  return "KAKTUS";
};

const solution = (input) => {
  const [R, C] = input[0].split(" ").map(Number);
  const graph = input.slice(1).map((row) => row.split(""));

  const coords = findInitialCoords(graph, R, C);
  console.log(bfs(graph, coords, R, C));
};

solution(input);