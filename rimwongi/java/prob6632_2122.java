import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        Stack<Integer> delivery = new Stack<>();
        Stack<Integer> pickUp = new Stack<>();
        long answer = 0;
        
        // 택배와 수거 정보를 스택에 담는다.
        for(int i=0; i<n; i++) {
            delivery.push(deliveries[i]);
            pickUp.push(pickups[i]);
        }
        
        // 둘 중 스택이 빌 때까지 배달과 수거를 진행
        while(!delivery.isEmpty() || !pickUp.isEmpty()) {
            
            // 끝이 0일 경우 계산할 필요 없어 stack에서 pop
            while (!delivery.isEmpty() && delivery.peek() == 0) {
                delivery.pop();
            }
            
            while (!pickUp.isEmpty() && pickUp.peek() == 0) {
                pickUp.pop();
            }
            
            answer += 2*Math.max(delivery.size(), pickUp.size());
            
            int dTarget = 0;
            while (!delivery.isEmpty()){
                int dCurrent = delivery.pop();
                
                if (dTarget + dCurrent <= cap) {
                    // 배달이 가능한 경우
                    dTarget += dCurrent;
                } else {
                    // 배달이 불가능한 경우에 남은 배달 양을 스택에 넣는다.
                    delivery.push(dTarget + dCurrent - cap);
                    break;
                }
            }
            
            // 택배 수거도 동일하게 진행
            int pTarget = 0;
            while (!pickUp.isEmpty()) {
                int pCurrent = pickUp.pop();
                
                if (pTarget + pCurrent <= cap){
                    pTarget += pCurrent;
                } else {
                    pickUp.push(pTarget + pCurrent - cap);
                    break;
                }
            }
        }
        return answer;
    }
}