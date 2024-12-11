let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

let arr = input[1].split(' ').map(Number);
let uniqueArr = Array.from(new Set(arr)).sort((a, b) => a - b);

let map = new Map();
for (let i = 0; i < uniqueArr.length; i++) {
  map.set(uniqueArr[i], i);
}

const answer = arr.map(num => map.get(num))

console.log(answer.join(' '))