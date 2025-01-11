function solution(array, n) {
    var answer = array[0];
    let minDiff = Math.abs(array[0] - n);
    for(let i = 1; i < array.length; i++) {
        const diff = Math.abs(array[i] - n);
        if(diff < minDiff || (diff == minDiff && array[i] < answer)) {
            minDiff = diff;
            answer = array[i];
        }
    }
    return answer;
}