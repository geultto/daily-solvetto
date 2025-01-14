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

const isSame = (picture, r, c, range) => {
  const target = picture[r][c];
  for (let i = r; i < r + range; i++) {
    for (let j = c; j < c + range; j++) {
      if (picture[i][j] !== target) return false;
    }
  }
  return true;
};

const recursive = (picture, r, c, range, arr) => {
  if (range === 1) {
    for (let i = r; i < r + range; i++) {
      for (let j = c; j < c + range; j++) {
        arr.push(picture[r][c]);
      }
    }
    return;
  }

  if (isSame(picture, r, c, range)) {
    arr.push(picture[r][c]);
  } else {
    arr.push("(");
    for (let i = r; i < r + range; i += range / 2) {
      for (let j = c; j < c + range; j += range / 2) {
        recursive(picture, i, j, range / 2, arr);
      }
    }
    arr.push(")");
  }
};

const solution = (input) => {
  const N = Number(input[0]);
  const picture = [];

  for (let i = 1; i <= N; i++) {
    picture.push(input[i].split("").map(Number));
  }
  const arr = [];
  recursive(picture, 0, 0, N, arr);
  console.log(arr.join(""));
};

solution(input);

module.exports = { solution };