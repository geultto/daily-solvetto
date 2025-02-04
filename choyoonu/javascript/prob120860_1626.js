function solution(dots) {
   
    // x 좌표와  y좌표를 분리
    const xCoords = dots.map(dot => dot[0]);
    const yCoords = dots.map(dot => dot[1]);
    
    // 각각의 가로 세로의 최댓값에서 최솟값 빼기
    const width = Math.max(...xCoords) - Math.min(...xCoords); 
    const height = Math.max(...yCoords) - Math.min(...yCoords);
    return width * height ;
}

// 2차원 좌표 평면에 변이 축과 평행한 직사각형이 있습니다. 직사각형 네 꼭짓점의 좌표 [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]가 담겨있는 배열 dots가 매개변수로 주어질 때, 직사각형의 넓이를 return 하도록 solution 함수를 완성해보세요.