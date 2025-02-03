const fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split("\n")
const n = Number(input[0])
const numbers = input[1].split(" ").map(Number)
const countArr = Array(10).fill(0);

for(let i = 0; i < n; i++) {
    countArr[numbers[i]]++;
}

for(let i = 1; i <= 9; i++) {
    console.log(countArr[i]);
}