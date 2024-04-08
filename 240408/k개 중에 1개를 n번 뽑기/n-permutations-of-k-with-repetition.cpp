#include <iostream>
#include <vector>

using namespace std;
int n, m;
vector<int> selected;
void perm(int cnt);
void printPerm(){
    for(int& e:selected){
        cout << e << " ";
    }
    cout << '\n';
}
int main() {
    // 여기에 코드를 작성해주세요.
    cin >> n >> m;
    
    perm(0);
    return 0;
}
void perm(int cnt){
    if(cnt == m){
        printPerm();
        return;
    }
    for(int i=1; i<=n; ++i){
        selected.push_back(i);
        perm(cnt + 1);
        selected.pop_back();
    }
}