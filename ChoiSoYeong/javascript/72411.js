// 프로그래머스 https://school.programmers.co.kr/learn/courses/30/lessons/72411
const getCombinations1 = function (arr, selectNumber) {
  const results = [];
  if (selectNumber === 1) return arr.map((el) => [el]);
  // n개중에서 1개 선택할 때(nC1), 바로 모든 배열의 원소 return

  arr.forEach((fixed, index, origin) => {
    const rest = origin.slice(index + 1);
    // 해당하는 fixed를 제외한 나머지 뒤
    const combinations = getCombinations1(rest, selectNumber - 1);
    // 나머지에 대해서 조합을 구한다.
    const attached = combinations.map((el) => [fixed, ...el]);
    //  돌아온 조합에 떼 놓은(fixed) 값 붙이기
    results.push(...attached);
    // 배열 spread syntax 로 모두다 push
  });

  return results; // 결과 담긴 results return
};

function solution1(orders, course) {
  var answer = [];
  //단품메뉴들의 갯수가 담긴 배열 course를 돌면서 코스별 조합을 추출한다.
  //코스별 조합들이 담긴 배열을 다시 순회하며, 조합이 몇번 주문되었는지 카운트한다.
  //가장 많이 주문된 구성이 1번 이상 주문된 경우 정답 배열에 추가한다.

  for (let c of course) {
    const menus = [];
    for (let order of orders) {
      // ["A", "B"]와 ["B", "A"]같은 중복 조합을 미리 제거. 요거 안해줬음!
      const orderArr = order.split("").sort();
      const comb = getCombinations1(orderArr, c);
      menus.push(...comb);
    }

    const count = {};
    for (let menu of menus) {
      const key = menu.join("");
      count[key] = (count[key] || 0) + 1;
    }

    const max = Math.max(...Object.values(count));
    if (max > 1) {
      for (let [key, value] of Object.entries(count)) {
        if (value === max) {
          answer.push(key);
        }
      }
    }
  }

  return answer.sort();
}

// 개선한 코드
const getCombinations2 = (arr, selectNumber) =>
  // 1. 삼항연산자를 사용해본다.
  // 2. result를 선언하지 않아도 된다 -> 분리선언하는데서 생기는 관리비용이 줄어든다.
  selectNumber === 1
    ? arr.map((el) => [el])
    : arr.flatMap((fixed, index, origin) =>
        getCombinations2(origin.slice(index + 1), selectNumber - 1).map(
          (el) => [fixed, ...el]
        )
      );

function solution2(orders, course) {
  var answer = [];

  for (let c of course) {
    // 1. flatMap을 사용하여 간결하게 처리한다.
    // 2. 굳이 선언하지 않아도 될 경우는 선언하지 말자. (이전의 orderArr)
    const menus = orders.flatMap((order) =>
      getCombinations2(order.split("").sort(), c)
    );

    const count = {};
    for (let menu of menus) {
      const key = menu.join("");
      count[key] = (count[key] || 0) + 1;
    }

    const max = Math.max(...Object.values(count));
    if (max > 1) {
      for (let [key, value] of Object.entries(count)) {
        if (value === max) {
          answer.push(key);
        }
      }
    }
  }

  return answer.sort();
}
