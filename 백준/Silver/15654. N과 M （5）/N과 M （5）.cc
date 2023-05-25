#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
const int MAX = 8;
int n, m;
int arr[MAX];
vector<int> v;
bool visited[MAX];

void dfs(int idx) {
	if (idx == m) {
		for (int i = 0; i < m; i++) {
			cout << arr[i] << " ";
		}
		cout << "\n";
		return;
	}
	for (int i = 0; i < v.size(); i++) {
		if (visited[i]) {
			continue;
		}
		visited[i] = true;
		arr[idx] = v[i];
		dfs(idx + 1);
		visited[i] = false;
	}
}
int main() {
	cin >> n >> m;
	v.resize(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}
	sort(v.begin(), v.end());
	dfs(0);
	return 0;
}