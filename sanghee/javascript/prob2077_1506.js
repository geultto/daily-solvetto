function solution(clothes) {
  const clothesMap = new Map();

  // Map에 의상 종류별로 개수를 저장
  for (const [value, key] of clothes) {
    clothesMap.set(key, (clothesMap.get(key) || 0) + 1);
  }

  // 모든 경우의 수 계산
  let totalCombinations = 1;
  clothesMap.forEach((count) => {
    totalCombinations *= count + 1; // 착용하지 않는 경우 포함
  });

  // 아무것도 입지 않는 경우 제외
  return totalCombinations - 1;
}

console.log(
  solution([
    ["yellow_hat", "headgear"],
    ["blue_sunglasses", "eyewear"],
    ["green_turban", "headgear"],
  ])
);