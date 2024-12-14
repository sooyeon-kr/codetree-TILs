#include <iostream>
using namespace std;
#define N 10
#define M 10
void input(int arr[][M], int n, int m){
    for(int y=0; y<n; ++y){
        for(int x=0; x<m; ++x){
            cin>>arr[y][x];
        }
    }
}
int main() {
    // 여기에 코드를 작성해주세요.
    int pre[N][M]={}, after[N][M]={}, ans[N][M] = {};
    int n, m;

    cin >> n >> m;

    // for(int y=0; y<n; ++y){
    //     for(int x=0; x<m; ++x){
    //         cin>>pre[y][x];
    //     }
    // }

    // for(int y=0; y<n; ++y){
    //     for(int x=0; x<m; ++x){
    //         cin>>after[y][x];
    //     }
    // }
    input(pre, n, m);
    input(after, n, m);
    for(int y=0; y<n; ++y){
        for(int x=0; x<m; ++x){
            if(pre[y][x] != after[y][x]){
                ans[y][x] = 1;
            }
        }
    }
    
    for(int y=0; y<n; ++y){
        for(int x=0; x<m; ++x){
            cout<<ans[y][x]<<' ';
        }
        cout<<'\n';
    }
    
    return 0;
}

