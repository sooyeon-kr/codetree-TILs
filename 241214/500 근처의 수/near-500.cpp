#include <iostream>
using namespace std;
#define N 10

int main() {
    // 여기에 코드를 작성해주세요.
    int arr[N];
    int maxCandi=-2147000000;
    int minCandi=2147000000;
    
    int temp;
    for(int i=0; i<N; ++i){
        cin>>temp;
        if(temp<500){
            maxCandi = max(maxCandi, temp);
        }else if(temp>500){
            minCandi = min(minCandi, temp);
        }
    }
    cout<<maxCandi<<' '<<minCandi;
    return 0;
}