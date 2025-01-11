const input = require("fs")
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split("\n");

const N = Number(input.shift());
const stack = [];
const answer = [];

for (let i = 0; i < N; i++) {
  const option = input[i].split(" ").map(Number);
  if (option[0] === 1) {
    stack.push(option[1]);
  } else if (option[0] === 2) {
    if (stack.length > 0) {
      answer.push(stack.pop());
    } else {
      answer.push(-1);
    }
  } else if (option[0] === 3) {
    answer.push(stack.length);
  } else if (option[0] === 4) {
    if (stack.length > 0) {
      answer.push(0);
    } else {
      answer.push(1);
    }
  } else if (option[0] === 5) {
    if (stack.length > 0) {
      answer.push(stack.at(-1));
    } else {
      answer.push(-1);
    }
  }
}

console.log(answer.join("\n"));