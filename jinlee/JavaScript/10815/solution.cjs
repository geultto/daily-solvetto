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

const hasNumber = (cards, target) => {
  let st = 0,
    en = cards.length - 1;

  while (st <= en) {
    let mid = Math.floor((st + en) / 2);
    if (cards[mid] === target) return 1;
    else if (cards[mid] > target) {
      en = mid - 1;
    } else {
      st = mid + 1;
    }
  }
  return 0;
};

const solution = (input) => {
  const N = Number(input[0]);
  const cards = input[1].split(" ").map(Number);
  const M = Number(input[2]);
  const testcases = input[3].split(" ").map(Number);

  cards.sort((a, b) => a - b);
  const answer = [];
  testcases.forEach((testcase) => answer.push(hasNumber(cards, testcase)));
  console.log(answer.join(" "));
};

solution(input);
