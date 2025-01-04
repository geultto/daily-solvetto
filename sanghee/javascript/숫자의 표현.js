function solution(n) {
  let count = 0;
  let left = 1;
  let right = 0;
  let sum = 0;

  while (right <= n) {
    if (sum < n) {
      right += 1;
      sum += right;
    } else if (sum > n) {
      sum -= left;
      left += 1;
    } else if (sum === n) {
      count++;
      sum -= left;
      left += 1;
    }
  }

  return count;
}

console.log(solution(15));
