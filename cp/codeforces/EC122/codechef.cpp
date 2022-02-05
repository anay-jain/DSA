#include<bits/stdc++.h>
using namespace std;
bool cmp(pair<char, int>& a,
         pair<char, int>& b)
{
    return a.second > b.second;
}
  
// Function to sort the map according
// to value in a (key-value) pairs
void sort(unordered_map<char, int>& M)
{
    string s;
    // Declare vector of pairs
    vector<pair<char, int> > A;
  
    // Copy key-value pair from Map
    // to vector of pairs
    for (auto& it : M) {
        A.push_back(it);
    }
  
    // Sort using comparator function
    sort(A.begin(), A.end(), cmp);
  
    // Print the sorted value
  for (auto& it : A) {
      for(int j=0;j<it.second;j++){
          s = s + it.first;
    
      }
        
    }
    int n = s.size();
    reverse(s.begin() + n / 2, s.end());
    cout<<s<<endl;
}
void solve(){
int n ;
cin>>n;
string s ;
cin>>s;
if(n%2!=0){
    cout<<"NO"<<endl;
    return;
}


unordered_map<char,int>umap;
int count_max=0;
for(int i =0;i<s.size();i++){
    char c= s[i];
    if (umap.find(c) == umap.end())
    umap[c] = 1;
    else
    umap[c] = umap[c]+1;
    count_max = max(count_max, umap[c]);


}
if(count_max>n/2){
    cout<<"NO"<<endl;

}
else{
cout<<"YES"<<endl;
// string s;
// int flag=0;
// int all =n;
// while(all>0){
//   unordered_map<char, int>:: iterator itr;
    
//     for (itr = umap.begin(); itr != umap.end(); itr++)
//     {
//         // itr works as a pointer to pair<string, double>
//         // type itr->first stores the key part  and
//         // itr->second stores the value part
//         char c =  itr->first;
//         if(itr->second >0){
//         if(flag==0){
//             s = s+c;
//             flag=1;
//         }else{
//             s= c+s;
//             flag=0;
//         }
//         itr->second = itr->second-1;
//        all--;
//         }
//      }
     
// }
// cout<<s<<endl;
sort(umap);
}
    
}

int main(){
    int t=1;
    cin>>t;
    while(t-->0)
    solve();

    return 0;
}