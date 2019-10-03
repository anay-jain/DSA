#include<iostream>
#include<vector>
using namespace std;
void input(vector <int> &v){
    for(int i=0;i<v.size();i++){
        cin>>v[i];
    }
}

int avgarr(vector <int> &v){
    int sum=0 ;
    for(int i = 0 ;i<v.size();i++){
        sum+=v[i];
    }
    
    return sum;
}
int initailize(vector<int> &v){
    for(int i=0;i<v.size();i++){
        v[i]=0;
    }
}

int bs(vector<int> &v,int student){
    
    int pagesmin = 0 , pagesmax=avgarr(v);
    int mid = (pagesmin + pagesmax)/2;
    vector<int> pages(student,0);
    while(pagesmin<pagesmax-1){
        
        cout<<pagesmin<< "  to "<<pagesmax<<endl; 
        int stu = student;
        // int stu;
        int start=0;
        initailize(pages);    
          while(stu--)
    {
        cout<<"hello";
        // pages[stu]=0;
        for(int i =start;i<v.size()-stu+1;i++){
            if(v[i]+ pages[stu]<=mid){
                pages[stu]+=v[i];
                start++;
                cout<<"Value of start-> "<<start<<endl;
            }
            else{
                break;
            }
            
            
        }
    // stud--;
    }

     if(start==v.size()){
        pagesmax = mid; 
    }
    else{
        pagesmin=mid;
    }
    mid = (pagesmin + pagesmax)/2;

    }
  
for(int t=0;t<student;t++){
    cout<<pages[t]<<"  ";
}    

   
}
  
int main(){
    int n ,stu;
    cin>>n>>stu;
    vector <int> v(n,0);
    input(v);
    bs(v,stu);

    return 0;
}