const fs = require('fs')
const [length, arr] = fs.readFileSync(0).toString().split('\n')
const a = arr.split(" ").map(Number)
let max1 = a[0]
let max1Index = 0
for(let i = 1; i < length; i++) {
    if(a[i] > max1) {
        max1 = a[i]
        max1Index = i
    }
}

let max2;
for (let i = 0; i < length; i++) {
  if (i === max1Index) {
    continue;
  }

  if (max2 === undefined || a[i] > max2) {
    max2 = a[i];
  }
  
}

console.log(max1, max2)