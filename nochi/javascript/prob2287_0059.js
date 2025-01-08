// friends: 친구들의 이름을 담은 배열
// gifts: 이번 달까지 친구들이 주고받은 선물 기록

function solution(friends, gifts) {
    const giftPoint = (sendCount, receiveCount) => sendCount - receiveCount
    const getSums = (graph, sender, receiver) => graph.get(sender).sends.reduce((sum, v) => {
        return sum + (v === receiver ? 1 : 0)
    }, 0)
    
    const graph = new Map()
    friends.forEach((friend) => graph.set(friend, { sends: [], receives: [], count: 0}))
   
    gifts.forEach((gift) => {
        const [sender, receiver] = gift.split(" ");
        graph.get(sender).sends.push(receiver)
        graph.get(receiver).receives.push(sender)
    })
    
    let nextKing = graph.get(friends[0])
    
    for(let i = 0; i < friends.length; i++) {
        const sender = friends[i]
        const senderInfo = graph.get(sender)
        for(let j = i + 1; j < friends.length; j++) {
            const receiver = friends[j]
            const receiverInfo = graph.get(receiver)
            const senderSendCount = getSums(graph,sender,receiver)
            const receiverSendCount =  getSums(graph,receiver,sender)
            
            if(receiverSendCount === senderSendCount) {
                const senderPoint = giftPoint(senderInfo.sends.length, senderInfo.receives.length)
                const receiverPoint = giftPoint(receiverInfo.sends.length, receiverInfo.receives.length)
                
                if(senderPoint > receiverPoint) ++senderInfo.count;
                if(receiverPoint > senderPoint) ++receiverInfo.count;
            }
            else {
                if(senderSendCount > receiverSendCount) ++senderInfo.count;
                if(receiverSendCount > senderSendCount) ++receiverInfo.count;
            }
            
            if(nextKing.count < graph.get(sender).count) nextKing = senderInfo;
            if(nextKing.count < graph.get(receiver).count) nextKing = receiverInfo;
        }
      
    }
    
    return nextKing.count;
}

// 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
// 서로 선물 준 횟수가 같다면 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.

// 선물지수 = 준 선물 - 받은 선물
// 선물 지수 같으면 선물 X