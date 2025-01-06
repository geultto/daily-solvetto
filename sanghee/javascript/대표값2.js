const numbers = require("fs")
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

function getAverage(numbers) {
  const sum = numbers.reduce((acc, cur) => acc + cur, 0);
  return sum / numbers.length;
}

function getMedian(numbers) {
  numbers.sort((a, b) => a - b);
  return numbers[Math.floor(numbers.length / 2)];
}

console.log(getAverage(numbers));
console.log(getMedian(numbers));
