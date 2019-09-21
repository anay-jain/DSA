#include<iostream>
#include<vector>
using namespace std;

int max(vector<int>& arr){ // so to not create copies 
    int temp=arr[0];
    for(int i : arr){
        if(i>temp){
            temp=i;
        }
    }
    return temp;


}
int min(vector<int>& arr){
    int temp=arr[0];
    for(int i : arr){
        if(temp>i){
            temp=i;
        }
       
    }
     return temp;
}
void input(vector<int>& arr){
    for(int i=0;i<arr.size();i++){
        cin>>arr[i];
    }
}

int main(){
    int n;
    cin>>n;
    vector<int> arr(5,0);
    input(arr);
    int max1= max(arr);
    cout<<"Maximum value is "<<max1<<endl;
    cout<<"Minimum value is "<<min(arr)<<endl;
    return 0;
}