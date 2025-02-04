const fs = require("fs");
let [a, b] = fs.readFileSync(0).toString().trim().split(" ").map(Number);
const countArr = Array(10).fill(0);

while(a > 1) {
    countArr[a % b]++ 
    a = Math.floor(a / b)
}

console.log(countArr.reduce((acc, cur) => acc += Math.pow(cur,2), 0))