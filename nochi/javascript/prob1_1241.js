// video_len : 동영상의 길이를 나타내는 문자열
// pos : 기능이 수행되기 직전의 재생위치를 나타내는 문자열
// op_start : 오프닝 시작 시각을 나타내는 문자열
// op_end : 오프닝이 끝나는 시각을 나타내는 문자열
// commands : 사용자의 입력을 나타내는 1차원 문자열 배열

// return "mm:ss"

function solution(video_len, pos, op_start, op_end, commands) {
    if(!commands || commands.length === 0) return tiemToSec(pos)
    
    const videoSec = tiemToSec(video_len);
    const opStartSec = tiemToSec(op_start)
    const opEndSec = tiemToSec(op_end)
    const posSec = op(tiemToSec(pos))
    
    function op(curTime) {
        if(opStartSec <= curTime && curTime <= opEndSec) return opEndSec
        return curTime
    }
    
    function execCommond(curTime, command) {
        switch(command) {
            case "prev":
                if (curTime < 10) return 0
                return curTime - 10
            case "next":
                if (videoSec - curTime < 10) return videoSec
                return curTime + 10
            default:
                return curTime
        }
    
    }
    const endNum = commands.reduce((curTime, command) => {
        const newSec = execCommond(curTime, command)
        return op(newSec)
    }, posSec)
    
    
    return secToTime(endNum);
}

function tiemToSec (time) {
    const [min, sec] = time.split(":");
    return +min * 60 + +sec 
}

function secToTime (curTime) {
    const min = Math.floor(curTime / 60);
    const sec = curTime % 60;
    
    return `${`${min}`.padStart(2, "0")}:${`${sec}`.padStart(2, "0")}`
}







// 영상의 처음 위치는 0분 0초
// 영상의 마지막 위치는 동영상의 길이

// 10초 전으로 이동 : 사용자가 "prev" 명령을 입력할 경우
// - 현재 위치에서 10초 전으로 이동
// - 현재 위치가 10초 미만인 경우 영상의 처음 위치로 이동

// 10초 후로 이동 : 사용자가 "next" 명령을 입력할 경우
// - 현재 위치에서 10초 후로 이동
// - 남은 시간이 10초 미만일 경우 영상의 마지막 위치로 이동


// 오프닝 건너뛰기
// op_start ≤ 현재 재생 위치 ≤ op_end
// time = op_end