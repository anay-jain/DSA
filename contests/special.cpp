#include<iostream>
#include<bits/stdc++.h>
#include<vector>

using namespace std;
int region(int n ){
    int i=1;
    while(pow(4,i-1)+pow(4,i)-1<n){
        i++;
    }
    return i;
}
string solve(int n ){
     
    vector <char> arr= {'a','b','c','d'};
    int temp = region(n);
    string s="";
    while(temp--){
        int region1 = region(n);
        // cout<<region1<<" "<<n;
        int power = pow(4,region1-1);
        int  t=n/power;
        s=s+arr[t-1];
        n = n%power;
    }
   
    for(int i=s.length();i>=0;i--){
        s+=s[i];
    }
    return s;
}

int main(){
    int n=23;
  for(int m=0;m<n;m++){
      cout<<m<<"  "<<solve(m)<<endl;
  }
    // cout<<s<<endl;
    return 0;
}