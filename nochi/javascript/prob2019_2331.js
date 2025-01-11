// 게임 화면은 "1 x 1" 크기의 칸들로 이루어진 "N x N" 크기의 정사각 격자

// board: 게임 화면의 격자의 상태가 담긴 2차원 배열 
// moves: 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 
// 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return 하도록

function solution(board, moves) {
    const rows =  board.length;
    const newBoard = []
    const cart = []
    
    Array(rows).fill(0).forEach((row) => newBoard.push([]))
    let count = 0
    
       board.forEach((row) => {
        row.forEach((cell, i) => {
            if (cell === 0) return;
            newBoard[i].unshift(cell); 
        });
    });
    
    moves.forEach((move) => {
        const item = newBoard[move - 1]?.pop();
        if (!item) return; 

        if (cart.length !== 0 && cart[cart.length - 1] === item) {
            cart.pop();
            count += 2; 
        } else {
            cart.push(item); 
        }
    })
    
    
    return count;
}

// 게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다
// 집어 올린 인형은 바구니에 쌓이게 되는 데, 이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다. 

// 만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게 됩니다.

// 크레인 작동 시 인형이 집어지지 않는 경우는 없으나 만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다.