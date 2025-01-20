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

const backtracking = (results, numbers, n, symbols) => {
  if (symbols.length === n) {
    const str = numbers.join("");
    if (Number(results[0] < Number(str))) {
      results[0] = str;
    }
    if (Number(results[1]) > Number(str)) {
      results[1] = str;
    }
    return;
  }

  if (n === -1) {
    for (let i = 0; i <= 9; i++) {
      numbers.push(i);
      backtracking(results, numbers, n + 1, symbols);
      numbers.pop();
    }
  }

  if (symbols[n] === "<") {
    for (let i = numbers[n] + 1; i <= 9; i++) {
      if (!numbers.includes(i)) {
        numbers.push(i);
        backtracking(results, numbers, n + 1, symbols);
        numbers.pop();
      }
    }
  } else {
    for (let i = 0; i < numbers[n]; i++) {
      if (!numbers.includes(i)) {
        numbers.push(i);
        backtracking(results, numbers, n + 1, symbols);
        numbers.pop();
      }
    }
  }
  return;
};

const solution = (input) => {
  const n = Number(input[0]);
  const symbols = input[1].split(" ");

  const results = [0, Infinity];
  backtracking(results, [], -1, symbols);

  console.log(results.join("\n"));
};

solution(input);