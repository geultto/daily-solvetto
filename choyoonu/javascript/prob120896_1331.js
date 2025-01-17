function solution(s) {
    // 등장 횟수 계산
    const counts = s.split("").reduce((acc,v) => {
        acc[v]= (acc[v] || 0 ) + 1;
        return acc;
    }, {});
    // ex:  {"a":3,"b":2,"c":3,"d":1}
    // 등장 횟수가 1인 문자만 필터링 후 정렬 및 문자열 반환
    return Object.keys(counts)
        .filter(v => counts[v] === 1)
        .sort()
        .join("");
}

// 문자열 s가 매개변수로 주어집니다. s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요. 한 번만 등장하는 문자가 없을 경우 빈 문자열을 return 합니다.