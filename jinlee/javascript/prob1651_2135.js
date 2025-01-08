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

let [H, M] = input.split(" ").map(Number);

if (M < 45) {
  if (H === 0) {
    H = 23;
  } else {
    H = H - 1;
  }
  M = M + 60 - 45;
} else {
  M -= 45;
}

console.log(`${H} ${M}`);