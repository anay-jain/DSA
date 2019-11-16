#include<iostream>
#include<vector>
#include<string>
#include<climits>
#include<math.h>
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
// ===============================================================================================
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
//===================================================================================================
int boardPath(int s, int d, string ans)
{
    if (s == d)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    for (int dice = 1; dice <= 6 && s + dice <= d; dice++)
    {
        count += boardPath(s + dice, d, ans + to_string(dice));
    }

    return count;
}
//=================permutatition===================================================================
int permutation_01(string word , string ans){
    if(word.length()==0){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=0;i<word.length();i++){
        char ch = word[i];
        string ros = word.substr(0,i)+word.substr(i+1);
        count+=permutation_01(ros,ans+ch);
    }
    return count;
}
int subseq_02(string word, string ans){
     
    if(word.length()==0){
       cout<<ans<<endl;
        return 1;
    }
    int count=0;
    char ch=word[0];
    count+=subseq_02(word.substr(1),ans+ch);
    count+=subseq_02(word.substr(1),ans);
    return count;
}
int permuation_02_withoutrep(string word , string ans){

     if(word.length()==0){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    vector<bool> check(26,false);
    
   
    for(int i=0;i<word.length();i++){
        char ch = word[i];
         if(!check[ch-'a']){
             check[ch-'a']=true;
        string ros = word.substr(0,i)+word.substr(i+1);
        count+=permuation_02_withoutrep(ros,ans+ch);
         }

    }
    return count;


}
//==========equi set=============================================================================
int equiset(vector<int> &arr , int vidx, int sum1 , int sum2 , string arr1 , string arr2){
    if(vidx==arr.size()){
        if (sum1==sum2){
        cout<<arr1 <<" = "<<arr2<<endl;
        return 1;
        }
        return 0;
        }
        
    int count=0;
    count +=equiset(arr , vidx+1,sum1+arr[vidx], sum2 , arr1+to_string(arr[vidx])+ " ",arr2);
    count+= equiset(arr, vidx+1 , sum1 ,sum2+arr[vidx],arr1, arr2+to_string(arr[vidx])+" ");
    return count;
}
//=========coin change============================================================================
int coinchange_01_permu(vector<int> &coins , int target , string ans){
    if(target==0){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=0;i<coins.size();i++){
        if(target>=coins[i])
        count+=coinchange_01_permu(coins , target-coins[i],ans+to_string(coins[i]));
    }
    return count;
}
int coinchange_01_combi(vector<int> &coins,int vidx , int target , string ans){
    if(target==0){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i = vidx ; i<coins.size();i++){
        if(target>=coins[i])
        count+=coinchange_01_combi(coins , i , target-coins[i],ans+to_string(coins[i]));
    }
    return count;
}
int coinchange_01_combi_unique(vector<int> &coins,int vidx , int target , string ans){
    if(target==0){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i = vidx ; i<coins.size();i++){
        if(target>=coins[i])
        count+=coinchange_01_combi_unique(coins ,i+1, target-coins[i],ans+to_string(coins[i]));
    }
    return count;
}

int coinchange_01_permu_unique(vector<int> &coins ,vector<bool> &coinsUsed, int target , string ans){
    if(target==0){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=0;i<coins.size();i++){
        if(target>=coins[i] && !coinsUsed[i]){
        coinsUsed[i]=true;
        count+=coinchange_01_permu_unique(coins ,coinsUsed, target-coins[i],ans+to_string(coins[i]));
        coinsUsed[i]=false;
        }
  }
    return count;
}
int coinchange_combi_target(vector<int> coins , int vidx , int target , string ans){
 if(target==0 || vidx==coins.size()){
     if(target==0){
          cout<<ans<<endl;
        return 1;
     }
       return 0;
    }
    int count=0;
    if(target-coins[vidx]>=0)
    count+=coinchange_combi_target(coins , vidx, target-coins[vidx],ans+to_string(coins[vidx]));
    count+=coinchange_combi_target(coins, vidx +1, target , ans);
    return count;
}
int coinchange_permu_target(vector<int> coins , int vidx , int target , string ans){
 if(target==0 || vidx==coins.size()){
     if(target==0){
          cout<<ans<<endl;
        return 1;
     }
       return 0;
    }
    int count=0;
    if(target-coins[vidx]>=0)
    count+=coinchange_permu_target(coins ,0, target-coins[vidx],ans+to_string(coins[vidx]));
    count+=coinchange_permu_target(coins, vidx +1, target , ans);
    return count;
}
int coinchange_combi_target_unique(vector<int> coins , int vidx , int target , string ans){
 if(target==0 || vidx==coins.size()){
     if(target==0){
          cout<<ans<<endl;
        return 1;
     }
       return 0;
    }
    int count=0;
    if(target-coins[vidx]>=0)
    count+=coinchange_combi_target_unique(coins , vidx+1, target-coins[vidx],ans+to_string(coins[vidx]));
    count+=coinchange_combi_target_unique(coins, vidx +1, target , ans);
    return count;
}
int coinchange_permu_target_unqiue(vector<int> coins,vector<bool> coinUsed , int vidx , int target , string ans){
 if(target==0 || vidx==coins.size()){
     if(target==0){
          cout<<ans<<endl;
        return 1;
     }
       return 0;
    }
    int count=0;
    if(target-coins[vidx]>=0 && !coinUsed[vidx]){
        coinUsed[vidx]=true;
        count+=coinchange_permu_target_unqiue(coins ,coinUsed,0, target-coins[vidx],ans+to_string(coins[vidx]));

        coinUsed[vidx]=false;
    }
    count+=coinchange_permu_target_unqiue(coins, coinUsed, vidx +1, target , ans);
    return count;
}
// =======nqueen======================================================================================
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
    int y = i%loc[0].size();
    if(!isSafeToPlace(loc,x,y)){
        loc[x][y]=true;
        count+=nqueen(loc,tnq,i,qpsf+1,ans+"B"+to_string(x)+","+to_string(y)+"Q"+to_string(qpsf)+" ");
        loc[x][y]=false;
    }
    
}
}
int nqueen_target(vector<vector<bool>> &loc ,int vidx,  int tnq  ,int qpsf , string ans){
    int totalsqaures = loc.size()*loc[0].size();

    if(tnq==qpsf || vidx==totalsqaures){
       if(tnq==qpsf){
        cout<<ans<<endl;
        return 1;
       }
       return 0;
    }
  
int count=0;

    int x = vidx/loc[0].size();
    int y = vidx%loc[0].size();
    if(!isSafeToPlace(loc,x,y)){
        loc[x][y]=true;
        count+=nqueen_target(loc,vidx+1,tnq,qpsf+1,ans+"B"+to_string(x)+","+to_string(y)+"Q"+to_string(qpsf)+" ");
        loc[x][y]=false;
    }
    count+=nqueen_target(loc,vidx+1,tnq,qpsf,ans);
    

return count;
}
//=========crypto==========================================================================
string str1 ="send";
string str2="more";
string str3="money";
string stradd=str1+str2+str3;
string str="";
vector<int> maping(26,-1);
vector<bool> numUsed(10,false);



