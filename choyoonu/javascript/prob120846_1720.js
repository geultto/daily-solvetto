function solution(n) {
    var answer = 0;
    const counts = Array.from({length: n + 1},()=> 0);

    for(let i=1;i<=n; i++) {
        for(let j=i;j<=n;j+=i){
            counts[j]++; // i = j의 약수
        }
    }         
        
    // 합성수의 개수 반환 
    answer = counts.filter(count => count >= 3).length;
    
    return answer;
}