#include <iostream>
using namespace std;
#define N 10
int main() {
    // 여기에 코드를 작성해주세요.
    int n;
    int arr[N][N];

    cin >> n;
    int num = 1;
    for(int x=0; x<n; ++x){
        for(int y=0; y<n; ++y){
            arr[y][x] = num++;
        }
    }

    for(int x=0; x<n; ++x){
        for(int y=0; y<n; ++y){
            cout << arr[x][y] << ' ';
        }
        cout<<'\n';
    }

    return 0;
}