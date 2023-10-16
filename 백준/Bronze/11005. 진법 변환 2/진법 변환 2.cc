#include <iostream>
#include <algorithm>
#include <list>
using namespace std;

int N, B;

int main() {
	cin >> N >> B;
	
	string answer;
	while (N > 0) {
		// N % B가 9이하라면
		if (N % B < 10) answer += N % B + '0';
		else answer += N % B - 10 + 'A';
		N /= B;
	}

	reverse(answer.begin(), answer.end());
	cout << answer << endl;
	return 0;
}