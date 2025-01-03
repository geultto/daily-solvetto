function solution(brown, yellow) {
  for (let i = 1; i <= yellow; i++) {
    if (yellow % i === 0 && brown === (yellow / i + i + 2) * 2)
      return [yellow / i + 2, i + 2];
  }
}

console.log(solution(10, 2));