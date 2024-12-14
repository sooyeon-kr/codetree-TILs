#include <iostream>
using namespace std;
#define N 10
int main() {
    // 여기에 코드를 작성해주세요.
    int n, arr[N];

    cin>>n;
    for(int i=0; i<N; ++i)
        cin>>arr[i];

    int sub=2147000000;
    for(int i=1; i<n; ++i){
        sub = min(sub, arr[i] - arr[i-1]);
    }

    cout<<sub;
    return 0;
}