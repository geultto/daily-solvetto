// solution 1
const fs = require('fs')
const [length, arr] = fs.readFileSync(0).toString().split('\n')
const numbers = arr.split(" ").map(Number)
let n = Number(length)
const result = Array(n + 1).fill(0)
const resultIndices = []

for(let i = 1; i < n + 1; i++) {
    result[i] = numbers[i - 1]
}

for(let i = 1; i < n + 1; i++) {
    let currentMax = -1
    let currentMaxIndex = 0

    for(let j = 1; j < n + 1; j++) {
        if(result[j] > currentMax) {
            currentMax = result[j]
            currentMaxIndex = j
        }
    }

    resultIndices.push(currentMaxIndex)
    n = currentMaxIndex - 1
    i = 1

    if(n === 1) {
        resultIndices.push(1)
        break
    }
}

console.log(resultIndices.join(" "))

// solution 2
const fs = require('fs');
const input = fs.readFileSync(0).toString().split('\n');
const n = parseInt(input[0]);
const a = input[1].split(' ').map(Number);
const indices = [];

// 첫 번째 원소는 항상 답
indices.push(0);

// 바로 직전에 답으로 추가한 원소보다 현재 원소가 더 큰 경우에만 답으로 추가
for (let i = 1; i < n; i++) {
    const lastIdx = indices[indices.length - 1];
    if (a[i] > a[lastIdx]) {
        indices.push(i);
    }
}

for (let i = indices.length - 1; i >= 0; i--) {
    process.stdout.write((indices[i] + 1) + ' ');
}