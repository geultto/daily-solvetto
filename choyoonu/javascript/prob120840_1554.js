function solution(balls, share) {
    var answer = 0;
    function factorial(n){
        if(n == 0 || n == 1) return BigInt(1);
        return BigInt(n) * factorial(n - 1 ); // BigInt로 팩토리얼 계산
    }
    // n! / (n-m)! * m!
    answer = factorial(balls) / (factorial(balls - share) * factorial(share));
    return Number(answer); // BigInt를 Number로 변환
}

/* 효율적인 코드
function solution(balls, share) {
    let answer = 1;
    for (let i = 0; i < share; i++) {
        answer *= (balls - i); // 분자를 순차적으로 곱합니다.
        answer /= (i + 1); // 동시에 분모를 나눕니다.
    }
    return Math.round(answer);
} 
예제: balls = 5, share = 3

1. n! = 5!= 5×4×3×2×1=120
2. (n - m)! = (5-3)! = 2!= 2×1=2
3. m! = 3! = 3×2×1=6
결과 120 / (2*6) = 10


*/