## Algorithm

In mathematics and computer science, an algorithm is a finite sequence of well-defined, computer-implementable instructions, typically to solve a class of problems or to perform a computation. Algorithms are always unambiguous and are used as specifications for performing calculations, data processing, automated reasoning, and other tasks. - Wikipedia.

수학과 컴퓨터 과학에서, 알고리즘은 일반적으로 어떤 집합의 문제를 풀기 위하거나 계산을 수행하기 위해, 잘 정의된 한 유한순서이자, 컴퓨터가 실행할 수 있는 지시사항들 입니다. 알고리즘은 항상 모호하지 않고, 계산이나 데이터 처리, 자동 추론 등등 여러곳에서의 명세로 사용됩니다.


### DFS & BFS - 깊이우선탐색 & 너비우선탐색
- [DFS - Recursion manner](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/DFSRecursion.java) - O(V+E)
- [BFS - Using Queue](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/BreadthFirstSearch.java) - O(V+E)

### Binary Search - 이분탐색 
- [Binary Search - Iterative manner](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/BinarySearch.java) - O(logn)
- [Binary Search - Recursive manner](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/BinarySearchRecursive.java) - O(logn)

### Back Tracking - 백트래킹
- [Permutation](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/StringPermutation.java) - O(n!)
- [Power Set Problem](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/PowerSet.java) - O(2^n)
- N Queen
- Sudoku

### Tree Algorithm - 트리 알고리즘
- [Pre Order, In Order, Post Order - 전위 순회, 중위 순회, 후위 순회](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/DataStructure/BinaryTree.java)
- [Center of Tree](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/CenterOfTree.java) - 트리의 중심
- Sum of leaf - 잎 노드들의 합


