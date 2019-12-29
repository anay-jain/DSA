#include<iostream>
using namespace std;
int minutes(int h,int m ){
  int ans = ((23-h)*60)+(59-m)+1;
    return ans;
}
int main(){
int t;
cin>>t;
while(t--){
    int h , m ;
    cin>>h>>m;
    cout<<minutes(h,m)<<endl;

}


}