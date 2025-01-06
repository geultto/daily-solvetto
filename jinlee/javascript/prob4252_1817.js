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

const findDiagonal = (n) => {
  let i = 1;
  let sum = 1;
  while (sum < n) {
    i++;
    sum += i;
  }
  return [i, sum - i + 1];
};

const solution = (input) => {
  const X = Number(input);

  let [n, st] = findDiagonal(X); // 대각선 위치 찾기
  let answer = "";
  if (n % 2 === 1) {
    let i = n - (X - st);
    let j = 1 + (X - st);
    answer = `${i}/${j}`;
  } else {
    let i = 1 + (X - st);
    let j = n - (X - st);
    answer = `${i}/${j}`;
  }
  console.log(answer);
};

solution(input);