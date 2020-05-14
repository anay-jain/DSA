#include<iostream>
#include<vector>
using namespace std;

int main(){
    vector<int> nums={2,3,4,2,3,2,3};
    int k=3;
    vector<int> arr(32,0);
    for(int i=0;i<nums.size();i++){
        int t=0;
        while(nums[i]!=0){
            if(nums[i]&1 != 0){
                arr[t]++;
                t++;
                // cout<<arr[t];
               
            }
             nums[i]=nums[i]>>1;
        }
    }
    int num=0;
    for(int i=0;i<=32;i++){
        // arr[i]%=k;
        if(arr[i]%k!=0){
            num |= (1<<i);
            
        }
        
        // cout<<arr[i];
    }
    cout<<num;

    return 0;
}