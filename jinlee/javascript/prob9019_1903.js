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

const backtracking = (eggs, idx, callback) => {
  if (idx === eggs.length) {
    callback(eggs.filter((v) => v[0] <= 0).length);
    return;
  }

  const [curS, curW] = eggs[idx];
  if (curS > 0) {
    for (let i = 0; i < eggs.length; i++) {
      if (idx === i) continue;

      const [selectS, selectW] = eggs[i];
      if (selectS <= 0) continue;

      eggs[idx][0] = curS - selectW;
      eggs[i][0] = selectS - curW;
      backtracking(eggs, idx + 1, callback);
      eggs[idx][0] = curS;
      eggs[i][0] = selectS;
    }
  } else {
    backtracking(eggs, idx + 1, callback);
  }
  // 현재 계란 내구도가 0보다 큰데 칠 수 있는 계란이 없을 때
  callback(eggs.filter((v) => v[0] <= 0).length);
  return;
};

const solution = (input) => {
  const N = Number(input[0]);
  const eggs = input.slice(1).map((egg) => egg.split(" ").map(Number));

  let max = 0;
  backtracking(eggs, 0, (result) => {
    max = Math.max(max, result);
  });
  console.log(max);
};

solution(input);