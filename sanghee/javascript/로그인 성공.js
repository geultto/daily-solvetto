function solution([id, pw], db) {
  let answer = "fail";
  const database = new Map(db);

  if (database.has(id)) {
    answer = database.get(id) === pw ? "login" : "wrong pw";
  }

  return answer;
}

console.log(
  solution(
    ["meosseugi", "1234"],
    [
      ["rardss", "123"],
      ["yyoom", "1234"],
      ["meosseugi", "1234"],
    ]
  )
);
