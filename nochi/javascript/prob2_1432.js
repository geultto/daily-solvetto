// 퍼즐의 난이도를 순서대로 담은 1차원 정수 배열 diffs
// 퍼즐의 소요 시간을 순서대로 담은 1차원 정수 배열 times
// 전체 제한 시간 limit

function solution(diffs, times, limit) {
  let left = 0;  // 숙련도의 최소값 (탐색의 하한)
  let right = Math.max(...diffs);  // 숙련도의 최대값 (탐색의 상한)

  // 주어진 숙련도(level)로 모든 퍼즐을 해결하는 데 걸리는 총 시간을 계산하는 함수
  const getTotalTime = (level) => {
      let totalTime = 0;  // 전체 소요 시간 초기화
      for (let i = 0; i < diffs.length; i++) {
          const time_cur = times[i];  // 현재 퍼즐의 기본 소요 시간
          const time_prev = i > 0 ? (times[i] + times[i - 1]) : times[i];  // 이전 퍼즐과의 관계 고려

          // 숙련도가 충분하면 time_cur만 소요, 부족하면 추가 시간 필요
          totalTime += diffs[i] <= level ? time_cur : ((diffs[i] - level) * time_prev) + time_cur;

          // 제한 시간을 초과하는 경우 조기 종료 (불필요한 계산 방지)
          if (totalTime > limit) {
              return totalTime;
          }
      }
      return totalTime;
  }

  // 이진 탐색을 사용하여 숙련도의 최솟값을 찾음
  while (left < right) {
      let mid = Math.floor((left + right) / 2);  // 중간값을 계산하여 탐색 범위 조정

      // 현재 숙련도(mid)로 모든 퍼즐을 해결할 수 있는지 확인
      if (getTotalTime(mid) <= limit) {
          right = mid;  // 가능한 경우, 숙련도를 더 낮출 수 있는지 확인 (범위를 줄임)
      } else {
          left = mid + 1;  // 불가능한 경우, 숙련도를 높여야 함 (범위를 올림)
      }
  }

  return left;  // 최종적으로 숙련도의 최소값 반환
}

// diff ≤ level이면 퍼즐을 틀리지 않고 time_cur만큼의 시간을 사용하여 해결