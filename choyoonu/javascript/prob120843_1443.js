function solution(numbers, k) {
    var answer = 0;
    answer = (1 + (k - 1) * 2) % numbers.length
    return answer == 0 ? numbers.length : answer;
}