function solution(N, stages) {
    let stageLength = stages.length;
    let stageList = new Array(N).fill(0)
    stages.forEach((stage) => {
        if(stage > N) return;
        stageList[stage - 1] += 1;
    })
    
    
    const answer = stageList
        .map((count, i) => {
            const rate = count / stageLength
            stageLength -= count
            return [rate, i + 1]
        })
        .sort((a, b) => b[0] - a[0])
        .map(([_, stage]) => stage)
    
    return answer;
}

// 실패율
// 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수

// N: 전체 스테이지의 개수
// stages: 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열