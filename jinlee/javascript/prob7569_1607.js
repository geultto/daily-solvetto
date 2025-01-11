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

const recursive = (start, end, str) => {
  const n = (end - start) / 3;
  if (end - start === 1) return;
  for (let i = start + n; i < start + n * 2; i++) {
    str[i] = " ";
  }

  recursive(start, start + n, str);
  recursive(start + n * 2, end, str);
};

const answer = input.map((v) => {
  const n = Number(v);
  if (n === 0) return "-";
  else {
    const strArr = Array(Math.pow(3, n)).fill("-");
    recursive(0, Math.pow(3, n), strArr);
    return strArr.join("");
  }
});
console.log(answer.join("\n"));