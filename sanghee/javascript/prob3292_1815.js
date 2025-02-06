function solution(priorities, location) {
  const queue = priorities.map((priority, index) => ({ priority, index }));
  let printOrder = 0;

  while (queue.length > 0) {
    const current = queue.shift();
    if (queue.some((doc) => doc.priority > current.priority)) {
      queue.push(current);
    } else {
      printOrder++;
      if (current.index === location) {
        return printOrder;
      }
    }
  }
}

console.log(solution([2, 1, 3, 2], 2));