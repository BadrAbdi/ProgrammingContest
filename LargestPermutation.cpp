#include <iostream>
using namespace std;

int main() {
	int N,K;
	cin >> N;
	cin >> K;
	int array[N],pos[N+1];
	for(int x = 0;x<N;x++){
		cin >> array[x];
		pos[array[x]] = x;
	}
	for(int i = 0;i<N && K>0;i++){
		if(array[i] == N-i)
			continue;
	    array[pos[N-i]] = array[i];
	    pos[array[i]] = pos[N-i];
	    pos[N-i] = i;
	    array[i] = N-i;
	    K--;
	}
	for(int t = 0;t<N;t++){
		cout << array[t] << " ";
	}
    return 0;
}
