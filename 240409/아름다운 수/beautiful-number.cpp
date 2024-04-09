#include <iostream>
#include <string>
#include <vector>
#define MN = 5;

int n;
int ans = 0;
vector<int> selected;
void perm(int cnt){
    if(cnt == n){
        isBeautifulNum();
        return;
    }

    for(int i=1; i<=4; ++i){
        selected.push_back(i);
        perm(cnt + 1);
        selected.pop_back();
    }
    cout<<ans;
}
void isBeautifulNum(){
    int arr = new int[5];
    int prev = -1, idx = -1;
    for(int i=0; i<(int)selected.size(); ++i){
        int cur = selected[i];
        if(prev == -1 || prev+1 == cur){
            ++arr[i];
        }else{
            arr[i] = 1;
        }
    }

    for(int i=0; i<arr.length; ++i){
        int cur = arr[i];
        if(cur >= i+1) ++ans;
    }

}
int main() {
    // 여기에 코드를 작성해주
    cin >> n;
    perm(0);

   
    return 0;
}

/*
string str;
int[] sum = new int[MN];
cin >> str;
 int idx = 0;
    int prev = -1;
    for(int i=0; i<str.length; ++i){
        idx = (int)str[i];
        if(prev == -1 || prev == idx){
            ++sum[idx];
        }else{
            sum[idx]+=1;
        }
        prev = idx;
    }
    
    int ans = 0;
    for(int i=0; i<str.length; ++i){
        if(sum[i] >= i+1){
            ++ans;
        }
    }

*/