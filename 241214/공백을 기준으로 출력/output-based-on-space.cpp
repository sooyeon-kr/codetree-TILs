#include <iostream>
#include <string>
#include <sstream>
using namespace std;

int main() {
    // 여기에 코드를 작성해주세요.
    string str;
    while(getline(cin, str)){
        istringstream iss(str);
        string tmp;

        while(getline(iss, tmp, ' ')){
            cout << tmp;
        }
    }
    return 0;
}