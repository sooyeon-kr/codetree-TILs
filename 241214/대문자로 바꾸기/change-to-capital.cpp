#include <iostream>
#include <cctype>
using namespace std;

int main() {
    char temp;
    for(int y=0; y<5; ++y){
        for(int x=0; x<3; ++x){
            cin>>temp;
            cout<<char(toupper(temp))<<' ';
        }
        cout<<'\n';
    }
    return 0;
}