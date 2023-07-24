import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        // 낮은 숫자가 우선 순위인 int 형 우선순위 큐 선언
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int answer = 0;
        
        for (int i = 0; i < scoville.length; i++){
            q.add(scoville[i]);
        }
        while (q.peek() < K) {
            if(q.size() >= 2){
                int a = q.poll();
                int b = q.poll();
                int newFood = a + (b*2);
                q.add(newFood);
                answer += 1;
            }
            else{
                answer = -1;
                break;
            }
            
        }
        return answer;
    }
}