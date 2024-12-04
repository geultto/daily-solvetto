/* 프로그래머스 120816.피자 나눠 먹기(3)(https://school.programmers.co.kr/learn/courses/30/lessons/120816) */

function solution(slice, n) {
	var answer = 0;
	let count = 1;
	if (n % slice !== 0) {
		answer = Math.ceil(n / slice);
		return answer;
	}
	answer = n / slice;
	return answer;
}

