function solution(n) {
    var answer = 0;
    let factorial = 1;
    for(let i =1 ; i <=n ; i++) {
        factorial *= i; // i!을 구함
        if(factorial > n) { //factorail이 n을 초과하면 
            answer =  i - 1; 
            break;
        } else {
            answer = i;
        }
    }
    
    return answer;
}

// i팩토리얼 (i!)은 1부터 i까지 정수의 곱을 의미합니다. 예를들어 5! = 5 * 4 * 3 * 2 * 1 = 120 입니다. 정수 n이 주어질 때 다음 조건을 만족하는 가장 큰 정수 i를 return 하도록 solution 함수를 완성해주세요.