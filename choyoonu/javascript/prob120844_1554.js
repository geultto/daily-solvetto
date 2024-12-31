function solution(numbers, direction) {
    var answer = [];
    if (direction == "left") {   
        answer =  numbers.slice(1).concat(numbers[0]);
    } 
    else if (direction == "right") {  
        answer = [numbers[numbers.length -1]].concat(numbers.slice(0, -1));
    }
    return answer;
}