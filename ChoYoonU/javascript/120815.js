/* 프로그래머스 120814.피자 나눠 먹기(2)(https://school.programmers.co.kr/learn/courses/30/lessons/120815) */

function solution(n) {
	let pizzaPiece = 6;
	var answer = 1;
	while ((answer * pizzaPiece) % n !== 0) {
		answer++;
	}
	return answer;
}

