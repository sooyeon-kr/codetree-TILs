#include <iostream>
using namespace std;
#define N 1000
int main() {
    // 여기에 코드를 작성해주세요.
    // std::sync_with_stdio(0);
    int n, arr[N];
    int idx=n, mV=0;
    cin>>n;
    
    for(int i=0; i<n; ++i){
        cin>>arr[i];
        if(mV<arr[i]){
            idx = i;
            mV=arr[i];
        }
    }
    cout<<idx+1<<' ';
    
    while(idx!=0){
        int m = idx;
        mV = 0;
        for(int i=0; i<m; ++i){
            if(mV<arr[i]){
                idx = i;
                mV=arr[i];
            }
        }
        cout<<idx+1<<' ';
    }

    return 0;
}