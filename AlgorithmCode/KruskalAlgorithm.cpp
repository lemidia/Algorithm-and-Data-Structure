#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>
using namespace std;
const int MAX = 1e4 + 5;
int id[MAX], ranks[MAX], nodes, edges;

// Edge array : weight, (u, v)
pair <long long, pair<int, int> > p[MAX];

// Make set initialization
void init()
{
    for(int i = 0;i < MAX;++i) {
        id[i] = i;
        ranks[i] = 0;
    }
}

// Find with path compression
int root(int x)
{
    if (id[x] == x)
        return x;
    else
        // Recursion
        return id[x] = root(id[x]);
}

// union by rank
void union1(int x, int y)
{
    int p = root(x);
    int q = root(y);

    if (p == q) // 루트가 같다면 수행하지 않는다.
        return;

    // p의 랭크가 q의 랭크보다 크다면
    if (ranks[p] >= ranks[q]) {
        // q가 p의 밑으로 되게 합친다.
        id[q] = id[p];
    } else { // 위의 if문 과 반대
        id[p] = id[q];
    }
    // 두 트리의 랭크가 같다면, 랭크를 1만큼 키운다.
    if (ranks[p] == ranks[q])
        ranks[p]+=1;
}

// Find MST
long long kruskal(pair<long long, pair<int, int> > p[])
{
    int x, y;
    int cnt = 0;
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
            cnt++;
        }
        if (nodes-1 == cnt)
            break;
    }
    return minimumCost;
}

int main()
{
    int x, y;
    long long weight, minimumCost;
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