const fs = require('fs')
const n = Number(fs.readFileSync(0).toString().trim())

let str = "";

for (let i = 0; i < n; i++) {
    str = "";
    for (let j = 0; j < i; j++) {
        str += "  ";
    }
    for (let j = 2 * (n - i) - 1; j > 0 ; j--) {
        str += "* ";
    }
    console.log(str);
}