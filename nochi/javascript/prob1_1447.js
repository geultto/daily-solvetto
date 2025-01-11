// bandage : [기술의 시전 시간, 1초당 회복량, 추가 회복량] 1차원 정수 배열
// health : 최대 체력을 의미하는 정수
// attacks : 몬스터의 공격 시간과 피해량을 담은 2차원 정수 배열
// - attacks[i]는 [공격 시간, 피해량] 

function solution(bandage, health, attacks) {
    const maxHealth = health;
    const lastAttack = attacks[attacks.length - 1]
    const firstAttack = attacks[0]
    
    for(let i = 0; i < attacks.length; i++) {
        const [time, demage] = attacks[i]
        console.log("현재 체력:", health)
        health -= demage;
        console.log("demage", demage, health)
        // 몬스터의 공격을 받고 캐릭터의 체력이 0 이하가 되어 죽는다면
        if(health <= 0) return -1;
        // 모든 공격이 끝난 직후 남은 체력을 return
        if(i === attacks.length -1) return health
        
        
        // 붕대감기 시전
        const [nextTime, nextDemage] = attacks[i + 1]
        const spacingTime = nextTime - time - 1
        const successth = Math.floor(spacingTime / bandage[0])
        if(successth === 0) {
            health += bandage[1] * spacingTime 
            console.log("붕대감기 실패", spacingTime, bandage[0], bandage[1] * spacingTime, health)
        } else {
            health += (bandage[1] * spacingTime) + (bandage[2] * successth)
            console.log("붕대감기 성공", spacingTime, bandage[0], (bandage[1] * spacingTime) + (bandage[2] * successth), health)
        }
            
        if(health > maxHealth) {
            health = maxHealth
        }
    }
}

// - t초 동안 붕대를 감으면서 1초마다 x만큼의 체력을 회복
// - t초 연속으로 붕대를 감는 데 성공한다면 y만큼의 체력을 추가로 회복
// - 게임 캐릭터에는 최대 체력이 존재 => 현재 체력이 최대 체력보다 커지는 것은 불가능

// - 기술을 쓰는 도중 몬스터에게 공격을 당하면 기술이 취소
// - 공격을 당하는 순간에는 체력을 회복할 수 없음
// 몬스터에게 공격당해 기술이 취소당하거나 기술이 끝나면 그 즉시 붕대 감기를 다시 사용하며, 
// 연속 성공 시간이 0으로 초기화

// h = 30 - 10 = 20
// st = 9 - 2 = 7