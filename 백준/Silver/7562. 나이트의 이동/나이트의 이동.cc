#include <iostream>
#include <queue>
#include <string.h>
using namespace std;
# define MAX 300

int T, n;
int sx, sy, ex, ey;
int visit[MAX][MAX];
// 나이트가 한 번에 이동할 수 있는 좌표
int dx[] = {1, 1, -1, -1, 2, 2, -2, -2};
int dy[] = {2, -2, 2, -2, 1, -1, 1, -1};

void BFS(int sx, int sy, int ex, int ey) {
	// queue에 x, y 좌표값을 넣기 위해 pair 사용
	queue<pair<int, int>> q;
	// {x, y}으로 push해야 함!
	q.push({sx, sy});
	visit[sx][sy] = 1;

	while (!q.empty()){
		// 하나하나 값을 가져와야 함
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < n && visit[nx][ny] == 0) {
				visit[nx][ny] = visit[x][y] + 1;
				q.push({ nx, ny });
			}
		}
	}
}
int main() {
	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> n;
		cin >> sx >> sy;
		cin >> ex >> ey;
		BFS(sx, sy, ex, ey);
		cout << visit[ex][ey] - 1 << "\n";
		memset(visit, 0, sizeof(visit));
	}
	return 0;
}