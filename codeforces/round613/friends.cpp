#include<iostream>
#include<vector>
#include<list>
using namespace std;
void friendfn(int n){
    vector<int> arr(n,0);
    vector<int > rem;
    for(int i=0;i<arr.size();i++){
        cin>>arr[i];
        if(arr[i]==0){
            rem.push_back(i);
            cout<<i;
        }
    }
    for(int i=0;i<arr.size();i++){
        if(arr[i]==0){
            int temp = rem[rem.size()-1];
            if(temp==i){
                rem.pop_back();
                arr[i]=rem[rem.size()-1]+1;
                rem.push_back(temp);
            }
            else{
                arr[i]=temp+1;
                rem.pop_back();
            }
        }
        cout<<arr[i]<<" ";
    }

    // for(int i=0;i<arr.size();i++){
    //     for(int j=0;j<arr.size();j++){
    //         if(ans[i]==false && ans[j]==false){
    //             if(i!=j){
                 
    //                 arr[i]=j+1;
    //                 ans[j]=true;
    //                 break;
    //             }
    //         }
            
    //     }
    //     cout<<arr[i]<<" ";
    // }
}
int main(){
    int n;
    cin>>n;
    friendfn(n);
    return 0;
}