#include <iostream>
#include <stdio.h>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
using namespace std;
// 컴퓨터의 수
int computer_num;
// 네트워크상 직접 연결되어있는 쌍의 수
int connect;
vector <int> v[101];
// 방문여부 체크 리스트 (컴퓨터의 수가 100이하이므로 101로 초기화)
bool visited[101];

int BFS(int start) {
	int count = -1;
	// BFS 사용하기 위해 큐 선언
	queue<int> q;
	q.push(start);

	// q가 빌 때까지 계속 반복
	while (!q.empty()) {
		// q의 맨 앞의 값 x에 반환
		int x = q.front();
		// q의 맨 앞의 값 삭제
		q.pop();

		// v[x]의 크기만큼 for문을 돌면서 방문하지 않았던 노드값 방문
		for (int i = 0; i < v[x].size(); i++) {
			if (!visited[v[x][i]]) {
				visited[v[x][i]] = true;
				// 연결되어 있는 값 모두 찾기 위해
				q.push(v[x][i]);
				count++;
			}
		}
	}
	return count;
}

int main() {
	int answer = 0;
	// 연결되어 있는 쌍의 인접행렬 나타내기
	int m1;
	int m2;
	// 컴퓨터의 수 입력받기
	cin >> computer_num;
	// 네트워크상 직접 연결되어있는 쌍의 수 입력받기
	cin >> connect;
	// 쌍의 상태값 넣기
	for (int i = 0; i < connect; i++) {
		cin >> m1;
		cin >> m2;
		// 양방향 연결상태
		v[m1].push_back(m2);
		v[m2].push_back(m1);
	}
	answer = BFS(1);
	printf("%d", answer);
	return 0;
}