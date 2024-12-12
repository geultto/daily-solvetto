// 프로그래머스 https://school.programmers.co.kr/learn/courses/30/lessons/42578

// 처음 풀었던 코드 (wrong)
// 왜 틀렸나? 해당 종류의 옷을 착용하지 않는 경우도 있으므로 +1을 해주어야했음.
function wrongSolution(clothes) {
  var answer = 1;
  const closet = {};
  for (const [name, kind] of clothes) {
    if (closet[kind]) {
      closet[kind].push(name);
    } else {
      closet[kind] = [name];
    }
  }

  for (const v of Object.values(closet)) {
    answer *= v.length;
  }
  return answer;
}

// 수정한 코드
// 각 종류에서 선택 가능한 경우의 수
// headgear: ["hat1", "hat2"] → 3가지 경우 (아무것도 안 입음 포함해서)
// eyewear: ["sunglasses"] → 2가지 경우 (아무것도 안 입음 포함해서)
// 전체 경우의 수 = 3 * 2
// 문제에서는 적어도 하나의 옷을 입어야 한다고 했기 때문에, 아무것도 입지 않는 경우 1가지를 빼준다.
function solution1(clothes) {
  var answer = 1;
  const closet = {};
  for (const [name, kind] of clothes) {
    if (closet[kind]) {
      closet[kind].push(name);
    } else {
      closet[kind] = [name];
    }
  }

  for (const v of Object.values(closet)) {
    answer *= v.length + 1;
  }
  return answer - 1;
}

// 개선한 코드
function solution2(clothes) {
  // for문대신 reduce패턴을 사용해본다.
  const closet = clothes.reduce((acc, [_, kind]) => {
    // 매번 v.length를 계산하는 것은 효율적이지 못하다고 생각해, closet에 item을 넣을 때 아이템의 이름 대신 개수를 넣는다
    // 이름은 중요하지 않기 때문에
    acc[kind] = (acc[kind] || 0) + 1;
    return acc;
  }, {});

  for (const v of Object.values(closet)) {
    answer *= v + 1;
  }

  // 위 코드처럼 answer를 선언하지 않아도 되어 관리비용을 줄일 수 있다.
  // 단점: 가독성?
  return (
    Object.values(closet).reduce((acc, count) => {
      return acc * (count + 1);
    }, 1) - 1
  );
}
