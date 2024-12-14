#include <iostream>
using namespace std;
#define MN 1000

int main() {
    int n, nums[MN];

    cin>>n;
    for(int i=0; i<n; ++i)
        cin >> nums[i];
    
    int max = -1;
    for(int i=0; i<n; ++i){
        int cur = nums[i];
        if(max < cur){
            int cnt = 0;
            for(int j=0; j<n; ++j){
                if(nums[j] == cur){
                    cnt++;
                }
            }
            if(cnt == 1) max = cur;
        }
    }

    cout<<max;
    return 0;
}