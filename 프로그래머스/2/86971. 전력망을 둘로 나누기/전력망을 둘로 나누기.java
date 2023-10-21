import java.util.*;

class Solution {
    ArrayList<Integer>[] list;
    boolean[] visited;
    int cnt = 0;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        // 초기화
        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            list[a].add(b);
            list[b].add(a);
        }
        
        for(int[] wire : wires) {
            list[wire[0]].remove(Integer.valueOf(wire[1]));
            list[wire[1]].remove(Integer.valueOf(wire[0]));
            cnt = 0;
            visited = new boolean[n+1];
            dfs(wire[0]);
            int x = cnt;
            
            cnt = 0;
            visited = new boolean[n+1];
            dfs(wire[1]);
            int y = cnt;
            answer = Math.min(answer, Math.abs(x-y));
            list[wire[1]].add(wire[0]);
            list[wire[0]].add(wire[1]);
        }
        return answer;
    }
    
    public void dfs(int cur) {
        visited[cur] = true;
        
        for(int i = 0, end = list[cur].size(); i < end; i++) {
            int ad = list[cur].get(i);
            if(!visited[ad]) {
                cnt++;
                dfs(ad);
            }
        }
    }
}