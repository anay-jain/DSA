#include<iostream>
#include<vector>
#include<bits/stdc++.h>
using namespace std;

int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        queue<int> q;
           int count =0;
        vector<bool> isVisited(n,false);
        for(int t =0;t<isVisited.size();t++){
         
       if(isVisited[t]){
           
           q.push(t);
            count++;
       }
        while(!q.empty()){
            int size = q.size();

            while(size-->0){
                int pop = q.front();
                q.pop();
                isVisited[pop] = true;
                for(int i =0;i<isConnected[pop].size();i++){
                    if(isConnected[pop][i]==1 && isVisited[i]==false)q.push(i);
                }

            }
        }
        }
        return count;

        
}

int main(){
    queue<int> q ;
    q.push(0);
    q.push(1);
    cout<<q.size()--;

    return 0;
}