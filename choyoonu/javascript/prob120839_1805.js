function solution(rsp) {
    var answer = '';
    const winMap = { '2': '0', '0': '5', '5': '2' };
    answer = rsp.split('').map((v)=> winMap[v]).join('');
    return answer;
}