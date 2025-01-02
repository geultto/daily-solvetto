function solution(s) {
  const result = s.split(" ").map((word) => {
    return word.charAt(0).toUpperCase() + word.slice(1).toLowerCase();
  });

  return result.join(" ");
}

console.log(solution("3people unFollowed me"));