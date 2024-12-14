#include <iostream>
using namespace std;
#define N 1000
const int M=1000;
int main() {
    // 여기에 코드를 작성해주세요.
    int profit = 0;
    int n, arr[N];

    cin>>n;
    for(int i=0; i<n; ++i)
        cin>>arr[i];

    for(int i=0; i<n; ++i){
        for(int j=i+1; j<n; ++j){
            profit = max(profit, arr[j] - arr[i]);
        }
    }
    cout<<profit;
    return 0;
}