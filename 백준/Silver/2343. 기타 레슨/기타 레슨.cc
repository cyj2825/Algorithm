#include<iostream>
#include<algorithm>
using namespace std;

const int MAX = 100001;
int N, M;
int lecture[MAX];

int main() {
	// 강의의 수 N, 블루레이의 개수 M
	cin >> N >> M;
	int start = 0;
	int end = 0;
	for (int i = 0; i < N; i++) {
		cin >> lecture[i];
		start = max(start, lecture[i]);
		end += lecture[i];
	}

	while (start <= end) {
		int mid = (start + end) / 2;
		int count = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (sum + lecture[i] > mid) {
				count++;
				sum = 0;
			}
			sum += lecture[i];
		}
		if (sum != 0) count++;
		if (count > M) start = mid + 1;
		else end = mid - 1;
	}
	cout << start;
	return 0;
}