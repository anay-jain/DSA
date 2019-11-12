#include<iostream>
#include<vector>
#include<string>
#include<climits>

using namespace std;
void subseq(string ques , string ans){
    if(ques.length()==0){
        cout<<ans<<" ";
        return ;
    }
    char ch = ques[0];
    ques = ques.substr(1);
    subseq(ques,ans+ch);
    subseq(ques,ans);
}
void removeHi(string ques , string ans){
    
    if(ques.length()==0){
        cout<<ans;
        return ;
    }
    
    if(ques.length()>1 && ques[0]=='h' && ques[1]=='i'){
        removeHi(ques.substr(2),ans);
    }
    else{
        removeHi(ques.substr(1),ans+ques[0]);
    }
} 
void removeduplicates(string ques , string ans){
    if(ques.length()==0){
        cout<<ans;
        return ;
    }
    // if(ques.length()==1){
    //     ans = ans+ques[0];
    // }
    if( ques[0]==ans[ans.length()-1]){
        removeduplicates(ques.substr(1),ans);
    }
    else{
        removeduplicates(ques.substr(1), ans+ques[0]);
    }
}
void compression(string ques, string ans, int count){
    if(ques.length()==0){
        cout<<ans;
        return ;
    }
    if(ques[0]==ans[ans.length()-1]){
        compression(ques.substr(1),ans,count+1);
    }
    else{
        
        compression(ques.substr(1),ans+ques[0]+to_string(count), 0);
    }

}

void mazepath(int sr , int sc , int er , int ec , string ans){
    if(sr==er && sc==ec){
        cout<<ans<<" ";
        return ;
    }
    if(sr<er){
        mazepath(sr+1,sc, er , ec, ans+"h");
    }
    if(sc<er){
        mazepath(sr,sc+1,er,ec,ans+"v");
    }
}
void mazepath_multi(int sr , int sc , int er ,int ec,string ans){
    if(sr==er && sc==ec){
        cout<<ans<<" ";
        return;
    }
    for(int i=1;i+sr<=er;i++){
        mazepath_multi(sr+i,sc,er,ec,ans+"h");

    }
    for(int i=1;i+sc<=ec;i++){
        mazepath_multi(sr,sc+i,er,ec,ans+"v");
    }
}
int board_path(int start,int n ){
    
    if(start==n){
        return 1;
       
    }
    if(start>n){
        return 0;
    }
    int c=0;
for(int i=1;i<=6 && i+start<=n;i++){
     c +=  board_path(i+start ,n );

}
    return c;
}
void permuation_withrep(string s,string ans){
    
}
void mazepath_question(){
//  mazepath_multi(0,0,2,2,"");
// cout<<board_path(0,10);

}
void basicques(){
    // subseq("abc","");
    // removeHi("hishshi" ,"");
    // removeduplicates("aaaaabbbcc" , "");
    // compression("aabbccc","", 0);
    // mazepath_question();
    //
}
int nqueen_combi_01(int boxes , int tnq , int qloc , int qpsf,string ans ){
if(tnq==qpsf || qloc==boxes ){
    if(tnq==qpsf){
        cout<<ans<<endl;
        return 1;
    }
    return 0;
}
int count=0;
for(int i=qloc+1 ;i<boxes;i++){
    count+=nqueen_combi_01(boxes,tnq,i,qpsf+1,ans+"B"+to_string(i)+"Q"+to_string(qpsf)+" ");
}
return count;
}
int nqueen_permu_01(int boxes,int tnq , vector<bool> &loc , int qpsf ,string ans){
    if(tnq==qpsf ){
    if(tnq==qpsf){
        cout<<ans<<endl;
        return 1;
    }
   
    }
    int count=0;
    for(int i=0;i<loc.size();i++){
        if(!loc[i]){
            loc[i]=true;
            count+=nqueen_permu_01(boxes,tnq,loc,qpsf+1,ans+"B"+to_string(i)+"Q"+to_string(qpsf)+" ");
            loc[i]=false;
        }
         }
         return count;
}
int nqueen_combi02_target(int boxes , int tnq , int qloc , int qpsf , string ans){
   if(tnq==qpsf || qloc==boxes ){
    if(tnq==qpsf){
        cout<<ans<<endl;
        return 1;
    }
    return 0;
}
    int count=0; 
    count+=nqueen_combi02_target(boxes , tnq , qloc+1,qpsf+1,ans+ "B" + to_string(qloc)+"Q"+to_string(qpsf)+" ");
    count+=nqueen_combi02_target(boxes , tnq , qloc+1,qpsf,ans);
    
    
    return count;
}
int nqueen_permu02_target(int boxes , int tnq, int qloc , int qpsf , vector<bool> &loc , string ans){
    if(tnq==qpsf || qloc==boxes ){
    if(tnq==qpsf){
        cout<<ans<<endl;
        return 1;
    }
    return 0;
}
    int count=0;
    if(!loc[qloc]){
        loc[qloc]=true;
        count+=nqueen_permu02_target(boxes, tnq ,qloc+1 ,qpsf+1,loc , ans+"b"+to_string(qloc)+"Q"+to_string(qpsf)+" ");
        loc[qloc]=false;
    }
    count+=nqueen_permu02_target(boxes , tnq , qloc +1 , qpsf , loc , ans);
    return count;
}
bool isSafeToPlace(vector<vector<bool>> &boxes , int x , int y){
    int dir[4][2]={{0,-1},{-1,-1},{-1,0},{-1,1}};
    for(int d=0;d<4;d++){
        for(int rad=1;rad<boxes[0].size();rad++){
            int r = x + rad* dir[d][0];
            int c = y + rad* dir[d][1];
            if(r>=0 && c>=0 && r<boxes.size() && c<boxes[0].size() && boxes[r][c]){
                return true;
            }
        }
    }
    return false;
}
int nqueen(vector<vector<bool>> &loc , int tnq ,int qloc ,int qpsf , string ans){
    int totalsqaures = loc.size()*loc[0].size();

    if(tnq==qpsf){
        cout<<ans<<endl;
        return 1;
    }
  
int count=0;
for(int i =qloc+1 ;i<totalsqaures;i++){
    int x = i/loc[0].size();
    int y =i%loc[0].size();
    if(!isSafeToPlace(loc,x,y)){
        loc[x][y]=true;
        count+=nqueen(loc,tnq,i,qpsf+1,ans+"B"+to_string(x)+","+to_string(y)+"Q"+to_string(qpsf)+" ");
        loc[x][y]=false;
    }
    
}
return count;
}
void nqueen_all(){
    // cout<<nqueen_combi_01(7,3,-1,0,"");
    // vector<bool> loc(8,false);
    vector<vector<bool>> loc(4,vector<bool> (4,false));
    // cout<<nqueen_permu_01(7,3,loc,0,"");
    // cout<<nqueen_combi02_target(7,3,0,0,"");
    // cout<<nqueen_permu02_target(7,3,0,0,loc,"");
    cout<<nqueen(loc , 4,-1,0,"");
}
void solve(){
    // basicques();
    nqueen_all();
}

int main(){
    solve();
    return 0;
}