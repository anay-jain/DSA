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
            cout<<v[row][col]<<" ";
        }
        cout<<endl;
    }
}

void mm(vector<vector<int>> &v , vector<vector<int>> &v1){
    int n =v.size() , m=v[0].size(),p=v1.size(), q=v1[0].size();
    vector<vector<int>> ans(n,vector<int>(q,0));
    if(m!=p){
        cout<<"Mul is not possible";
        return ;
    }
    else{
        
        for(int col=0;col<q;col++){//we are running col first
            for(int row=0;row<n;row++){
                for(int k=0;k<m;k++){
                    ans[row][col] += (v[row][k] * v1[k][col]);
                }
            }
        }
    }
    display(ans);
}

int main(){
    int n , m , p ,q;
    cin>>n>>m>>p>>q;
    vector<vector<int>> v(n,vector<int>(m,0));
    vector<vector<int>> v1(p,vector<int>(q,0));
    input(v);
    input(v1);
    mm(v,v1);
    return 0;
}