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

/**
 * Set을 이용한 풀이 - 더 깔끔한듯

const [N, M] = input.shift().split(" ").map(Number);
const unheard = new Set(input.slice(0, N)); // 듣도 못한 사람
const unseen = new Set(input.slice(N));    // 보도 못한 사람

// 교집합 찾기
const intersection = [...unheard].filter((person) => unseen.has(person));

// 사전순 정렬
intersection.sort();

// 출력
console.log(intersection.length);
console.log(intersection.join("\n"));

 * 
 */
