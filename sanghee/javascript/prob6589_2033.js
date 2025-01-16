const input = require("fs")
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input.shift().split(" ").map(Number);
input.sort();
const list = new Map();
let count = 0;

for (let i = 0; i < N + M; i++) {
  list.set(input[i], list.get(input[i]) + 1 || 0);
  if (list.get(input[i]) > 0) count++;
}

console.log(count);

list.forEach((value, key) => {
  if (value > 0) console.log(key);
});