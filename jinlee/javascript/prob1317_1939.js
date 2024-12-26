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

const isTree = (graph, visited, start) => {
  const stack = [[start, -1]];

  while (stack.length) {
    const [cur, parent] = stack.pop();

    for (let node of graph[cur]) {
      if (visited[node] && node !== parent) return false;

      if (!visited[node]) {
        stack.push([node, cur]);
        visited[node] = true;
      }
    }
  }
  return true;
};

const solution = (input) => {
  let lineIdx = 0;
  let tc = 1;
  const answer = [];
  while (lineIdx < input.length) {
    const [n, m] = input[lineIdx].split(" ").map(Number);
    lineIdx++;

    const graph = Array.from({ length: n + 1 }, () => []);
    for (let j = 0; j < m; j++) {
      const [node1, node2] = input[lineIdx].split(" ").map(Number);
      graph[node1].push(node2);
      graph[node2].push(node1);
      lineIdx++;
    }

    const visited = Array(n + 1).fill(false);
    let cnt = 0;
    for (let k = 1; k <= n; k++) {
      if (!visited[k]) {
        visited[k] = true;
        // 사이클을 어떻게 찾지..?
        if (isTree(graph, visited, k)) cnt++;
      }
    }
    if (cnt > 1) {
      answer.push(`Case ${tc}: A forest of ${cnt} trees.`);
    } else if (cnt === 1) {
      answer.push(`Case ${tc}: There is one tree.`);
    } else {
      answer.push(`Case ${tc}: No trees.`);
    }
    tc++;
  }
  console.log(answer.join("\n"));
};

input.pop();
solution(input);