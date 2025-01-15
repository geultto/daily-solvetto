function solution(n) {
  let lagerNum = n + 1;
  let nBinOneCount = n.toString(2).match(/1/g).length;

  while (lagerNum <= 1_000_000) {
    if (lagerNum.toString(2).match(/1/g).length === nBinOneCount) {
      return lagerNum;
    }
    lagerNum += 1;
  }
}

console.log(solution(15));
