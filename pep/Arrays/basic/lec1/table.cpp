#include <iostream>
using namespace std;
int main(){
    cout<<"Enter the table number and upto";
    int n,a ;
    cin>>n>>a;
    for(int i =1;i<=a;i++){
        cout<<n<<" * "<<i<<" = "<<n*i<<endl;
    }

    return 0;
}