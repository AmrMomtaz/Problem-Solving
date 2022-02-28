#include <iostream>
#include <iterator>
#include <set>
using namespace std;
int main(){
    int students,preferences;
    scanf("%d %d",&students,&preferences);
    set<set<int>> listOfArrays;
    for(int i = 1 ; i <= students;i++){
        set<int> newSet;
        newSet.insert(i);
        listOfArrays.insert(newSet);
    }
    for (int i = 0 ; i <preferences ; i++){
        int s1,s2;
        scanf("%d %d",&s1,&s2);
        set<int> *ptr1 = NULL,*ptr2 = NULL;
        for(set<int> currentSet : listOfArrays){
            iterator<int> it1 = currentSet.find(s1);
            if(currentSet.find(s1)!=)
        }

    }
    return 0;
}