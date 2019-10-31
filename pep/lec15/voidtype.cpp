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
void basicques(){
    // subseq("abc","");
    // removeHi("hishshi" ,"");
    removeduplicates("aaaaabbbcc" , "");
    // compression("aabbccc","", 0);
    // mazepath(0,0,2,2,"");
}
void solve(){
    basicques();
}

int main(){
    solve();
    return 0;
}