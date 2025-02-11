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

const backtracking = (symbols, numbers, pointer, result, callback) => {
  if (pointer === numbers.length) {
    callback(result);
    return;
  }

  for (let i = 0; i < symbols.length; i++) {
    if (symbols[i] > 0) {
      symbols[i]--;
      if (i === 0) {
        backtracking(
          symbols,
          numbers,
          pointer + 1,
          result + numbers[pointer],
          callback,
        );
      } else if (i === 1) {
        backtracking(
          symbols,
          numbers,
          pointer + 1,
          result - numbers[pointer],
          callback,
        );
      } else if (i === 2) {
        backtracking(
          symbols,
          numbers,
          pointer + 1,
          result * numbers[pointer],
          callback,
        );
      } else {
        if (result > 0) {
          backtracking(
            symbols,
            numbers,
            pointer + 1,
            Math.floor(result / numbers[pointer]),
            callback,
          );
        } else {
          backtracking(
            symbols,
            numbers,
            pointer + 1,
            Math.floor((result * -1) / numbers[pointer]) * -1,
            callback,
          );
        }
      }
      symbols[i]++;
    }
  }
};

const solution = (input) => {
  const N = Number(input[0]);

  const numbers = input[1].split(" ").map(Number);
  const symbols = input[2].split(" ").map(Number);

  let min = Infinity;
  let max = -Infinity;
  backtracking(symbols, numbers, 1, numbers[0], (result) => {
    (min = Math.min(min, result)), (max = Math.max(max, result));
  });
  console.log(`${max}\n${min}`);
};

solution(input);