function solution(s) {
  let answer = 0;
  const calcList = s.split(" ").map((x) => {
    if (isNaN(Number(x))) return x;
    return Number(x);
  });

  for (let i = 0; i < calcList.length; i++) {
    if (calcList[i] === "Z") answer -= calcList[i - 1];
    else answer += calcList[i];
  }

  return answer;
}

console.log(solution("-1 0 -3 Z"));
