#include<iostream>
#include<vector>
#include<list>
using namespace std;
class edge{
    public:
    int v ;
    int wt;
    edge(int v , int wt){
        this->v=v;
        this->wt=wt;
    }
    edge(){

    }
};
vector<vector<edge *>> graph;
void addedge(int u , int v , int wt){
    graph[u].push_back(new edge(v,wt));
}
void display(){
    for(int i=0;i<graph.size();i++){
        cout<<i<<" ";
        for(int j=0;j<graph[i].size();j++){
            cout<<graph[i][j]->v<<" "<<graph[i][j]->wt;
        }
        cout<<endl;
    }
}
// void topologicalseries(int src , vector<bool> isvisited){
    
 
        
// }
void khanalgo(){
    vector<int> inedge(graph.size(),0);
    for(int i=0;i<graph.size();i++){
        for(int j =0;j<graph[i].size();j++){
               int nbr = graph[i][j]->v;
                inedge[nbr]++;
        }
    }
  
    list<edge *> que;
// when on heap then (new edge(2,2))
// when on array then(edge(2,2))
    for(int i =0;i<graph.size();i++){
        if(inedge[i]==0){
            que.push_back(new edge(inedge[i],1));   
        }
    }
    int count=0;
    while(!que.empty()){
        edge* rpair = que.front();
        que.pop_front();
        for(int i =0;i<graph[rpair->v].size();i++){
            int nbr =graph[rpair->v][i]->v;
            inedge[nbr]--;
            if(inedge[nbr]==0)
            {
                que.push_back(new edge(nbr,1));
                count++;
                cout<<nbr;
            }
            

        }  }
        if(count != que.size()-1){
            cout<<"cant";
        }
          

    
}
int main(){
    for(int i=0;i<7;i++){
        vector<edge *> ar ;
        graph.push_back(ar);
    }
    // addedge(0, 1, 10);
    // addedge(1, 2, 10);
    // addedge(2, 3, 40);
    // addedge(0, 3, 10);
    // addedge(3, 4, 2);
    // addedge(4, 5, 2);
    // addedge(5, 6, 8);
    // addedge(4, 6, 3);
         addedge(0, 3, 1);
    addedge(0, 2, 1);
    addedge(1, 2, 1);
    addedge(1, 5, 1);
    addedge(3, 4, 1);
    addedge(4, 6, 1);
    addedge(5, 6, 1);
    vector<bool> isvisited(graph.size(),false);
    // display();
    khanalgo();
   return 0;}