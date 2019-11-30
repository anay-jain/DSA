#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int arrangements(vector<int> &arr , int n ,int p, vector<bool> isvisited){
    
	if(arr[n]-(n+1)==p){
		return 0;
	}
   
	if(n==arr.size()-1){
        cout<<endl;
		return 1;
	}
    //  cout<<arr[n];
	int count=0;
	
	for(int i=0;i<arr.size();i++){
        if(isvisited[i]==false && arr[i]-(i+1)!=p){
		isvisited[i]=true;
		count+=arrangements(arr, i+1, p,isvisited);
		isvisited[i]=false;
        }
	
	}
	return count;
}
int main () {
	int n ,p;
	cin>>n>>p;
	vector<int> arr(n,0);
	vector<bool> isvisited(n,false);
	for(int i=0;i<arr.size();i++){
		arr[i]=i+1;
        // cout<<arr[i];
	}
	cout<<arrangements(arr,0,p,isvisited);
	return 0;
}