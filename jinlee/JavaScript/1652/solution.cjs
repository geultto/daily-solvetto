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

const countHorizontal = (graph) => {
  let horizontal = 0;
  for (let i = 0; i < graph.length; i++) {
    for (let j = 0; j < graph[0].length; j++) {
      let cnt = 0;
      while (graph[i][j] !== "X" && j < graph[0].length) {
        cnt++;
        j++;
      }
      if (cnt > 1) {
        horizontal++;
      }
    }
  }
  return horizontal;
};

const countVertical = (graph) => {
  let vertical = 0;
  for (let i = 0; i < graph[0].length; i++) {
    for (let j = 0; j < graph.length; j++) {
      let cnt = 0;
      while (j < graph.length && graph[j][i] === ".") {
        cnt++;
        j++;
      }
      if (cnt > 1) {
        vertical++;
      }
    }
  }
  return vertical;
};

const solution = (input) => {
  const N = Number(input[0]);
  const graph = [];
  for (let i = 1; i <= N; i++) {
    graph.push(input[i].split(""));
  }
  console.log(`${countHorizontal(graph)} ${countVertical(graph)}`);
};

solution(input);
