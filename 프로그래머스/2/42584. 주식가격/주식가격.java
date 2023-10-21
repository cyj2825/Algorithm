import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0; i < len; i++){
            // 스택이 비어있지 않고 현재 값을 스택에 존재하는 가장 마지막 값과 비교하였을 때 작을 경우 가격이 떨어진 상황
            while(!s.isEmpty() && prices[i] < prices[s.peek()]) {
                answer[s.peek()] = i - s.peek();
                // 해당 인덱스에 대한 답은 구했으므로 pop
                s.pop();
            }
            // 스택이 비어있거나 주식이 떨어지지 않은 경우 push
            s.push(i);
        }
        
        // 값을 구하지 못한 인덱스는 마지막까지 떨어지지 않은 것
        while(!s.isEmpty()) {
            answer[s.peek()] = len - s.peek() - 1;
            s.pop();
        }
        return answer;
    }
}