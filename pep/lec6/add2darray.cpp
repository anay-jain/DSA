#include<iostream>
#include<vector>

using namespace std;
void input(vector<vector<int>> &v){
    for(int row=0;row<v.size();row++){
        for(int col=0;col<v.size();col++){
            
            cin>>v[row][col];
        }
    }
}
void display(vector<vector<int>> &v)
int main(){
    int n ,m;
    cin>>n>>m;
    vector<vector<int>>v(n,vector<int>(m,0));

    return 0;
}