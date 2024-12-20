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
  const n = Number(input);
  const dp = Array(n + 1).fill("");
  dp[1] = "SK";
  dp[2] = "CY";
  dp[3] = "SK";
  dp[4] = "SK";

  for (let i = 5; i <= n; i++) {
    if (dp[i - 1] === "SK" && dp[i - 3] === "SK" && dp[i - 4] === "SK") {
      dp[i] = "CY";
    } else {
      dp[i] = "SK";
    }
  }
  console.log(dp[n]);
};

solution(input);