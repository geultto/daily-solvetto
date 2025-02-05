const fs = require('fs')
const n = Number(fs.readFileSync(0).toString().trim())
let str = "";

// solution1
for (let i = 0; i < n * 2; i++) {
    str = "";
    if (i % 2 === 0) {
        for (let j = 0; j < (i + 1) / 2; j++) {
            str += "* ";
        }
    }
    else {
        for (let j = 0; j < n - ((i - 1) / 2) ; j++) {
            str += "* ";
        }
    }

    console.log(str);
}

// solution2
for (let i = 1; i <= n; i++) {
    let firstPattern = "";
    for (let j = 0; j < i; j++) {
      firstPattern += "* ";
    }
    console.log(firstPattern);

    let secondPattern = "";
    for (let k = 0; k < n - i + 1; k++) {
      secondPattern += "* ";
    }
    console.log(secondPattern);
}