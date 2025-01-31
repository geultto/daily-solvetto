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

const solution = (input) => {
  const [N, M] = input.split(" ").map((v) => v.split("").reverse().join(""));
  console.log(N > M ? N : M);
};

solution(input);