import java.util.*;

class Solution {
    boolean[] visited;
    int mainl, l, tmp, answer = Integer.MAX_VALUE;
    String b, t;
    String[] w;
    
    public int solution(String begin, String target, String[] words) {
        boolean isExit = Arrays.stream(words).anyMatch(target::equals);
        if(!isExit) return 0;
        
        b = begin;
        t = target;
        w = words;
        l = begin.length();
        mainl = words.length;
        
        for(int i = 0; i < mainl; i++){
            int cnt = 0;
            tmp = 0;
            visited = new boolean[mainl];
            for(int j = 0; j < l; j++){
                if(b.charAt(j) != words[i].charAt(j)) cnt++;
            }
            if(cnt == 1) dfs(words[i], i, 1);
        }
        return answer;
    }
    
    public void dfs(String x, int idx, int tmp) {
        visited[idx] = true;
        
        if(x.equals(t)) {
            answer = Math.min(answer, tmp);
            return;
        }
        
        for(int i = 0; i < mainl; i++){
            int cnt = 0;
            for(int j = 0; j < l; j++){
                if(x.charAt(j) != w[i].charAt(j)) cnt++;
            }
            if(cnt == 1 && !visited[i]) {
                dfs(w[i], i, tmp+1);
                visited[i] = false;
            }
        }
    }
}