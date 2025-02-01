const fs = require('fs')
const input = Number(fs.readFileSync(0).toString().trim());

let str = "";

for (let i = 0; i < input; i++) {
    str = ""
    for(let j = 0; j <= i; j++) {
        str += "* "
    }
    console.log(str)
}

for (let i = 0; i < input - 1; i++) {
    str = ""
    for(let j = 0; j < input - i - 1; j++) {
        str += "* "
    }
    console.log(str)
}