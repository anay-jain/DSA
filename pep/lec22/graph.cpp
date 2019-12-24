#include<iostream>
#include<vector>
#include<list>
using namespace std;
class edge{
    public:
    int v;
    int wt;
    edge(int v , int wt){
        this->v=v;
        this->wt=wt;
    }
    edge(){
        // default constructor
    }
};
// graph declaration outside of main
vector<vector<edge *>> graph;
// add edge function
void addedge(int u , int v , int wt){
    if(u<0 || v<0 || u>graph.size() || v>graph.size())
    return;

    graph[u].push_back(new edge(v , wt));
    graph[v].push_back(new edge(u , wt));
}
void display(){
    for(int i =0;i<graph.size();i++){
        cout<<i<<"-> ";
        for(int j=0;j<graph[i].size();j++){
            int nbr = graph[i][j]->v;
            // -> its because we  have used heap and created edge on heap
            // . when created on stack
            cout<<graph[i][j]->v<<" @ "<<graph[i][j]->wt<<" , ";

        }
        cout<<endl;

    }
}
//=======bipartite graph=============================================================================
class partitepair{
    public:
    int node;
    int color;
        partitepair(int node , int color){
        this->node=node;
        this->color=color;
    }
    partitepair(){

    }
};
void bipartitegraph(int src,vector<int>& isvisited){
    // make a queue
    list<partitepair*> que;
    // add root
    // priority que will be type of partitite pair
    partitepair* root = new partitepair(src,0);
    que.push_back(root);
    while (!que.empty())
    {
        // partitepair* rpair = new partitepair(que.front()->node, que.front()->color);
        partitepair* rpair = que.front();
        que.pop_front();

        if(isvisited[rpair->node]!=-1   ){
            if(isvisited[rpair->node]==rpair->color){
                cout<<rpair->node<<" -> bipartite"<<endl;
            }
            else{
                cout<<rpair->node<<"-> not bipartite"<<endl;
            }
                 continue;
        }
        isvisited[rpair->node]=rpair->color;
        for(edge* e:graph[rpair->node]){
            if(isvisited[e->v]==-1){
                partitepair* nbr = new partitepair(e->v,(rpair->color+1)%2);
                que.push_back(nbr);
            }
        }

    }
    
}   

void solve(){

}
int main(){
    //need to intitalize the vector
    for(int i=0;i<7;i++){
        vector<edge *> ar;
        graph.push_back(ar);
    }
    addedge(0, 1, 10);
    addedge(1, 2, 10);
    addedge(2, 3, 40);
    addedge(0, 3, 10);
    addedge(3, 4, 2);
    addedge(4, 5, 2);
    addedge(5, 6, 8);
    addedge(4, 6, 3);

    // display();
    vector<int> isvisited(7,-1);
    bipartitegraph(0,isvisited);
    return 0;
}