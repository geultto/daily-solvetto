const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split("\n")
const countArr = Array(4).fill(0)

input.forEach((item) => {
    const [symptoms, temperature] = item.split(" ")
    if(symptoms === "Y") {
        if(Number(temperature) >= 37) {
            countArr[0]++
        } else {
            countArr[2]++
        }
    } else {
        if(Number(temperature) >= 37) {
            countArr[1]++
        } else {
            countArr[3]++
        }
    }   
})
let result = countArr.join(" ")
if(countArr[0] >= 2) {
    result += " E"
}

console.log(result)