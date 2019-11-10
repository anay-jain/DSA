#include<iostream>
#include<vector>
using namespace std;
int nqueen_combi01(int boxes , int tnq , int qpsf , int qloc , string ans){
    if(tnq==qpsf){
        cout<<ans<<endl ; 
        return 1;
    }
    int count =0;
    for(int i=qloc +1;i<boxes;i++){
        count+=nqueen_combi01(boxes , tnq , qpsf+1 , i, ans+ "b"+to_string(i)+ "q"+to_string(qpsf)+" ");
    }
    return count;
}
int nqueen_permu01(vector<bool> &arr, int boxes , int tnq , int qpsf , string ans ){
    if(tnq==qpsf){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=0;i<boxes ;i++){
        if(arr[i]==false){

            arr[i]=true;
             count+=nqueen_permu01(arr, boxes , tnq, qpsf+1,ans+ "b"+to_string(i)+ "q"+to_string(qpsf)+" ");
             arr[i]=false;
        }
       
    }
    return count;
}
int nqueen_combi_target(int boxes , int tnq , int qpsf , int qloc , string ans){
    if(qpsf==tnq || boxes<=qloc){
       if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;
       }
       return 0;
    }
    int count=0;
    count+=nqueen_combi_target(boxes , tnq ,qpsf+1 , qloc+1,ans+ "b"+to_string(qloc)+ "q"+to_string(qpsf)+" ");
    count+=nqueen_combi_target(boxes ,tnq , qpsf , qloc+1,ans );
    // for(int i=0;i<boxes;i++){
    //     if
    // }
    return count;
}
int nqueen_permu_target(vector<int> &arr , int boxes , int tnq , int qpsf , int qloc , string ans){
    if(qpsf==tnq || boxes<=qloc){
       if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;
       }
       return 0;
    }
    int count=0;
    count+=nqueen_permu_target(arr,boxes , tnq ,qpsf+1 , qloc+1,ans+ "b"+to_string(qloc)+ "q"+to_string(qpsf)+" ");
    count+=nqueen_permu_target(arr, boxes ,tnq , qpsf , qloc+1,ans );
    // for(int i=0;i<boxes;i++){
    //     if
    // }
    return count;
}
int nqueen_2d(int er , int ec ,int qpsf , int qloc , string ans){
    if(qpsf==)
}
int main(){
    vector<bool> arr(7,false);
    cout<<nqueen_combi_target(7,3,0,0,"");
//   cout<<nqueen_permu01(arr, 7,3,0,"");


    return 0;
}