#include <iostream>
#include <string>
using namespace std;

int main() {
    // 여기에 코드를 작성해주세요.
    string target, cur;
    cin>>target>>cur;
    
    int ans = 0;
    for(int i=0; i<target.length()-cur.length()+1; ++i){
        if(target.substr(i, cur.length()) == cur){
            ans++;
        }
    }

    cout<<ans;
    return 0;
}