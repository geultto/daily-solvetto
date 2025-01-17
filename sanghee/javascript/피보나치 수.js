function solution(n) {
  const f = new Array(n + 1).fill(0);
  f[0] = 0;
  f[1] = 1;

  for (let i = 2; i <= n; i++) {
    f[i] = (f[i - 2] + f[i - 1]) % 1234567;
  }

  return f[n];
}
console.log(solution(10));
