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

const canAttach = (board, start, sticker) => {
  const stickerHeight = sticker.length;
  const stickerWidth = sticker[0].length;
  const [startR, startC] = start;

  for (let r = 0; r < stickerHeight; r++) {
    for (let c = 0; c < stickerWidth; c++) {
      // sticker와 board의 sticker가 겹치는 경우
      if (board[r + startR][c + startC] === 1 && sticker[r][c] === 1) {
        return false;
      }
    }
  }
  return true;
};

const rotate = (sticker) => {
  const stickerHeight = sticker.length;
  const stickerWidth = sticker[0].length;

  const newSticker = Array.from({ length: stickerWidth }, () =>
    Array(stickerHeight).fill(0),
  );

  for (let r = 0; r < stickerHeight; r++) {
    for (let c = 0; c < stickerWidth; c++) {
      newSticker[c][stickerHeight - 1 - r] = sticker[r][c];
    }
  }
  return newSticker;
};

const findPosition = (board, sticker) => {
  const boardHeight = board.length;
  const boardWidth = board[0].length;
  const stickerHeight = sticker.length;
  const stickerWidth = sticker[0].length;
  const starts = [];

  for (let r = 0; r <= boardHeight - stickerHeight; r++) {
    for (let c = 0; c <= boardWidth - stickerWidth; c++) {
      if (canAttach(board, [r, c], sticker)) {
        starts.push([r, c]);
      }
    }
  }

  if (starts.length > 0) {
    starts.sort((a, b) => a[0] - b[0] || a[1] - b[1]);
    return starts[0];
  }
  return null;
};

const attach = (board, sticker, start) => {
  const stickerHeight = sticker.length;
  const stickerWidth = sticker[0].length;
  const [startR, startC] = start;

  for (let r = startR; r < startR + stickerHeight; r++) {
    for (let c = startC; c < startC + stickerWidth; c++) {
      if (sticker[r - startR][c - startC]) {
        board[r][c] = sticker[r - startR][c - startC];
      }
    }
  }
};

const count = (board) => {
  let cnt = 0;
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[0].length; j++) {
      if (board[i][j]) cnt++;
    }
  }
  return cnt;
};

const solution = (input) => {
  const [N, M, K] = input[0].split(" ").map(Number);
  const board = Array.from({ length: N }, () => Array(M).fill(0));
  let lineIdx = 1;
  const stickers = [];
  for (let i = 0; i < K; i++) {
    const [R, C] = input[lineIdx].split(" ").map(Number);
    lineIdx++;
    const sticker = [];
    for (let j = 0; j < R; j++) {
      sticker.push(input[lineIdx].split(" ").map(Number));
      lineIdx++;
    }
    stickers.push(sticker);
  }

  for (let sticker of stickers) {
    let idx = 0;
    let start = null;
    while (idx < 4) {
      start = findPosition(board, sticker);

      if (start) break;
      sticker = rotate(sticker);
      idx++;
    }
    if (!start) continue;

    attach(board, sticker, start);
  }

  console.log(count(board));
};

solution(input);