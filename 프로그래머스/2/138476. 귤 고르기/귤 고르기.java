import java.io.*;
import java.util.*;

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0) + 1); 
        }
        
        // 개수 기준으로 정렬
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, new myComparator());
        
        // 정렬된 key 리스트에서 값을 하나씩 가져와 k에서 빼줌
        for(Integer kl : keyList) {
            if(k <= 0) break;
            answer++;
            // 주어진 수의 개수만큼 k에서 빼기
            k -= map.get(kl);
        }
        return answer;
    }
    
    public class myComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return map.get(o2).compareTo(map.get(o1));
        }
    }
}