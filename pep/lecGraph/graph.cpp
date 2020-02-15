#include<iostream>
#include<vector>
using namespace std;
class Edge{
    public:
    int v;
    int wt;
    Edge(int v , int wt){
        this->v=v;
        this->wt=wt;
    }
};
const int graphSize =7;
vector<Edge *> graph[graphSize];
void addEdge(int u , int v , int wt){
    graph[u].push_back(new Edge(v,wt));
    graph[v].push_back(new Edge(u,wt));
}
void display(){
    for(int i=0;i<graphSize;i++){
        cout<<i<<" -> ";
        for(Edge* e : graph[i]){
            cout<<"("<<e->v<<" , "<<e->wt<<")";
        }
        cout<<endl;
    }
}
int hamiltonianPath(int src , int des ,vector<bool> &vis  , int count ,  int OrigSrc){
    if(src==des){
    
    }

    vis[src]=true;

}
void createGraph(){
    addEdge(0, 1, 10);
    addEdge(1, 2, 10);
    addEdge(2, 3, 40);
    addEdge(0, 3, 10);
    addEdge(3, 4, 2);
    addEdge(4, 5, 2);
    addEdge(5, 6, 8);
    addEdge(4, 6, 3);
}
int main(){
    createGraph();
    // display();


}