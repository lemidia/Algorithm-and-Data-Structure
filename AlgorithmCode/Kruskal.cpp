#include <iostream>  
#include <vector>  
#include <utility>  
#include <algorithm>  
using namespace std;  
const int MAX = 1e4 + 5;  
int id[MAX], nodes, edges;  
pair <long long, pair<int, int> > p[MAX];  
   
// Make set
void init()  
{  
    for(int i = 0;i < MAX;++i)  
        id[i] = i;  
}  

// Find with path compression
int root(int x)  
{  
    if (id[x] == x)
        return x;
    else
        return id[x] = root(id[x]); 
}  
   
// union   
void union1(int x, int y)  
{  
    int p = root(x);  
    int q = root(y);  
    id[p] = id[q];  
}  
   
long long kruskal(pair<long long, pair<int, int> > p[])  
{  
    int x, y;  
    long long cost, minimumCost = 0;  
    for(int i = 0; i < edges; ++i)  
    {  
        x = p[i].second.first;  
        y = p[i].second.second;  
        cost = p[i].first;  
        if(root(x) != root(y))  
        {  
            minimumCost += cost;  
            union1(x, y);  
        }      
    }  
    return minimumCost;  
}  
   
int main()  
{  
    int x, y;  
    long long weight, cost, minimumCost;  
    init();  
    cout <<"Enter Nodes and edges";  
    cin >> nodes >> edges;  
    for(int i = 0;i < edges;++i)  
    {  
        cout<<"Enter the value of X, Y and edges";  
        cin >> x >> y >> weight;  
        p[i] = make_pair(weight, make_pair(x, y));  
    }  
    sort(p, p + edges);  
    minimumCost = kruskal(p);  
    cout <<"Minimum cost is "<< minimumCost << endl;
    return 0;
}  