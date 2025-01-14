function solution(n) {
  let answer = 0;

  while (n !== 0) {
    if (Number.isInteger(n / 2)) {
      n /= 2;
    } else {
      n -= 1;
      answer += 1;
    }
  }

  return answer;
}

console.log(solution(6));
