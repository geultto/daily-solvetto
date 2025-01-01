function solution(numbers) {
    var answer = 0;
    let desc = [];
    // 내림차순 정렬
    desc = numbers.sort((a,b)=> b-a);
    // 인덱스 0,1 값 대입
    const firstNumber = numbers[0];
    const lastNumber = numbers[1];
    answer= firstNumber * lastNumber;
    return answer;
}

// 정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.