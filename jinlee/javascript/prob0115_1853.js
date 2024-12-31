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

const dfs = (tree, start) => {
  const visited = Array(tree.length).fill(false);
  const stack = [start];

  let cnt = 0;
  while (stack.length) {
    const cur = stack.pop();

    for (let node of tree[cur]) {
      if (!visited[node]) {
        visited[node] = true;
        stack.push(node);
        if (tree[node].length === 0) cnt++;
      }
    }
  }
  return cnt;
};

const solution = (input) => {
  const n = Number(input[0]);
  const arr = input[1].split(" ").map(Number);

  const tree = Array.from({ length: n }, () => []);

  const root = arr.findIndex((v) => v === -1);

  const node = Number(input[2]);
  if (node === root) {
    console.log(0);
    return;
  }

  arr[node] = -1;

  for (let i = 0; i < arr.length; i++) {
    if (arr[i] !== -1) {
      tree[arr[i]].push(i);
    }
  }

  if (tree[root].length === 0) {
    console.log(1);
    return;
  }

  const answer = dfs(tree, root);
  console.log(answer);
};

solution(input);