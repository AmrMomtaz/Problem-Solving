#include <iostream>
#include <algorithm>

int main(){
    int n;
    scanf("%d",&n);
    long long arr[n+1];
    long long sorted[n+1];
    arr[0]=0;sorted[0]=0;
    for(int i = 1 ; i <= n ; i++) {
        scanf("%lld", &arr[i]);
        sorted[i] = arr[i];
    }
    std::sort(sorted, sorted + n + 1);
    for(int i = 1 ; i <= n ; i++){
        arr[i]+=arr[i-1];
        sorted[i]+=sorted[i-1];
    }
    int operations;
    scanf("%d",&operations);
    for(int i = 0 ; i < operations ; i++){
        int op,l,r;
        scanf("%d %d %d",&op,&l,&r);
        if(op==1)
            printf("%lld\n",(arr[r]-arr[l-1]));
        else
            printf("%lld\n",(sorted[r]-sorted[l-1]));
    }
    return 0;
}