function solution(id_pw, db) { 
    // 아이디가 존재하지만 비밀번호가 틀린 경우
    if (db.some(([id]) => id === id_pw[0]) && !db.some(([id, pw]) => id === id_pw[0] && pw === id_pw[1])) {
        return "wrong pw";
    }
    
    // 아이디와 비밀번호가 모두 일치하는 경우
    if (db.some(([id, pw]) => id === id_pw[0] && pw === id_pw[1])) {
        return "login";
    }
    
    // 아이디가 존재하지 않는 경우
    return "fail";
}


// 머쓱이는 프로그래머스에 로그인하려고 합니다. 머쓱이가 입력한 아이디와 패스워드가 담긴 배열 id_pw와 회원들의 정보가 담긴 2차원 배열 db가 주어질 때, 다음과 같이 로그인 성공, 실패에 따른 메시지를 return하도록 solution 함수를 완성해주세요.