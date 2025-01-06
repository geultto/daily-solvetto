// Q. 10진수를 2진수로 변환하기
// - decimal은 1이상 10억 미만의 자연수
/* ex.
    10 -> 1010
    27 -> 11011
    12345 -> 11000000111001
*/

function solution(decimal) {
  const stack = [];

  while (decimal > 0) {
    const remainder = decimal % 2;
    stack.push(remainder);
    decimal = Math.floor(decimal / 2);
  }

  let binary = "";
  while (stack.length > 0) {
    binary += stack.pop();
  }
  return binary;
}
