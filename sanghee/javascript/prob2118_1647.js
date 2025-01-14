function solution(s) {
  let count = 0;
  const brackets = s.split("");

  for (let i = 0; i < s.length; i++) {
    if (isBracket(brackets)) count++;
    brackets.push(brackets.shift()); // 괄호 회전
  }
  return count;
}

function isBracket(brackets) {
  const stack = [];
  let isRight = true;

  for (let j = 0; j < brackets.length; j++) {
    if (brackets[j] === "(" || brackets[j] === "{" || brackets[j] === "[") {
      stack.push(brackets[j]);
      continue;
    }
    if (brackets[j] === ")" && stack.at(-1) === "(") {
      stack.pop();
      continue;
    }
    if (brackets[j] === "}" && stack.at(-1) === "{") {
      stack.pop();
      continue;
    }
    if (brackets[j] === "]" && stack.at(-1) === "[") {
      stack.pop();
      continue;
    }
    isRight = false;
    break;
  }
  if (stack.length === 0 && isRight) return true;
}

console.log(solution("[](){}"));