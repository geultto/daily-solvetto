function solution(s) {
  const arr = s.split(" ").map(Number);

  return `${Math.min(...arr)} ${Math.max(...arr)}`;
}

console.log(solution("1 2 3 4"));
