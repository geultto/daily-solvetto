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

const alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

const isDoor = (v) => alphabets.includes(v);
const isKey = (v) => alphabets.toLowerCase().includes(v);
const WALL = "*";
const PAPER = "$";
const EMPTY = ".";

const findStart = (graph, keys) => {
  let path = 0;
  let paperCnt = 0;
  const R = graph.length,
    C = graph[0].length;

  const starts = [];
  for (let r = 0; r < R; r++) {
    for (let c = 0; c < C; c++) {
      const cell = graph[r][c];
      if (r === 0 || c === 0 || r === R - 1 || c === C - 1) {
        if (isDoor(cell)) {
          if (keys.includes(cell.toLowerCase())) {
            graph[r][c] = EMPTY;
          }
          starts.push([r, c]);
        } else if (isKey(cell)) {
          keys.push(cell);
          graph[r][c] = EMPTY;
          starts.push([r, c]);
        } else if (cell === EMPTY) {
          starts.push([r, c]);
        } else if (cell === PAPER) {
          paperCnt++;
          graph[r][c] = EMPTY;
          starts.push([r, c]);
        }
      }
      if (graph[r][c] === ".") path++;
    }
  }
  return { starts, path, paperCnt };
};

const openDoor = (graph, start, keys) => {
  const cell = graph[start[0]][start[1]];
  if (isDoor(cell) && !keys.includes(cell.toLowerCase())) return;

  const R = graph.length,
    C = graph[0].length;
  const visited = Array.from({ length: R }, () => Array(C).fill(false));

  visited[start[0]][start[1]] = true;
  const queue = [start];

  while (queue.length) {
    const [r, c] = queue.shift();

    for (let i = 0; i < 4; i++) {
      const nr = r + dr[i];
      const nc = c + dc[i];

      if (0 <= nr && nr < R && 0 <= nc && nc < C && !visited[nr][nc]) {
        const cell = graph[nr][nc];
        if (cell === EMPTY) {
          queue.push([nr, nc]);
          visited[nr][nc] = true;
        } else if (isDoor(cell) && keys.includes(graph[nr][nc].toLowerCase())) {
          graph[nr][nc] = EMPTY;
          queue.push([nr, nc]);
          visited[nr][nc] = true;
        } else if (isKey(cell)) {
          keys.push(cell);
          graph[nr][nc] = EMPTY;
          queue.push([nr, nc]);
          visited[nr][nc] = true;
        } else if (graph[nr][nc] === PAPER) {
          queue.push([nr, nc]);
          visited[nr][nc] = true;
        }
      }
    }
  }
};

const findPaper = (graph, starts, keys) => {
  const queue = [];
  for (let start of starts) {
    const cell = graph[start[0]][start[1]];
    if (isDoor(cell) && !keys.includes(cell.toLowerCase())) continue;

    queue.push(start);
  }
  const R = graph.length,
    C = graph[0].length;
  const visited = Array.from({ length: R }, () => Array(C).fill(false));
  let paperCnt = 0;

  while (queue.length) {
    const [r, c] = queue.shift();

    for (let i = 0; i < 4; i++) {
      const nr = r + dr[i];
      const nc = c + dc[i];

      if (0 <= nr && nr < R && 0 <= nc && nc < C && !visited[nr][nc]) {
        if (graph[nr][nc] === EMPTY) {
          queue.push([nr, nc]);
          visited[nr][nc] = true;
        } else if (graph[nr][nc] === PAPER) {
          queue.push([nr, nc]);
          visited[nr][nc] = true;
          paperCnt++;
        }
      }
    }
  }
  return paperCnt;
};

const countPath = (graph) => {
  let path = 0;
  for (let r = 0; r < graph.length; r++) {
    for (let c = 0; c < graph[0].length; c++) {
      if (graph[r][c] === ".") path++;
    }
  }
  return path;
};

const solution = (graph, keys) => {
  const { starts, path, paperCnt } = findStart(graph, keys);

  let prevPath = path;
  while (true) {
    starts.forEach((start) => openDoor(graph, start, keys));
    const path = countPath(graph);

    if (prevPath === path) break;
    else prevPath = path;
  }
  const answer = findPaper(graph, starts, keys);
  return answer + paperCnt;
};

const main = (input) => {
  const T = Number(input[0]);
  let lineIdx = 1;
  const answers = [];
  for (let t = 0; t < T; t++) {
    const [h, w] = input[lineIdx].split(" ").map(Number);
    lineIdx++;

    const graph = [];
    for (let i = 0; i < h; i++) {
      graph.push(input[lineIdx].split(""));
      lineIdx++;
    }
    const keys = input[lineIdx].split("");
    lineIdx++;
    const answer = solution(graph, keys);
    answers.push(answer);
  }
  console.log(answers.join("\n"));
};

main(input);