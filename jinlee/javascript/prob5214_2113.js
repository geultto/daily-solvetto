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

const combination = (arr, n) => {
  if (n === 1) return arr;

  const result = [];
  arr.forEach((v, idx, arr) => {
    const rest = arr.slice(idx + 1);
    const combinations = combination(rest, n - 1);
    const sums = combinations.map((sum) => v + sum);
    result.push(...sums);
  });
  return result;
};

const solution = (input) => {
  const [N, S] = input[0].split(" ").map(Number);
  const arr = input[1].split(" ").map(Number);
  let answer = 0;
  for (let i = 1; i <= N; i++) {
    const sums = combination(arr, i);
    for (let sum of sums) {
      if (sum === S) answer++;
    }
  }
  console.log(answer);
};

solution(input);