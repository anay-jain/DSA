#include<iostream>
#include<vector>
using namespace std;
int bs(vector<int> &arr, int data){
int si=0, ei=arr.size()-1;
// int mid = ei%2==0?ei/2:ei+1/2;

while(si<=ei){
    int mid= (si+ei)/2;
    if(arr[mid]==data){
        return mid;
    }
    else if(arr[mid]>data){
        ei=mid-1;
    }
    else{
        si=mid+1;
    }
}

}
// lower bound in binary search 
int lowerbound(vector<int> &v,int data){
    int si=0,ei=v.size();
    while(si<=ei){
        int mid = (ei+si)/2;
        if(v[mid]==data){
             if(mid-1>=0 && v[mid-1]==data){
            ei=mid-1;
        }
        else{
            return mid;
        }
        }
       
        else if(v[mid]>data){
            ei=mid-1;
        }
        else{
            si=mid+1;
        }
    }

}

int nearestelement(vector<int> &v,int data){
    int si=0,ei=v.size();
    while(si<=ei){
        int mid= (si+ei)/2;
        if(v[mid]==data){
            break;
        }
        else if(v[mid]>data){
            ei=mid-1;
        }
        else{
            si=mid+1;
        }
    }
    if(data-v[si]>v[ei]-data){
        return ei;
    }
    else{return ei;}
}
int paired(vector<int> &v){
    int si=0,ei=v.size()-1;
    while(si<=ei){
        int mid = (si+ei)/2;
        if(mid+1<=ei && v[mid]==v[mid+1]){
            ei=mid-1;
        }
        else if(mid-1>=si && v[mid-1]==v[mid]){
            si=mid+1;
        }
        else{
            return v[mid];
        }


    }
}
void input(vector <int> &v){
    for(int i =0;i<v.size();i++){
        cin>>v[i];
    }
}
int pivotbs(vector<int> &v){
    int si=0,ei=v.size()-1;
    while(si<=ei){
        int mid=(si+ei)/2;
         if(mid-1>=si && v[mid-1]>v[mid]){
             return mid;
    }
    else if(v[mid]<v[si]){
        ei=mid;
    }
    else if(v[mid]>v[si]){
        si=mid;
    }
    else{
        break;
    }

    }
    return -1;
   
}
int searchinpivot(vector <int> &v, int data){
    
    int si =0, ei=v.size()-1;
    int mid = pivotbs(v);
    cout<<mid;
    if(mid!=-1){
        if(data<v[ei]){
            si=mid;
        }
        else{
            ei=mid-1;
            cout<<ei;

        }
    }
    

    
    while(si<=ei){
         mid=(si+ei)/2;
        if(v[mid]==data){
            return mid;
        }
        else if(v[mid]>data){
            ei=mid-1;
        }
        else{
            si=mid+1;
        }
       
    }
    return -1;
}
int main(){
    int n,t,data;
    cin>>t;
    while(t--){
        cin>>n;
    vector<int> v(n,0);
    input(v);
    cin>>data;
    cout<<searchinpivot(v,data);
    }
//    vector<int> v = {982 ,983 ,986 ,988 ,990 ,991 ,992 ,998 ,1000, 1, 3, 9 ,11 };
//    cout<<pivotbs(v);



return 0;
}