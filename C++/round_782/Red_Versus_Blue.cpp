//
// Created by Momtaz on 17/4/2022.
//
#include "iostream"
using namespace std;

int main(){
    int T;
    scanf("%d",&T);
    for (int t = 0 ; t < T ; t++){
        int n,r,b;
        scanf("%d %d %d",&n,&r,&b);
        char result [n];
        int b_point = n/(b+1);
        //b_point = n%(b+1)==0 ? b_point : b_point+1;
        int b_rest = b_point;
        for(int i = 0 ; i < n ; i++){
            if(b_rest==0){
                result[i] = 'B';
                b_rest = b_point;
            }else{
                result[i] = 'R';
                b_rest--;
            }
        }
        for(char ch : result)
            printf("%c",ch);
        printf("\n");
    }
    return 0;
}