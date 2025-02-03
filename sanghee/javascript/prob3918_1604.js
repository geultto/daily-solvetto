function stringToAscii(s) {
  return s.split("").map((char) => char.charCodeAt());
}

function moveByIndex(char, index, skipAscii) {
  let count = 0;

  while (count < index) {
    if (char++ === 122) char = 97;
    if (!skipAscii.includes(char)) count++;
  }
  return String.fromCharCode(char);
}

function solution(s, skip, index) {
  let answer = "";

  const sAscii = stringToAscii(s);
  const skipAscii = stringToAscii(skip);

  sAscii.forEach((char) => {
    answer += moveByIndex(char, index, skipAscii);
  });

  return answer;
}

console.log(solution("aukks", "wbqd", 5));