int decodeword(string somestr){
   int codeans=0;
    int t=1;
    for(int i=0;i<somestr.length();i++){
        int no = somestr[i]-'a';
        int num=maping[no];
        codeans = codeans*10 + num;
        // t*=10;

    }
    // cout<<codeans<<endl;
    return codeans;
}
int crypto(string str , int idx){
    if(idx==str.length()){
        int a = decodeword(str1),b=decodeword(str2),c=decodeword(str3);
        if(a+b==c){
        // if(decodeword(str1)+decodeword(str2)==decodeword(str3)){
            for(int encodenum=0;encodenum<26;encodenum++){
                if(encodenum!=-1){
                    // cout<<(char)encodenum+'a'<<" "<<maping[encodenum]<<endl;
                }
            }
            return 1;
        }
        return 0;
    }
    char ch = str[idx];
    int count= 0;
    for(int i=0 ; i<10;i++){
        if(numUsed[i]==false){
        numUsed[i]=true;
        // int t = str[i]-'a';
        // char ch = str[i];
        maping[ch-'a']=i;
        cout<<"idx "<<idx<<" "<<"i "<<i<<endl;
        // cout<<maping[ch-'a'];
        count+=crypto(str,idx+1);
        maping[ch-'a']=-1;
        numUsed[i]=false;
    }
    }
    return count;
    }

void freqmap1(){
   
    vector<int> freqmap(26,0);
    for(int i=0;i<stradd.length();i++){
        // int idx = str[i];
        int idx=stradd[i]-'a';
        freqmap[idx]++;
    }
    for(int i=0;i<26;i++){
        if(freqmap[i]!=0){
          
            str+=(char)(i+'a');
            
        }
    }
 
}
vector <string> Dict={"i","like","mangoes"};
bool isInDict(string word){
    for(string ele: Dict){
        if(ele.compare(word)==0){
            return 1;
        }
        
    }
    return 0;
}
int wordbreak(string word , string ans){
    if(word.length()==0){
        cout<<ans<<endl;
        return 1;
    }
    string temp ="";
    int count=0;
    for(int i=0;i<word.length();i++){
        temp+=word[i];
        if(isInDict(temp)){
            count += wordbreak(word.substr(i+1),ans+temp+" ");

        }
    }
    return count;
}
//=======soduku with bit masking =====================================================================
//   vector<vector<int>> board(8,vector<int>(8,0));

