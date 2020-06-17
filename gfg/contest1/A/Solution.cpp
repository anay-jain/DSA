#include <bits/stdc++.h> 
  
using namespace std; 
  

bool compare(pair<int, int> p1, pair<int, int> p2) 
{ 

    if (p1.second == p2.second) 
        return p1.first > p2.first; 
   
    return p1.second > p2.second;     
} 
 
void print_N_mostFrequentNumber(int arr[], int n, int k) 
{ 
    unordered_map<int, int> um; 
    for (int i = 0; i<n; i++) 
        um[arr[i]]++; 
          
       
    vector<pair<int, int> > freq_arr(um.begin(), um.end()); 
      
  
    sort(freq_arr.begin(), freq_arr.end(), compare); 
      

    cout << k << " numbers with most occurrences are:\n"; 
    for (int i = 0; i<k; i++) 
        cout << freq_arr[i].first << " "; 
} 
int main(){
    int n ;
    cin>>n;
    int k;
    cin>>k;
    
}