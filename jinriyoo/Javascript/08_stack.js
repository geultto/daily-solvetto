// 열린 괄호, 닫힌 괄호가 마구 뒤섞인 문자열이 주어졌을때, 소괄호가 정상으로 열고 닫혔는지 판별하는 함수 작성
// ex. (())() true
// ex. ((())() false

function solution(string) {
  const stack = [];

  for (const s of string) {
    if (s === "(") {
      stack.push(s);
    } else if (s === ")") {
      if (stack.length === 0) {
        return false;
      } else {
        stack.pop();
      }
    }
  }

  return stack.length === 0; // stack 길이가 0 => 짝이 잘맞는다!
}