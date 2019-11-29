#include<iostream>
#include<string>
#include<vector>
using namespace std;
string dangerous(string s){
int count =0;
char  flag=s[0];
    for(int i=0;i<s.size();i++){
        if(count==7){
            return "YES";
        } 
     
        if(s[i]=='0' ){
            if(flag=='0'){
               
                 count+=1;   
            }
            else{
              
                count=1;
            }
               
        }
         if(s[i]=='1' ){
            if(flag=='1'){
                 count+=1;   
            }
            else{
                count=1;
            }
               
        }
          
        flag=s[i];
       cout<<count<<" ";
    }
   
    return "NO";
}
int traversal(vector<int> &arr ){
    int  r= arr.size();
    int c = arr[0].size();
    for(int i=0;i<arr.size();i++){
        for

    }

}
int main(){

    cout<<dangerous("0100110111111101");

    return 0;
}