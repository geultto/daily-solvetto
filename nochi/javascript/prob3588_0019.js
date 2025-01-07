function solution(s) {
    let arr = Array.from(s)
    const stack = [];
    
    arr.forEach((c) => {
        if(stack.length > 0 && stack[stack.length -1] === c) {
            stack.pop();
            return;
        } 
        
        stack.push(c)
    })
    
    return stack.length === 0 ? 1 : 0
}