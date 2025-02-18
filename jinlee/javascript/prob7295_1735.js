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

const isIn = (r, c, N) => 0 <= r && r < N && 0 <= c && c < N;
const EMPTY = 0;
const WALL = 1;
const CUSTOMER = 2;

const moves = [
  [1, 0],
  [-1, 0],
  [0, 1],
  [0, -1],
];

const bfs = (board, start, end) => {
  const queue = [[...start, 0]];
  const N = board.length;
  const visited = Array.from({ length: N }, () => Array(N).fill(false));
  visited[start[0]][start[1]] = true;

  while (queue.length) {
    const [r, c, move] = queue.shift();
    if (r === end[0] && c === end[1]) {
      return move;
    }

    for (let [dr, dc] of moves) {
      const nr = r + dr;
      const nc = c + dc;

      if (isIn(nr, nc, N) && !visited[nr][nc] && board[nr][nc] !== WALL) {
        visited[nr][nc] = true;
        queue.push([nr, nc, move + 1]);
      }
    }
  }
  return -1;
};

const findClosestCustomer = (board, customers, start) => {
  const distances = Array.from({ length: board.length }, () =>
    Array(board.length).fill(-1),
  );
  distances[start[0]][start[1]] = 0;
  const queue = [[...start, 0]];
  while (queue.length) {
    const [r, c, move] = queue.shift();

    for (let [dr, dc] of moves) {
      const nr = r + dr;
      const nc = c + dc;

      if (
        isIn(nr, nc, board.length) &&
        board[nr][nc] !== WALL &&
        distances[nr][nc] === -1
      ) {
        distances[nr][nc] = move + 1;
        queue.push([nr, nc, move + 1]);
      }
    }
  }

  let closestCustomer;
  let min = Infinity;
  for (let customer of customers) {
    const [r, c] = customer.start;
    if (board[r][c] === EMPTY) continue;

    if (distances[r][c] < min) {
      min = distances[r][c];
      closestCustomer = customer;
    } else if (distances[r][c] === min) {
      if (closestCustomer.start[0] > customer.start[0]) {
        closestCustomer = customer;
      } else if (closestCustomer.start[0] === customer.start[0]) {
        if (closestCustomer.start[1] > customer.start[1]) {
          closestCustomer = customer;
        }
      }
    }
  }
  board[closestCustomer.start[0]][closestCustomer.start[1]] = EMPTY;
  return { closestCustomer, dist: min };
};

const isEnd = (board) => {
  for (let r = 0; r < board.length; r++) {
    for (let c = 0; c < board.length; c++) {
      if (board[r][c] === CUSTOMER) return false;
    }
  }
  return true;
};

const solution = (input) => {
  let [N, M, fuel] = input[0].split(" ").map(Number);
  const board = input.slice(1, N + 1).map((row) => row.split(" ").map(Number));
  let taxi = input[N + 1].split(" ").map((v) => Number(v) - 1);
  const customers = input.slice(N + 2).map((row) => {
    const [startR, startC, endR, endC] = row
      .split(" ")
      .map((v) => Number(v) - 1);
    board[startR][startC] = CUSTOMER;
    const dist = bfs(board, [startR, startC], [endR, endC]);
    return { start: [startR, startC], end: [endR, endC], dist };
  });

  if (customers.filter((v) => v.dist < 0).length > 0) {
    console.log(-1);
    return;
  }

  while (fuel >= 0) {
    if (isEnd(board)) {
      console.log(fuel);
      return;
    }
    const { closestCustomer, dist } = findClosestCustomer(
      board,
      customers,
      taxi,
    );

    if (dist < 0) break;

    if (fuel < dist) break;

    fuel -= dist;

    if (fuel < closestCustomer.dist) break;

    fuel += closestCustomer.dist;

    taxi = closestCustomer.end;
  }
  console.log(-1);
};

solution(input);