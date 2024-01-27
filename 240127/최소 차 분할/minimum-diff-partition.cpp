#include<bits/stdc++.h>

#define endl '\n'
#define X first
#define Y second
using namespace std;

int dp[105][2];
int arr[105];
int sum;
int n;

int main(int argc, char** argv)
{
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  cin >> n;

  for(int i=1; i<=n; ++i){
    cin >> arr[i];
    sum += arr[i];
  }
  
  sort(arr+1, arr+n+1, greater<>());

  dp[0][0] = sum;
  dp[0][1] = sum;

  for(int i=1; i<= n; ++i){
    
    int tmp = 987654321;
    int sgin = 1;
    for(int j=0; j<i; ++j){
      if(abs(tmp) > abs(dp[j][0] - (2 * arr[i]))){
        tmp = dp[j][0] - (2 * arr[i]);
        if(tmp >0) sgin = 1;
        else sgin = -1;
      }
      if(abs(tmp) > abs(dp[j][1] - (2 * arr[i]))){
        tmp = dp[j][1] - (2 * arr[i]);
        if(tmp >0) sgin = 1;
        else sgin = -1;
      }
    }

    dp[i][0] = tmp;
    if(abs(dp[i-1][0]) < abs(dp[i-1][1])){
      dp[i][1] = dp[i-1][0];
    }else if(abs(dp[i-1][0]) == abs(dp[i-1][1]) && dp[i-1][0] > dp[i-1][1]){
      dp[i][1] = dp[i-1][0];
    }else{
      dp[i][1] = dp[i-1][1];
    }
  }

  cout << min(abs(dp[n][0]), abs(dp[n][1]));

  return 0;
}