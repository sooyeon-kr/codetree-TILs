#include <iostream>
using namespace std;

int main() {
    double a = 25.352;
    cout.setf(ios::fixed);
    cout.precision(1);
    cout<<a;
    return 0;
}