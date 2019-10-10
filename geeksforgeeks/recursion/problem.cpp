#include<iostream>
#include<vector>
using namespace std;
void display(vector<int>& v){
    for(int i=0;i<v.size();i++){
        cout<<v[i]<<" ";
    }
    cout<<endl;
}

int jose(vector<int>&a ,int k , int i){
    int n=a.size();
    if(a.size()==1){
        return a[0];
    }
        i=i%(n);
     (i==0)?a.erase(a.begin()+(n-1)):a.erase(a.begin()+(i-1));
    cout<<"size : "<<n<<" i "<<i<<endl;
    display(a);
    int recAns = jose(a,k,i+k);
    return recAns;

}
int main(){
    vector<int> a = {1,2,3,4,5,6c};
    cout<<jose(a,2,2);
    return 0;


}