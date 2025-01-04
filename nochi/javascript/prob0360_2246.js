function solution(dirs) {
    const savedLocations = [[[0,0], [0,0]]]
    
    const move = (str, arr) => {
        switch(str) {
            case "U":
                return logic(up(arr), arr);
            case "D":
                return logic(down(arr), arr);
            case "R":
                return logic(right(arr), arr);
            case "L":
                return logic(left(arr), arr);
        }
    }

    const logic = (newArr, arr) => {
        return check(newArr) && savedLocations.push([arr, newArr])
    }

    const up = (arr) => {
        return [arr[0], arr[1] + 1]
    }

    const down = (arr) => {
        return [arr[0], arr[1] - 1]
    }

    const right = (arr) => {
        return [arr[0] + 1, arr[1]]
    }

    const left = (arr) => {
        return [arr[0] - 1, arr[1]]        
    }

    const check = (arr) => !(arr[0] > 5 || arr[0] < -5 || arr[1] > 5 || arr[1] < -5)

    Array.from(dirs).forEach((v) => {
        move(v, savedLocations[savedLocations.length - 1][1])
    })

    const filteredLocations = [...new Set(savedLocations)]
    const setLo = new Set()
    
    savedLocations.forEach((v) => {
        setLo.add(JSON.stringify(v))
        setLo.add(JSON.stringify(v.reverse()))
    })
    
    return (setLo.size - 1) / 2
}



// U: 위쪽으로 한 칸 가기
// D: 아래쪽으로 한 칸 가기
// R: 오른쪽으로 한 칸 가기
// L: 왼쪽으로 한 칸 가기

// 경계는 
// - 왼쪽 위(-5, 5) 
// - 왼쪽 아래(-5, -5)
// - 오른쪽 위(5, 5)
// - 오른쪽 아래(5, -5)