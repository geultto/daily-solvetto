const fs = require('fs')
const input = Number(fs.readFileSync(0).toString().trim())
const arr = []
function has369(num) {
    const arr = num.toString().split("")
    for (const a of arr) {
        if(a === "3" || a === "6" || a === "9") {
            return true
        }
    }
    
    return false
}
for(let i = 1; i <= input; i++) {
    if((i % 3 === 0) || has369(i)) {
        arr.push(0)
    }  else {
    arr.push(i)
    }
}

console.log(arr.join(" "))