#include<iostream>
#include<vector>
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

    display();
  
    return 0;
}