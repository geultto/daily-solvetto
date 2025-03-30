let fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split("\n");
let [A, B] = input[0].split(" ").map(Number); // 현재 시각 (시, 분)
let C = Number(input[1]);

// 총 분 계산
let totalMinutes = B + C; // 현재 분과 요리 시간 을 더함
let addHours = Math.floor(totalMinutes / 60); // 60분을 초과한 부분을 시간으로 변환
let remainMinutes = totalMinutes % 60; // 나머지 분 계산

// 최종 시간 계산
let finalHour = (A + addHours) % 24; // 현재 시에 추가된 시간을 더하고 24로 나눈 나머지

// 결과 출력
console.log(finalHour, remainMinutes);