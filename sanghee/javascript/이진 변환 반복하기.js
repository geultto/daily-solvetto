function solution(s) {
  let count = 0;
  let deleteZeroCount = 0;

  while (s !== "1") {
    count++;
    withoutZeros = s.replaceAll("0", "");
    deleteZeroCount += s.length - withoutZeros.length;
    s = withoutZeros.length.toString(2);
  }
  return [count, deleteZeroCount];
}
