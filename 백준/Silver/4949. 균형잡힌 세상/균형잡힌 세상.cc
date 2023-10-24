#include <iostream>
#include <algorithm>
#include <string.h>
#include <string>
#include <stack>
using namespace std;

string s;

int main() {
	while (true) {
		getline(cin, s);

		if (s == ".") break;

		stack<char> st;
		bool check = { false };

		for (int i = 0; i < s.size(); i++) {
			if (s[i] == '(' || s[i] == '[') {
				st.push(s[i]);
			}
			if (s[i] == ')') {
				if (st.empty()) {
					printf("%s\n", "no");
					check = true;
					break;
				}
				char c = st.top();
				st.pop();
				if (c == '(') continue;
				else {
					printf("%s\n", "no");
					check = true;
					break;
				}
			}
			if (s[i] == ']') {
				if (st.empty()) {
					printf("%s\n", "no");
					check = true;
					break;
				}
				char c = st.top();
				st.pop();
				if (c == '[') continue;
				else {
					printf("%s\n", "no");
					check = true;
					break;
				}
			}
		}
		if (!st.empty() && !check) {
			printf("%s\n", "no");
			continue;
		}
		if(!check) printf("%s\n", "yes");
	}
}