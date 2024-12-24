function solution(phone_book) {
  let hash = new Map();

  phone_book.forEach((phone) => {
    hash.set(phone, true);
  });

  for (let phone of phone_book) {
    for (let i = 1; i < phone.length; i++) {
      let prefix = phone.substring(0, i); // 접두어 추출
      if (hash.has(prefix)) return false; // 접두어가 존재하면 false 반환
    }
  }

  return true; // 접두어 관계가 없으면 true 반환
}

console.log(solution(["119", "97674223", "1195524421"]));