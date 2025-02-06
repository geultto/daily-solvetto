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

const solution = (input) => {
  const N = Number(input[0]);
  const arr = input[1].split(" ").map(Number);
  const stack = [];
  const orderArr = [];

  // let idx = 1;
  // while (arr.length) {
  //   const cur = arr.shift();
  //   if (cur !== idx) stack.push(cur);
  //   else {
  //     orderArr.push(cur);
  //     idx++;
  //   }
  // }
  // while (stack.length) {
  //   const cur = stack.pop();
  //   if (cur !== idx) {
  //     console.log("Sad");
  //     return;
  //   }
  //   idx++;
  // }
  let order = 1;
  while (arr.length) {
    if (arr[0] === order) {
      orderArr.push(arr.shift());
      order++;
    } else {
      if (stack[stack.length - 1] === order) {
        orderArr.push(stack.pop());
        order++;
      } else {
        stack.push(arr.shift());
      }
    }
  }
  while (stack.length) {
    const cur = stack.pop();
    if (cur !== order) {
      console.log("Sad");
      return;
    }
    order++;
  }
  console.log("Nice");
};

solution(input);