#include <iostream>
#include <bits/stdc++.h>

using namespace std;
int main(){
    int N;
    cin >> N;
    int arr[N];
    for(int i = 0 ; i < N ; i++)
        cin >> arr[i];
    sort(arr, arr + N);
    int indexLeft = 0;
    int indexRight = N-1;
    long long result = arr[N-1]-arr[0];
    cout << result << " ";
    long long sumLeft = arr[0];
    long long sumsRight = arr[N-1];
    bool lefTurn = true;
    while(indexLeft<indexRight-1){
        if(lefTurn){
            result+= sumsRight - sumLeft;
            sumLeft+=arr[++indexLeft];
            lefTurn= false;
        }else{
            result += sumsRight - sumLeft + arr[indexRight-1];
            sumsRight += arr[--indexRight];
            lefTurn = true;
        }
        cout << result << " ";
    }
    return 0;
}
