function solution(numbers) {
    const answer = [] 
    const numbers2 = [...numbers]
    
    numbers.forEach((v1) => {
        numbers2.shift()
        numbers2.forEach((v2) => {
            answer.push(v1 + v2)             
        })
    })
    
    return [...new Set(answer)].sort((a,b) => a - b)
}

// 테스트 1 〉	통과 (0.06ms, 33.4MB)
// 테스트 2 〉	통과 (0.14ms, 33.5MB)
// 테스트 3 〉	통과 (0.07ms, 33.5MB)
// 테스트 4 〉	통과 (0.15ms, 33.4MB)
// 테스트 5 〉	통과 (0.17ms, 33.4MB)
// 테스트 6 〉	통과 (0.19ms, 33.6MB)
// 테스트 7 〉	통과 (0.55ms, 33.6MB)
// 테스트 8 〉	통과 (0.59ms, 33.7MB)
// 테스트 9 〉	통과 (0.46ms, 33.7MB)


function solution(numbers) {
    const answer = [] 
   
    for (let i = 0; i < numbers.length ; i++) {
        for(let j = 0; j < i; j++) {
            answer.push(numbers[i] + numbers[j])
        }
    }
    
    return [...new Set(answer)].sort((a,b) => a - b)
}

// 테스트 1 〉	통과 (0.05ms, 33.5MB)
// 테스트 2 〉	통과 (0.06ms, 33.5MB)
// 테스트 3 〉	통과 (0.08ms, 33.4MB)
// 테스트 4 〉	통과 (0.06ms, 33.4MB)
// 테스트 5 〉	통과 (0.15ms, 33.4MB)
// 테스트 6 〉	통과 (0.19ms, 33.5MB)
// 테스트 7 〉	통과 (0.54ms, 33.8MB)
// 테스트 8 〉	통과 (0.50ms, 33.7MB)
// 테스트 9 〉	통과 (0.45ms, 33.6MB)