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

class Queue {
  constructor() {
    this.storage = [];
    this.head = 0;
  }

  reset() {
    this.storage.splice(0);
    this.head = 0;
  }

  size() {
    return this.storage.length - this.head;
  }

  add(value) {
    this.storage.push(value);
  }

  popleft() {
    if (this.size() === 0) {
      return undefined;
    }
    const value = this.storage[this.head];
    this.head += 1;

    return value;
  }
}

const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];

const countArea = (graph, P) => {
  const arr = Array(P).fill(0);
  for (let p = 1; p <= arr.length; p++) {
    for (let j = 0; j < graph.length; j++) {
      for (let i = 0; i < graph[0].length; i++) {
        if (graph[j][i] == p) arr[p - 1]++;
      }
    }
  }
  return arr;
};

const buildCastle = (graph, arr) => {
  const queues = Array.from({ length: arr.length }, () => new Queue());
  const visited = Array.from({ length: graph.length }, () =>
    Array(graph[0].length).fill(false),
  );

  let changes = true;
  while (changes) {
    changes = false; // 확장이 발생했는지 확인
    for (let p = 1; p <= arr.length; p++) {
      for (let j = 0; j < graph.length; j++) {
        for (let i = 0; i < graph[0].length; i++) {
          if (graph[j][i] == p) {
            queues[p - 1].add([i, j, 0]);
            visited[j][i] = true;
          }
        }
      }

      while (queues[p - 1].size()) {
        const [x, y, cnt] = queues[p - 1].popleft();
        if (cnt === arr[p - 1]) {
          queues[p - 1].reset(0);
          break;
        }

        for (let i = 0; i < 4; i++) {
          const nx = x + dx[i];
          const ny = y + dy[i];

          if (
            0 <= nx &&
            nx < graph[0].length &&
            0 <= ny &&
            ny < graph.length &&
            graph[ny][nx] === "." &&
            !visited[ny][nx]
          ) {
            graph[ny][nx] = p;
            visited[ny][nx] = true;
            queues[p - 1].add([nx, ny, cnt + 1]);
            changes = true;
          }
        }
      }
    }
  }
};

const solution = (input) => {
  const [N, M, P] = input[0].split(" ").map(Number);
  const arr = input[1].split(" ").map(Number);

  const graph = input
    .slice(2)
    .map((v) => v.split("").map((ch) => (ch !== "." && ch !== "#" ? +ch : ch)));
  buildCastle(graph, arr);
  const area = countArea(graph, P);
  console.log(area.join(" "));
};

solution(input);
