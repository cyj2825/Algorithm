import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) throws IOException{
        int[] answer = new int[2];
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st = null;
        
        for(String s : operations){
            st = new StringTokenizer(s, " ");
            String c = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            if(minPQ.size() < 1 && c.equals("D")) continue;
            
            if(c.equals("I")) {
                minPQ.offer(x);
                maxPQ.offer(x);
            }
            if(c.equals("D")) {
                if(x == -1) {
                    int a = minPQ.poll();
                    maxPQ.remove(a);
                }
                else if(x == 1){
                    int a = maxPQ.poll();
                    minPQ.remove(a);
                }
            }
        }
        if(minPQ.size() > 0) {
            answer[0] = maxPQ.poll();
            answer[1] = minPQ.poll();
        }
        return answer;
    }
}