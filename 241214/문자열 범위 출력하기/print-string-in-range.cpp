#include <iostream>
#include <string>
using namespace std;

int main() {
    // 여기에 코드를 작성해주세요.
    // std::sync_with_stdio(0);
    // cin.tie(0);

    string str;
    getline(cin, str);

    for(int i=2; i<10; ++i){
        cout<<str[i];
    }
    
    return 0;
}