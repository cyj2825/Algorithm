#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int N, M;
vector<int> datas;
int getData[8];

void combination(int cnt) {
	if (cnt == M) {
		for (int i = 0; i < M; i++) {
			printf("%d ", getData[i]);
		}
		printf("\n");
		return;
	}

	for (int i = 0; i < N; i++) {
		getData[cnt] = datas[i];
		combination(cnt + 1);
	}
}

int main() {
	cin >> N >> M;
	int a;
	for (int i = 0; i < N; i++) {
		cin >> a;
		datas.push_back(a);
	}
	sort(datas.begin(), datas.end());
	combination(0);
}