// name: 그리워하는 사람의 이름을 담은 문자열 배열 
// yearning: 각 사람별 그리움 점수를 담은 정수 배열 
// photo: 각 사진에 찍힌 인물의 이름을 담은 이차원 문자열 배열 

function solution(name, yearning, photo) {
    const map = new Map();
    name.forEach((n, y) => map.set(n, yearning[y]));

    const answer = [];
    
    photo.forEach((p, i) => {
        let sum = 0
        p.forEach((n) => {
            if(map.has(n)) sum += map.get(n); 
        })
        answer.push(sum)
    })
    
    return answer;
}



// 사진 속에 나오는 인물의 그리움 점수를 모두 합산한 값이 해당 사진의 추억 점수가 됩니다.