### Shortest Path - 최단거리 알고리즘
- [Dijkstra Algorithm - Priority Queue(Binary Heap)](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/ShortestPath/DijkstraAlgorithm.java) -  Binary Heap 적용 O(E(logV)
- [Dijkstra Algorithm - Min Indexed Heap](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/ShortestPath/DijkstraWithMinIndexedHeap.java) - Indexed Priority Queue 적용 O(V(logV)
- [Floyd Washall Algorithm - All Pair Shortest Path](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/ShortestPath/FloydWarshallSolver.java) - 모든 쌍 최단경로 O(v^3)
- [SPFA - Shortest Path Faster Algorithm](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/ShortestPath/ShortestPathFasterAlgorithm.java) - O(E) on Average. Not proved.
- [Bellman Ford - Adjacency List](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/ShortestPath/BellmanFordAdjacencyList.java) - O(VE)
- [Bellman Ford - Edge List](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/ShortestPath/BellmanFordEdgeList.java) - O(VE)
- [Shortest Path On DAG Using TopSort](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/ShortestPath/ShortestPathOnDAG.java) - 위상정렬 적용 후 위상순서에 따라 변 경감 연산 수행 O(V+E)

### Sorting - 정렬
- [Quick sort](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Sorting/QuickSort.java) - Worst case: O(n^2), Average case: O(nlogn) where n is the number of item in an array
- [Merge sort](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/mergesort.java) - O(nlogn)
- [Counting sort](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Sorting/CountingSort.java) - O(kn) where k is upper bound
- [Selection sort](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Sorting/SelectionSort.java) - O(n^2)
- [Bubble sort](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Sorting/BubbleSort.java) - O(n^2)
- [Insertion sort](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Sorting/InsertionSort.java) - O(n^2)
- Heap sort - Worst case: O(n^2)

### Topological Sort - 위상정렬
- [Topological Sort - Using In Degree](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/TopologicalSort.java) - Using In Degree, O(V+E)
- [Topological Sort - Using DFS](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/TopologicalSortUsingDFS.java) - Using DFS, O(V+E)

### Dynamic Programming - 동적 프로그래밍
- [Fibonacci - Bottom up Manner](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Fibonacci.java)
- Fibonacci - Top down Manner(Recursive + Memoization)
- [Maximum Sum Sub array(Kadene's Algorithm)](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/MaximumSumSubArray.java) - O(n)
- Coin Change - 동전교환
- [0,1 Knapsack - 0, 1 배낭 문제](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Knapsack_01.java)
- [Unbounded Knapsack - 물건 수량 제한 없는 배낭 문제]
- [LCS(Longest Common Subsequence)](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/LCS.java) - 최장 공통 부분순서(Compare with 3 Strings), Bottom Up Manner O(n^3)
- [LIS(Longest Increasing Subsequence)](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/LongestIncreasingSubSequence.java) - 최장 증가 부분순서, Bottom Up Manner O(n^2)
- Edit Distance - 편집거리
- [격자 경로 문제](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/HowManyPaths.java)
- Matrix Multiplication
- [Stair Case Problem](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Upstair.java)

### Prime - 소수
- [Sieve Of Eratosthenes](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Eratosthenes.java) - 에라토스테네스의 체

### GCD, LCM - 최대공약수, 최소공배수
- [GCD] - 최대공약수
- [LCM] - 최소공배수

### Permutation & Combination - 순열과 조합
- [Permutation](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Permutation.java) - 순열 nPr
- [Combination](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Combination.java) - 조합 nCr

### Minimum Spanning Tree Algorithm - 최소 신장 트리 알고리즘 
- [Kruskal's Algorithm](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/KruskalAlgorithm.cpp)
- Prim's Algorithm

### Network Flow - 네트워크 유량
- [Ford-Fulkerson method](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/FordFulkersonMethod.java)
- [Edmonds Karp](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/EdmondsKarp.java) - Ford Fullkerson method + BFS 탐색 적용
- [Max Flow Min Cost](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/MinCostMaxFlow.java) - SPFA 적용

### Bipartite Matching - 이분매칭
- [Bipartite Matching] - DFS Manner

### Strongly Conneted Component - 강한 연결 요소
- Tarjan's Algorithm
- [Kosaraju's Algorithm](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/SCC_Kosaraju.java)

### Cut Edge and Articulation Point - 단절선과 단절점
- [Cut Edge](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/CutEdge.java) - O(V+E)
- [Articulation Point](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/ArticulationPoint.java) - O(V+E)

### LCA - 최소 공통 조상 (Euler Tour + Sparse Table(RMQ))
- [LCA - Euler Tour + Sparse Table(RMQ)](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/LowestCommonAncestor.java) Euler Tour = O(n), Construction of Sparse Table = O(nlogn), LCA Query = O(1), Total = O(nlogn)

### String Pattern Matching - 문자열 패턴 매칭
- [KMP Pattern Matching Algorithm](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/KMP.java) - KMP(Knuth, Morris, Pratt) 패턴 매칭 알고리즘, O(n+m) - n is pattern matching and m is lps construction
- Boyer moore algorithm - Bad Character Rule
- Rabin karp algorithm

## Data structure
In computer science, a data structure is a data organization, management, and storage format that enables efficient access and modification. More precisely, a data structure is a collection of data values, the relationships among them, and the functions or operations that can be applied to the data. - Wikipedia

### Queue - 큐
- [Implementation - Using LinkedList](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/DataStructure/Queue.java)
### Stack - 스택
- [Implementation - Using LinkedList](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/DataStructure/Stack.java)
### Linked List - 연결 리스트
- [Linked List](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/DataStructure/LinkedList.java)
### Graph - 그래프
- [Implementation](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/DataStructure/Graph.java)
### Set - 집합 (중복된 원소를 허용하지 않는 자료구조)
- [Implementation]()
### Priority Queue / Heap - 우선순위 큐 / 힙
- [Implementation - Binary Heap](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/DataStructure/BinaryHeap.java)
### Indexed Priority Queue / Indexed Heap - 인덱스 우선순위 큐 / 인덱스 힙
- [Implementation] 
### Dynamic Array - 동적 배열
- [Implementation](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/DataStructure/DynamicArray.java)
### Disjoint Set - Union Find by Rank with Path Compression - 서로소 집합
- [Implementation](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/DataStructure/UnionFind.java)
### Tree - 트리
- [Implementation](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/DataStructure/BinaryTree.java)
### Binary Search Tree - 이진탐색트리
- [Implementation](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/DataStructure/BinarySearchTree.java)
### Segment Tree - 세그먼트 트리
- [Segment Tree - Range Sum Query](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/DataStructure/SegmentTree.java) - Construction : O(n), Update: O(logn), Min Query : O(logn)
- [Segment Tree - Range Minimum Query](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/DataStructure/SegmentTreeMin.java) - Construction : O(n), Update: O(logn), Min Query : O(logn)
### Fenwick Tree or Binary Indexed Tree - 펜윅트리
- [Fenwick Tree](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/DataStructure/FenwickTree.java) - Range Sum Query - Construction : O(n), Update: O(logn), Sum Query : O(logn)
### Sparse Table
- [Sparse Table - Range Minimum Query](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/DataStructure/SparseTable.java) - Construction : O(nlogn), Min Query : O(1)
### Trie or Prefix Tree - 트라이, 접두사 트리
- [Implementation](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/DataStructure/TrieTree.java)
### Bit Manipulation - 비트 조작
- [Use Case](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/DataStructure/BitManipulation.java)

