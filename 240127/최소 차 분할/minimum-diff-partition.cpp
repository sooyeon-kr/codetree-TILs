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
    for(int j=0; j<i; ++j){
      tmp = min(tmp, abs(dp[j][0] - (2 * arr[i])));
      tmp = min(tmp, abs(dp[j][1] - (2 * arr[i])));
    }

    dp[i][0] = tmp;
    dp[i][1] = min(dp[i-1][0], dp[i-1][1]);
  }

  cout << min(dp[n][0], dp[n][1]);

  return 0;
}