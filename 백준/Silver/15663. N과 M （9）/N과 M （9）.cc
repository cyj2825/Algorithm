#include <iostream>
#include <algorithm>
using namespace std;

int N, M;
int datas[8], pick[8];
bool check[8] = { false }; // 중복확인을 위해

void dfs(int cnt) {
	if (cnt == M) {
		for (int i = 0; i < M; i++) {
			printf("%d ", pick[i]);
		}
		printf("\n");
		return;
	}

	int c = 0;
	for (int i = 0; i < N; i++) {
		if (!check[i] && datas[i] != c) {
			pick[cnt] = datas[i];
			// 직전에 넣은 값과 동일한 값인지 확인하기 위해
			c = datas[i];
			check[i] = true;
			dfs(cnt + 1);
			check[i] = false;
		}
	}
}

int main() {
	cin >> N >> M;
	int x = 0;
	for (int i = 0; i < N; i++) {
		cin >> datas[i];
	}
	sort(datas, datas+N);

	dfs(0);
}