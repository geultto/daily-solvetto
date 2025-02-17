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

const rOperation = (matrix) => {
  const R = matrix.length;

  const newMatrix = [];
  for (let r = 0; r < R; r++) {
    const temp = [];
    const max = Math.max(...matrix[r]);
    for (let num = 1; num <= max; num++) {
      const cnt = matrix[r].filter((el) => el === num).length;
      if (cnt <= 0) continue;
      temp.push([num, cnt]);
    }
    temp.sort((a, b) => a[1] - b[1]);
    const newRow = [];
    for (let c = 0; c < temp.length; c++) {
      newRow.push(...temp[c]);
    }
    newMatrix.push(newRow);
  }
  const maxLength = Math.max(...newMatrix.map((row) => row.length));
  for (let row of newMatrix) {
    if (row.length < maxLength) {
      row.push(...Array(maxLength - row.length).fill(0));
    }
  }
  return newMatrix;
};

const cOperation = (matrix) => {
  const newMatrix = [];
  const C = matrix[0].length;
  for (let c = 0; c < C; c++) {
    const column = [];
    for (let r = 0; r < matrix.length; r++) {
      column.push(matrix[r][c]);
    }
    const max = Math.max(...column);
    const temp = [];
    for (let num = 1; num <= max; num++) {
      const cnt = column.filter((el) => el === num).length;
      if (cnt <= 0) continue;
      temp.push([num, cnt]);
    }
    const newRow = [];
    temp.sort((a, b) => a[1] - b[1]).forEach((v) => newRow.push(...v));
    newMatrix.push(newRow);
  }
  const maxLength = Math.max(...newMatrix.map((row) => row.length));
  for (let row of newMatrix) {
    if (row.length < maxLength) {
      row.push(...Array(maxLength - row.length).fill(0));
    }
  }
  const transposed = [];
  for (let c = 0; c < newMatrix[0].length; c++) {
    const column = [];
    for (let r = 0; r < newMatrix.length; r++) {
      column.push(newMatrix[r][c]);
    }
    transposed.push(column);
  }
  return transposed;
};

const solution = (input) => {
  const [r, c, k] = input[0].split(" ").map(Number);
  let matrix = input.slice(1).map((row) => row.split(" ").map(Number));

  let cnt = 0;
  while (cnt <= 100) {
    if (
      matrix.length >= r - 1 &&
      matrix[0].length >= c - 1 &&
      matrix[r - 1][c - 1] === k
    ) {
      console.log(cnt);
      return;
    }

    if (matrix.length >= matrix[0].length) {
      matrix = rOperation(matrix);
    } else {
      matrix = cOperation(matrix);
    }
    cnt++;
  }
  console.log(-1);
};

solution(input);