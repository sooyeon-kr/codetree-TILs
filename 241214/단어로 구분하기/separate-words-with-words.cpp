#include <iostream>
#include <string>
#include <sstream>
using namespace std;

int main() {
    // 여기에 코드를 작성해주세요.
    string str;
    getline(cin, str);
    istringstream iss(str);
    string temp;
    while(getline(iss, temp, ' '))
        cout<<temp<<'\n';
    return 0;
}