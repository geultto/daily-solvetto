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

const N = 5;
const DIR = ["N", "E", "S", "W"];
const WALL = 0;
const moves = [
  [0, 0, 1],
  [0, 0, -1],
  [0, 1, 0],
  [0, -1, 0],
  [1, 0, 0],
  [-1, 0, 0],
];
const isIn = (r, c, h, N) =>
  0 <= r && r < N && 0 <= c && c < N && 0 <= h && h < N;

const backtracking = (arr, n) => {
  if (n === 1) return arr.map((v) => [v]);

  const result = [];
  arr.forEach((v, _, arr) => {
    const permutations = backtracking(arr, n - 1);
    const attach = permutations.map((permutation) => [v, ...permutation]);
    result.push(...attach);
  });
  return result;
};

const permutation = (arr, n) => {
  if (n === 1) return arr.map((v) => [v]);

  const result = [];
  arr.forEach((v, idx, arr) => {
    const rest = [...arr.slice(0, idx), ...arr.slice(idx + 1)];
    const permutations = permutation(rest, n - 1);
    const attach = permutations.map((permutation) => [v, ...permutation]);
    result.push(...attach);
  });
  return result;
};

const rotation = (dir, matrix) => {
  const rotated = Array.from({ length: N }, () => Array(N).fill(0));
  if (dir === "N") return matrix;
  else if (dir === "E") {
    for (let r = 0; r < N; r++) {
      for (let c = 0; c < N; c++) {
        rotated[c][N - r - 1] = matrix[r][c];
      }
    }
    return rotated;
  } else if (dir === "S") {
    for (let r = 0; r < N; r++) {
      for (let c = 0; c < N; c++) {
        rotated[N - r - 1][N - c - 1] = matrix[r][c];
      }
    }
    return rotated;
  } else {
    for (let r = 0; r < N; r++) {
      for (let c = 0; c < N; c++) {
        rotated[N - c - 1][r] = matrix[r][c];
      }
    }
    return rotated;
  }
};

const bfs = (maze) => {
  const visited = Array.from({ length: N }, () =>
    Array.from({ length: N }, () => Array(N).fill(0)),
  );
  const queue = [[0, 0, 0]];

  while (queue.length) {
    const [r, c, h] = queue.shift();

    for (let [dr, dc, dh] of moves) {
      const nr = r + dr;
      const nc = c + dc;
      const nh = h + dh;

      if (
        isIn(nr, nc, nh, N) &&
        visited[nh][nr][nc] === 0 &&
        maze[nh][nr][nc] !== WALL
      ) {
        visited[nh][nr][nc] = visited[h][r][c] + 1;
        queue.push([nr, nc, nh]);
      }
    }
  }

  return visited[4][4][4];
};

const solution = (input) => {
  const floors = Array.from({ length: N }, () => []);
  let lineIdx = 0;
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      floors[i].push(input[lineIdx].split(" ").map(Number));
      lineIdx++;
    }
  }
  // console.log(floors);
  const dirPermutations = backtracking(DIR, 5);
  const idxPermutations = permutation([0, 1, 2, 3, 4], 5);
  const mazes = [];

  for (let idxArr of idxPermutations) {
    for (let dirArr of dirPermutations) {
      const maze = [];
      for (let i = 0; i < 5; i++) {
        const idx = idxArr[i];
        const dir = dirArr[i];
        const floor = rotation(dir, floors[idx]);
        maze.push(floor);
      }
      mazes.push(maze);
    }
  }
  const MAX = 10000;
  let answer = MAX;
  for (let maze of mazes) {
    if (maze[0][0][0] !== WALL) {
      const cnt = bfs(maze);
      if (cnt > 0) answer = Math.min(answer, cnt);
    }
  }
  console.log(answer === MAX ? -1 : answer);
};

solution(input);