//  int board[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
//          {0, 0, 0, 0, 0, 0, 0, 0, 0},
//          {0, 8, 7, 0, 0, 0, 0, 3, 1},
//          {0, 0, 3, 0, 1, 0, 0, 8, 0},
//          {9, 0, 0, 8, 6, 3, 0, 0, 5},
//          {0, 5, 0, 0, 9, 0, 6, 0, 0},
//          {1, 3, 0, 0, 0, 0, 2, 5, 0},
//          {0, 0, 0, 0, 0, 0, 0, 7, 4},
//          {0, 0, 5, 2, 0, 6, 3, 0, 0}};
          

// bool issodukuvalid(int x , int y , int num){
//     for(int i=0;i<8;i++){
//             if(board[x][i]==num){
//                 return true;
//             }
//             if(board[i][y]==num){
//                 return true;
//             }
//     }
//         int r=(x/3)*3;
//          int c=(y/3)*3;
//          for(int row=0;row<3;row++){
//             for(int col=0;col<3;col++){
//                 if(board[r+row][c+col]==num) return true;
//             }
//          }

//     return false;

// }
// int soduku(int vidx){
//    if(vidx==81){
//     //    for(int vec : board){
//     //        for(int ele : vec){
//     //            cout<<ele<<" ";
//     //        }
//     //        cout<<endl;
//     //    }
//        return 1;
//    }
//     int x = vidx/9;
//     int y = vidx%9;
//     int count=0;
//     if(board[x][y]!=0){
//     count+=soduku(vidx+1);
// }
// else{
//     for(int i=1;i<10;i++){
//         if(issodukuvalid(x,y,i)){
//         board[x][y]=i;
//         count+=soduku(vidx+1);
//         board[x][y]=0;
//         }
       
   
//     }
// }
// return count;
    
// }
//============ max points =========================================================================
int max_points(vector<int> &arr , int vidx){
    if(vidx==arr.size()){
        return 0;
    }
    
   int temp =  max_points(arr,vidx+1);
   if(vidx==0 ){
        temp = max(temp,arr[vidx]*arr[vidx+1]);
    }
    else if(vidx==arr.size()-1){

        temp = max(temp,arr[vidx-1]*arr[vidx]);
        
    }
    else{
         temp = max(temp,arr[vidx-1]*arr[vidx]*arr[vidx+1]);
        
       
       
    }
    // cout<<vidx<<" "<<temp;
     return temp;
}

// ===================================================================================================
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
void coinchange(){
    vector<int>coins = {2,3,5,7};
    vector<bool>coinsUsed(4,false);
    // cout<<coinchange_01_permu(coins,10,"");
    // cout<<coinchange_01_permu_unique(coins,coinsUsed,10,"");
    // cout<<coinchange_01_combi_unique(coins,0,10,"");
    // cout<<coinchange_combi_target(coins , 0,10,"");
    //  cout<<coinchange_permu_target(coins , 0,10,"");
    // cout<<coinchange_permu_target_unqiue(coins , coinsUsed , 0, 10 ,"");
    // vector<int> arr={10,20,30,40,50,60,70,80};
    // cout<<equiset(arr,0,0,0,"","");

}
void permutation_types(){
    // cout<<permutation_01("abc","");
    // cout<<subseq_02("abc","");
    cout<<permuation_02_withoutrep("abab","");
}
void nqueen_all(){
    // cout<<nqueen_combi_01(7,3,-1,0,"");
    // vector<bool> loc(8,false);
    vector<vector<bool>> loc(4,vector<bool> (4,false));
    // cout<<nqueen_permu_01(7,3,loc,0,"");
    // cout<<nqueen_combi02_target(7,3,0,0,"");
    // cout<<nqueen_permu02_target(7,3,0,0,loc,"");
    // cout<<nqueen(loc , 4,-1,0,"");
    cout<<nqueen_target(loc,0,4,0,"");
}
void crypto_ques(){
    freqmap1();
    cout<<crypto(str, 0);

}
void solve(){
    // basicques();
    // nqueen_all();
    // coinchange();
    // permutation_types();
    // crypto_ques();
    // soduku(-1);
    vector<int> arr={2,3,6,7,8};
    cout<<max_points(arr,0);
}

int main(){
    solve();
    return 0;
}