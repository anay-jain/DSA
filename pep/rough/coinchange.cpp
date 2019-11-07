#include<iostream>
#include<vector>

using namespace std;

int coin_change(vector<int> &arr , int n , string ans ){
    if(n==0){
        cout<<ans<<" ";
        return 1;
    
    }
    if(n<0){
        return 0;
    }
    int count =0;
    for(int i=0;i<arr.size();i++){
        count+=coin_change(arr , n-arr[i],ans+to_string(arr[i]));
    }
    return count;
}
// coin change and with combination
int coin_change_combination(vector<int> &arr ,int vidx,  int n , string ans ){
    // vidx because so that we can keep track of the elements we have gone thorugh;
    if(n==0){
        cout<<ans<<" ";
        return 1;
    }
    int count=0;
    for(int i=vidx;i<arr.size();i++){
        if(arr[i]<=n){
            count +=coin_change_combination(arr,i, n-arr[i], ans+to_string(arr[i]));
        }
    }
    return count;
}
int coin_change_unique_coin(vector<int> &arr , int vidx , int n , string ans){
    if(n==0){
        cout<<ans<<" ";
        return 1;
    }
    int count=0;
    for(int i=vidx ;i<arr.size();i++){
        if(arr[i]<=n){
            count+=coin_change_unique_coin(arr,i+1,n-arr[i],ans+to_string(arr[i]));
        }
        
    }
    return count;
}
int coin_change_unique_coin_permutation(vector<int> &arr , int vidx , int n , string ans , vector<bool> &check){
    if(n==0){
        cout<<ans<<" ";
        return 1;
    }
    int count=0;
    for(int i=0;i<arr.size();i++){
        if(arr[i]<=n && check[i]==false){
            check[i]=true;
            count+=coin_change_unique_coin_permutation(arr,i,n-arr[i], ans+to_string(arr[i]) , check);
            check[i]=false;
        }
        
    }
    return count;
}
void divide_array_in_equal_sum(vector<int> &arr,int vidx ,string arr1 ,string arr2, int sum1 , int sum2){
    if(vidx==arr.size()){
        if(sum1==sum2){
        cout<<arr1<<" = "<<arr2<<endl;
        // return 
        
    }
        return ;
    }
    
    divide_array_in_equal_sum(arr,vidx +1 ,arr1+" "+to_string(arr[vidx]),arr2,sum1+arr[vidx],sum2);
    divide_array_in_equal_sum(arr, vidx+1 ,arr1,arr2+" "+to_string(arr[vidx]),sum1,sum2+arr[vidx]);
    // return ;

}
int main(){
    vector<int> arr1={2,3,5,7};
    vector<bool> check(arr1.size(), false);
//    coin_change_unique_coin_permutation(arr1, 0,10,"",check);
    vector<int> arr={10,20,30,40,50,60,70};
    divide_array_in_equal_sum(arr,0,"","",0,0);
    return 0; 
}