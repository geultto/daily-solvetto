function solution(my_string) {
    var answer = 0;
    // return answer;
    return [...my_string]
        .filter(char => !isNaN(char)) // 숫자인 문자만 필터링
        .reduce((a,c)=> a + Number(c), 0) // 숫자로 변환
        
}

// 문자열 my_string이 매개변수로 주어집니다. my_string안의 모든 자연수들의 합을 return하도록 solution 함수를 완성해주세요.