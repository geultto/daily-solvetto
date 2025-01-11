// players: 선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 
// callings: 해설진이 부른 이름을 담은 문자열 배열

function solution(players, callings) {
    const map = new Map();

    players.forEach((player, index) => map.set(player, index));

    callings.forEach((calling) => {
        const currentIndex = map.get(calling); 
        const prevIndex = currentIndex - 1; 

        const prevPlayer = players[prevIndex];
        [players[prevIndex], players[currentIndex]] = [players[currentIndex], players[prevIndex]];

        map.set(calling, prevIndex);
        map.set(prevPlayer, currentIndex);
    });

    return players;
}

// 해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다. 
// -  "soe"선수를 불렀다면 2등인 "soe" 선수가 1등인 "mumu" 선수를 추월했다는 것