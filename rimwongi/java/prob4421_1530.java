/**
코드를 해독하려면 모든 숫자를 바꿔야 합니다. 모든 숫자가 동시에 대체됩니다.
k > 0인 경우 i번째 숫자를 다음 k 숫자의 합으로 바꿉니다.
k < 0인 경우 i번째 숫자를 이전 k 숫자의 합으로 바꿉니다.
k == 0이면 i번째 숫자를 0으로 바꿉니다.
코드가 원형이므로 code[n-1]의 다음 요소는 code[0]이고 code[0]의 이전 요소는 code[n-1].
원형 배열 코드와 정수 키 k가 주어지면, 폭탄을 해체하기 위해 해독된 코드를 반환하세요!

슈도 코드
hint -> mod 연산
 */

class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if(k==0) {
            Arrays.fill(result, 0);
            return result;
        }

        for(int i=0; i<n; i++) {
            int sum = 0;

            if(k>0) {
                for(int j=1; j<=k; j++) {
                    sum += code[(i+j) % n];
                }
            } else {
                for(int j = 1; j<= -k; j++) {
                    sum += code[(i-j+n)%n];
                }
            }
            result[i] = sum;
        }
        return result;
    }
}