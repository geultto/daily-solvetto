const fs = require('fs')
const input = Number(fs.readFileSync(0).toString().trim());
let str = "";
for (let i = 0; i < input; i++) {       
    str = "";
    for (let j = input - i; j > 0; j--) {    
        for (let k = input - i; k > 0; k--) {
            str += "*"
        }
        str += " "
    }
    console.log(str);
}