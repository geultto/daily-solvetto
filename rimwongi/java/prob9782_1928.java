class Solution {
    /** pseudo code
        - comb
            - 조합이 완성된 경우 계산
            - 시작 지점이 감정 표현 배열의 길이와 같아진 경우, 계산 메서드를 호출하고 반환
            - 10부터 40까지 10씩 증가하면서 감정 표현 배열을 채움
        - 최대 판매 수와 최대 수익을 결과 배열에 저장
        - 결과 배열을 반환
    - 판매 수와 현재 수익에 대해
        - 할인율과 가격을 가져옴
        - 현재 사용자에 대한 감정 표현별 수익을 합산
        - 현재 사용자에 대한 수익이 가격을 초과하는 경우 판매 수를 증가
        - 아닌 경우 현재 수익을 누적
        - 최대 판매 수와 최대 수익을 갱신
            - 판매 수가 더 크면 sales과 earning을 갱신
            - 판매 수가 같은 경우 수익이 더 크면 earn을 갱신
    **/
    static int sales = 0;
    static int earning = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2]; 
        int[] arr = new int[emoticons.length];
        comb(arr, 0, users, emoticons);
        answer[0] = sales;
        answer[1] = earning;
        return answer;
    }

    public void comb(int[] arr, int start, int[][] users, int[] emoticons) {
        // 조합이 완성된 경우 계산
        if (start == arr.length) {
            calculate(arr, users, emoticons);
            return;
        }

        // 10~40까지 10씩 증가하면서 조합
        for (int i = 10; i <= 40; i += 10) {
            arr[start] = i;
            comb(arr, start + 1, users, emoticons);
        }
    }

    public void calculate(int[] arr, int[][] users, int[] emoticons) {
        int count = 0; // 판매 수
        int currentEarning = 0; // 현재 수익

        for (int[] user : users) {
            int discount = user[0]; // 할인율
            int price = user[1]; // 가격
            int sum = 0; // 현재 사용자에 대한 수익 합산

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= discount) {
                    sum += (emoticons[i] / 100) * (100 - arr[i]);
                }
            }

            // 수익이 가격을 초과하는 경우 판매 수 증가
            if (sum >= price) {
                count++;
            } else {
                // 아닌 경우 현재 수익 누적
                currentEarning += sum; 
            }
        }

        // 최대 판매 수, 최대 수익 업데이트
        if (count > sales) {
            sales = count;
            earning = currentEarning;
            return;
        } else if (count == sales) {
            if (earning < currentEarning) {
                earning = currentEarning;
            }
        }
    }
}