#include<iostream>
#include<vector>
using namespace std;
void display(vector<int> &v){
    for(int i =0;i<v.size();i++){
        cout<<v[i]<<" ";
    }
}
void bubble(vector <int> &v , vector<int> &no){
    for(int i=0;i<v.size();i++){
        int flag= false;
        for(int j=1;j<v.size()-i;j++){
            if(v[j-1]>v[j]){
                swap(v[j-1],v[j]);
                swap(no[j-1],no[j]);
                flag=true;
            }
        }
        if(flag==false){
            break;
     }
    }

}
int bitsets(int n ){
      int l =0,count=0;
    while(n!=0 && l<32){
        if((n&1) !=0){
            count++;
            
        }
        n>>=1;
        l++;
    }
    return count;
}

int main(){
    int n;
    cin>>n;
    vector<int> arr(n,0);
  for(int i=1;i<=n;i++){
       arr[i-1]=bitsets(i);
  }
    vector <int> no(n,0);
    for(int i=0;i<no.size();i++){
        no[i]=i+1;
    }
    bubble(arr,no);
    display(no);
    return 0;
}