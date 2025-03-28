let fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split(" ");

let h = Number(input[0]);
let m = Number(input[1]);

if (m >= 45) {
    console.log(h, m - 45);
} 

else {
    if (h > 0) {
        console.log(h - 1, m + 60 - 45);
    } else {
        console.log(23, m + 60 - 45);
    }
}