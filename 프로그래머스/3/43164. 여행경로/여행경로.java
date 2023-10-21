import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<String> routes;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        // 모든 경우의 수를 구한 다음 Collections.sort()로 정렬하기 위해 리스트 생성
        routes = new ArrayList<>();

        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(routes);
        answer = routes.get(0).split(" ");
        return answer;
    }
    
    public void dfs(int cnt, String start, String route, String[][] t){
        if(cnt == t.length){
            routes.add(route);
            return;
        }
        
        for(int i = 0; i < t.length; i++){
            if(start.equals(t[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(cnt+1, t[i][1], route + " " + t[i][1], t);
                visited[i] = false;
            }
        }
    }
}