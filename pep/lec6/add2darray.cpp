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
void display(vector<vector<int>> &v){
    for(int row=0;row<v.size();row++){
        for(int col=0;col<v.size();col++){
            cout<<v[row][col];
        }
    }
}
void addarray(vector<vector<int>> &v, vector<vector<int>> &v1){
    for(int row=0;row<v.size();row++){
        for(int col=0;col<v.size();col++){
            v[row][col] = v[row][col]+v1[row][col];
        }
    }

}
int main(){
    int n ,m;
    cin>>n>>m;
    vector<vector<int>>v(n,vector<int>(m,0));
    vector<vector<int>>v1(n ,vector<int>(m,0));
    input(v);
    input(v1);
    addarray(v,v1);
    display(v);

    return 0;
}