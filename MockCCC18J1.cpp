#include <bits/stdc++.h>

using namespace std;

int main() {
    int a,n,count;
    count = 0;
    cin >> a;
    for(int x =0;x<a;x++){
        cin >> n;
        if(n != 0){
            count+=n;
        }
    }
    cout << count<<endl;
    return 0;

}