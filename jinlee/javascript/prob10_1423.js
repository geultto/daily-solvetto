const fs = require("fs");
const path = require("path");
const input = fs
  .readFileSync(
    process.platform === "linux"
      ? "/dev/stdin"
      : path.join(__dirname, "/input.txt"),
  )
  .toString()
  .trim();

const recursive = (stars, startR, startC, N) => {
  if (N === 1) return;

  for (let i = startR; i < startR + N; i += N / 3) {
    for (let j = startC; j < startC + N; j += N / 3) {
      if (i === startR + N / 3 && j === startC + N / 3) {
        for (let r = i; r < i + N / 3; r++) {
          for (let c = j; c < j + N / 3; c++) {
            stars[r][c] = " ";
          }
        }
      } else {
        recursive(stars, i, j, N / 3);
      }
    }
  }
};

const solution = (input) => {
  const N = Number(input);
  const stars = Array.from({ length: N }, () => Array(N).fill("*"));
  recursive(stars, 0, 0, N);
  console.log(stars.map((row) => row.join("")).join("\n"));
};

solution(input);