#include <iostream>
using namespace std;
#define N 100
#define M 100
int main() {
    int n, m;
    int arr[N][M] = {};
    int num = 0;

    cin >> n >> m;

    for(int x=0; x<m; ++x){
        if(x%2==0){
            for(int y=0; y<n; ++y){
                arr[y][x] = num++;
            }
        }else{
            for(int y=n-1; y>=0; --y){
                arr[y][x] = num++;
            }
        }
    }

    for(int y=0; y<n; ++y){
        for(int x=0; x<m; ++x){
            cout << arr[y][x] << ' ';
        }
        cout<<'\n';
    }

    return 0;
}