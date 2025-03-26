let fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split("\n");

let a = input[0];
let b = input[1];

if (a > 0 && b > 0) {
    console.log(1);
} 
else if (a < 0 && b > 0) {
    console.log(2);
}
else if (a < 0 && b < 0) {
    console.log(3);
}
else if (a > 0 && b < 0) {
    console.log(4);
}