
#include<iostream>
#include<vector>
using namespace std;
  
int main(){
    int n , m ,k,count=0;
    cin>>n>>m>>k;
    vector<int> v(n,0);
    vector<int>c(m,0);
    int seatstu = m*k;
      for(int i =0;i<n;i++){
          cout<<"h";
        cin>>v[i];     
    }

    for(int i=0;i<m*k;i++){
        // cout<<"hello";
        // int l=i;
        int flag=0;
        int t =v[i];
        while(c[t-1]==k){
            flag=1;
            t++;
            if(t==m){
                t=1;
            }
        }
        if(flag==1){
            count+=1;
        }
        cout<<t<<" "<<count<<endl;
        c[t-1] = c[t-1]+1;


    }
    // for(int i=0;i<m;i++){
    //     count = c[i]-k;
    //     cout<<c[i]<< " " <<count<<endl;
    //     if(count>0){
    //         total+=count;
    //     }
    // }
    count=count+(n-seatstu);
    cout<<count;

    return 0;
}
