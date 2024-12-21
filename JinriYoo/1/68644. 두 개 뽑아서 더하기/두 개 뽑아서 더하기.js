function solution(numbers) {
    // 1. 배열에서 두 수를 선택하는 모든 경우의 수 구하기
    // 2. 과정1에서 구한 수를 새로운 배열에 저장하고, 중복값 제거
    // 3. 배열을 오름차순으로 정렬하고 반환
    
    let answer = [];
    
    for (let i = 0; i < numbers.length; i++) {
        for (let j = 0; j < i; j++) {
            answer.push(numbers[i] + numbers[j]);
        }
    }
    
    return [...new Set(answer)].sort((a, b) => a - b);
}