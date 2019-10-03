#include<iostream>
#include<vector>

using namespace std;
void input(vector<int> &v){
    int n =v.size();
    for(int i=0;i<n;i++){
        cin>>v[i];
    }
}

void display(vector<int> &v){
    int n = v.size();
    for(int i=0;i<n;i++){
        cout<<v[i]<<"  ";
    }
}
void swap(vector<int> &v,int i,int j){
    int temp;
    temp=v[i];
    v[i]=v[j];
    v[j]=temp;
    
}

void bubble(vector<int> &v){
    int n=v.size();
    for(int i =0;i<n;i++){
        for(int j=1;j<n-i;j++){
            if(v[j-1]>v[j]){
                swap(v,j-1,j);
            }
        }
    }
}

void selection(vector<int> &v){
    int n = v.size();
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if(v[i]>v[j]){
                swap(v,i,j);
            }
        }
    }
}    
void modifiedbubble(vector<int> &v){
    int n = v.size();
    for(int i=0;i<n;i++){
        bool flag=false;
        for(int j=1;j<n-i;j++){
            if(v[j-1]>v[j]){
                swap(v,j-1,j);
                flag=true;
            }
           
        }
         if(flag==false){
                cout<<"flag is called at  "<<i<<endl;
                break;
            }
    }
}


int main(){
    int n;
    cin>>n;
    vector<int> v(n,0);
    input(v);
    // bubble(v);
    // selection(v);
    modifiedbubble(v);
    display(v);


    return 0;
}