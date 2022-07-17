#include<bits/stdc++.h>
using namespace std;
void solve(){
int n;
cin>>n;
int count =1;
int num;
int prev=0;
int pos=1;
int flag=0;
vector<int> v;
v.clear();
for(int i =1;i<=n;i++){
      cin>>num; 
    if(i==1){
        prev =num;
        count=1;
        continue;
    }
  
   if(prev==num){
            count++;
        }
     if(count==1){
            flag=1;
            break;
        }
    else{     
        for(int j =i-1;j>=pos;j--){
                  v.push_back(j);
                  
                
            }    
            pos =i;
            prev=num;
            count=1;
        }      
}
if(count ==1){
     cout<<-1;
}
else if(flag==0){
  for(int j =n;j>=pos;j--){
                  v.push_back(j);
                  
                
            }
     for (auto elem : v) {
        cout << elem <<" ";
    }
}
else{
    cout<<-1;
}
cout<<endl;
}


int main(){
    int t;
    cin>>t;
    while(t--){
        solve();
    }

    return 0;
}
