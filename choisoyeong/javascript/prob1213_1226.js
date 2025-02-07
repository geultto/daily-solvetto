const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split('\n')
const [aLength, bLength] = input[0].split(" ").map(Number)
const a = input[1].split(" ").map(Number)
const b = input[2].split(" ").map(Number)

for(let i = 0; i < aLength; i++) {
    let success = true
    for (let j = 0; j < bLength; j++) {
        if(i + j >= aLength) {
            success = false
            break
        }
        if(a[i + j] !== b[j]) {
            success = false
            break
        }
    }

    if (success) {
        console.log('Yes')
        return 0
    }
}

console.log("No")