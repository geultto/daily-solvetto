function solution(nums) {
  let answer = 0;
  const L = nums.length;

  for (let i = 0; i < L; i++) {
    for (let j = i + 1; j < L; j++) {
      for (let k = j + 1; k < L; k++) {
        const sum = nums[i] + nums[j] + nums[k];
        answer += isDecimal(sum);
      }
    }
  }

  return answer;
}

function isDecimal(sum) {
  for (let n = 2; n < sum; n++) {
    if (sum % n === 0) return 0;
    if (n === sum - 1) return 1;
  }
}
