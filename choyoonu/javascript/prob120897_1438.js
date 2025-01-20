function solution(n) {
    var answer = [];
    for(let i=1; i<=n; i+=1){
        if(n % i == 0 ) {
            answer.push(i);
        }
    }
    return answer;
}

// 정수 n이 매개변수로 주어질 때, n의 약수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.