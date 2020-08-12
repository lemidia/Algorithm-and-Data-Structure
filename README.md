## Algorithm

In mathematics and computer science, an algorithm is a finite sequence of well-defined, computer-implementable instructions, typically to solve a class of problems or to perform a computation. Algorithms are always unambiguous and are used as specifications for performing calculations, data processing, automated reasoning, and other tasks. - Wikipedia.

수학과 컴퓨터 과학에서, 알고리즘은 일반적으로 어떤 집합의 문제를 풀기 위하거나 계산을 수행하기 위해, 잘 정의된 한 유한순서이자, 컴퓨터가 실행할 수 있는 지시사항들 입니다. 알고리즘은 항상 모호하지 않고, 계산이나 데이터 처리, 자동 추론 등등 여러곳에서의 명세로 사용됩니다.


### DFS & BFS - 깊이우선탐색 & 너비우선탐색
- [DFS - Recursion manner](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/DFSRecursion.java) - O(V+E) 

- [BFS - Using Queue](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/BreadthFirstSearch.java) - O(V+E) 

### Binary Search - 이분탐색 
- [Binary Search - Iterative manner](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/BinarySearch.java) - O(logn) 

- [Binary Search - Recursive manner](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/BinarySearchRecursive.java) - O(logn)

### Back Tracking + Brute Force - 백트래킹 + 전체탐색 다 해보기
- [Permutation](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/StringPermutation.java) - O(n!) 순열

- [Power Set Problem](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/PowerSet.java) - O(2^n) 모든 조합 나열

- [N Queen Problem](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/NQueen.java) - N x N 격자판에 N개의 퀸이 서로 공격하지 않으면서 놓아지게 하는 법 구하기

- [Rat In A Maze Problem](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/RatInAMaze.java) - 미로찾기 문제

- [Sudoku](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Sudoku.java) - 스도쿠, 숫자 퍼즐 문제

- [Sum Of Subset](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/SumOfSubset.java) - 집합에서의 원소들을 조합해서 특정 값을 만들 수 있는지? O(2^n)

### Tree Algorithm - 트리 알고리즘
- [Pre Order, In Order, Post Order](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/DataStructure/BinaryTree.java) - 전위 순회, 중위 순회, 후위 순회 | 기본적인 트리의 순회 방법

- [Center of a Binary Tree](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/CenterOfTree.java) - 트리의 중심(1개 또는 최대 2개가 될 수 있다.)

- [Height of a Binary Tree](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/HeightOfTree.java) - 트리의 높이(루트노드로 부터 가장 깊은 잎 노드로의 경로에서의 노드 개수)

- [Diameter of a Binary Tree](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/DiameterOfTree.java) - 트리의 지름(트리에서 가장 긴 경로의 노드 개수)

- [Sum of Nodes](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/TreeSum.java)  - 트리에서의 노드들의 합

- Sum of Leaf Nodes  - 잎 노드들의 합


### Shortest Path - 최단경로 알고리즘
- [Dijkstra Algorithm - Priority Queue(Binary Heap)](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/ShortestPath/DijkstraAlgorithm.java) -  Binary Heap 적용 O(E(logV)

- [Dijkstra Algorithm - Min Indexed Heap](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/ShortestPath/DijkstraWithMinIndexedHeap.java) - Indexed Priority Queue 적용 O(V(logV)

- [Floyd Washall Algorithm - All Pair Shortest Path](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/ShortestPath/FloydWarshallSolver.java) - 모든 쌍 최단경로 O(v^3)

- [SPFA - Shortest Path Faster Algorithm](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/ShortestPath/ShortestPathFasterAlgorithm.java) - O(E) on Average. Not proved. [해당 알고리즘 블로그 글 보기](https://lemidia.github.io/algorithm/SPFA/)

- [Bellman Ford - Adjacency List](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/ShortestPath/BellmanFordAdjacencyList.java) - O(VE)

- [Bellman Ford - Edge List](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/ShortestPath/BellmanFordEdgeList.java) - O(VE)

- [Shortest Path On DAG Using TopSort](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/ShortestPath/ShortestPathOnDAG.java) - 위상정렬 적용 후 위상순서에 따라 변 경감 연산 수행 O(V+E)

- [Shortest Path On A Graph Using BFS](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/ShortestPath/ShortestPathOnAllSameWeightedGraph.java) - 그래프에서 모든 Edge의 가중치가 같은 상황에서의 최단경로 O(V+E)

### Sorting - 정렬
- [Quick sort](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Sorting/QuickSort.java) - 빠른정렬, Worst case: O(n^2), Average case: O(nlogn) where n is the number of item in an array

- [Merge sort](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Sorting/MergeSort.java) - 병합정렬 O(nlogn), Worst case: O(nlogn) where n is the number of item in an array

- [Counting sort](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Sorting/CountingSort.java) - 카운팅 소트, 계수정렬, O(kn) where k is upper bound number, n is the # of items in an array

- [Selection sort](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Sorting/SelectionSort.java) - 선택정렬 Worst case: O(n^2)

- [Bubble sort](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Sorting/BubbleSort.java) - 버블소트 Worst case: O(n^2)

- [Insertion sort](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Sorting/InsertionSort.java) - 삽입정렬 Worst case: O(n^2)

- [Heap sort](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Sorting/HeapSort.java) - 힙 정렬 Worst case: O(nlogn)

- [Radix sort](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Sorting/RadixSort.java) - 기수 정렬, Time Complexity: O(nw) n = 정렬될 키의 개수, w = 정렬될 키 중에서 가장 큰 자릿수

- [Bucket sort](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Sorting/BucketSort.java) - 버킷 소트

### Topological Sort - 위상정렬
- [Topological Sort - Using In Degree](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/TopologicalSort.java) - Using In Degree, O(V+E)

- [Topological Sort - Using DFS](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/TopologicalSortUsingDFS.java) - Using DFS, O(V+E)

### Dynamic Programming - 동적 프로그래밍 (잘 알려진 문제들)
- [Fibonacci - Bottom up Manner](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Fibonacci.java) - n번째 피보나치 수열 구하기(반복적 방법), Iterative

- [Fibonacci - Top Down Manner](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Fibonacci_Recursion.java) - n번째 피보나치 수열 구하기(재귀적 방법), Recursive + Memoization

- [Maximum Sum Sub array(Kadene's Algorithm)](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/MaximumSumSubArray.java) - 배열에서의 연속된 부분배열의 최대 합, O(n)

- [Coin Change Problem 1](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/CoinChange_MinNumberOfCoins.java) - 주어진 종류의 코인으로 특정 금액을 만드는데 드는 가능한 최소의 동전 수 (동전의 개수는 무한)

- [Coin Change Problem 2](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/CoinChange_TheNumberOfWays.java) - 주어진 종류의 코인으로 특정 금액을 만들 수 있는 경우의 수(조합의 수) (동전의 개수는 무한)

- [0 1 Knapsack](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Knapsack_01.java) - 물건의 수량이 최대 1개인 배낭 문제

- [Unbounded Knapsack](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/KnapsackUnbounded.java) - 물건의 수량이 제한 없는 배낭 문제

- [LCS(Longest Common Subsequence)](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/LCS.java) - 최장 공통 부분 순서(Compare with 3 Strings), Bottom Up Manner O(n^3)

- [LCS(Longest Common Substring)](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/LongestCommonSubstring.java) - 최장 공통 부분 문자열(Compare with 2 Strings), Bottom Up Manner O(n^2)

- [LIS(Longest Increasing Subsequence)](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/LongestIncreasingSubSequence.java) - 최장 증가 부분순서, Bottom Up Manner O(n^2)

- [Maximum Sub Square Matrix of 1](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/MaximumSubSquareMatrix.java) - 1로 이루어진 가장 큰 정사각형 부분 행렬 구하기

- [격자 경로 문제](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/HowManyPaths.java)

- [Stair Case Problem](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Upstair.java) N번 계단 까지 올라가는 방법의 수

- [Tiling Dominoes](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/TilingDominoes.java) - 타일링 문제, e.g 2 x N or 3 x N and so on 

- [Edit Distance](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/EditDistance.java) - 편집거리

- [Longest Palindrome Subsequence](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/LongestPalindromeSubsequence.java) - 최장 팰린드롬 부분순서

- [Josephus Problem](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/JosephusProblem.java) - 조세퍼스 문제

### Dynamic Programming - 동적 프로그래밍 (추가)

- [Mountain Scenes](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Scenes.java) - Problem Link : [Click Here](https://open.kattis.com/problems/scenes)

- [Magical Cows](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/MagicalCows.java) - Problem Link : [Click Here](https://open.kattis.com/problems/magicalcows)

- [Tiling Dominos](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/TilingDominoes.java) - Problem Link : [Click Here](https://open.kattis.com/problems/tritiling)

### Prime - 소수
- [Sieve Of Eratosthenes](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Eratosthenes.java) - 에라토스테네스의 체

### GCD, LCM - 최대공약수, 최소공배수
- [GCD](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/GCD.java) - 최대공약수

- [LCM](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/LCM.java) - 최소공배수

### Permutation & Combination - 순열과 조합
- [Permutation](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Permutation.java) - 순열 nPr, 순서화

- [Permutation Using Swap](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/PermutationSwap.java) - 순열 nPn, 비순서화

- [Combination](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/Combination.java) - 조합 nCr

- [Combination With Repetition](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/CombinationWithRepetition.java) - 중복 조합

### Minimum Spanning Tree Algorithm - 최소 신장 트리 알고리즘 
- [Kruskal's Algorithm](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/KruskalAlgorithm.cpp) - 가능한 가중치가 가장 작은 간선으로 시작해 N-1개의 간선을 선택하는 Greedy Algorithm

- Prim's Algorithm

### Network Flow - 네트워크 유량
- [Ford-Fulkerson method](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/FordFulkersonMethod.java) - 최대유량 알고리즘

- [Edmonds Karp Algorithm](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/EdmondsKarp.java) - 최대유량 알고리즘, Ford Fulkerson method에서의 탐색방법을 BFS로 적용

- [Min Cost Max Flow](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/MinCostMaxFlow.java) - 최소비용 최대유량 알고리즘, 최소비용에는 SPFA Algorithm, 최대비용에는 Edmonds Karp Algorithm 적용

### Bipartite Matching - 이분매칭
- Bipartite Matching - DFS Manner

### Strongly Connected Component - 강한 연결 요소
- [Tarjan's Algorithm](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/TarjanScc.java) - O(V+E)

- [Kosaraju's Algorithm](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/SCC_Kosaraju.java) - O(V+E)

### Cut Edge and Articulation Point - 단절선과 단절점
- [Cut Edge](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/CutEdge.java) - O(V+E)

- [Articulation Point](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/ArticulationPoint.java) - O(V+E)

### Cycle Detection Algorithm in a graph - 그래프에서의 사이클 탐지

- [Cycle Detection in a Directed Graph](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/CycleDetectionOnDirectedGraph.java) - 방향 그래프에서의 사이클 탐지, DFS 사용 - O(V+E)

- [Cycle Detection in an UnDirected Graph](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/CycleDetectionOnUndirectedGraph.java) - 비방향 그래프에서의 사이클 탐지, 유니온 파인드 사용 - O(V+E)

### LCA - 최소 공통 조상 
- [LCA - Euler Tour + Sparse Table(RMQ)](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/LowestCommonAncestor.java) Euler Tour = O(n), Construction of Sparse Table = O(nlogn), LCA Query = O(1)

- [LCA - Naive Approach](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/LCA_Naive.java) LCA Query = O(n)

### String Pattern Matching - 문자열 패턴 매칭
- [KMP Pattern Matching Algorithm](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/KMP.java) - KMP(Knuth, Morris, Pratt) 패턴 매칭 알고리즘, O(n+m) where n is pattern matching and m is LPS construction (LPS : Longest Proper Prefix which is also Suffix)

- [Boyer Moore Algorithm](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/BoyerMoore.java) - Using Bad Character Rule

- Rabin Karp Algorithm

### Other Algorithm

- [Count Inversions In An Array](https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/AlgorithmCode/CountInversionsInAnArray.java) - 인덱스 위치가 i < j 이면서 A[i] > A[j]인 원소들을 역전관계라고 한다. 역전관계의 원소들이 해당 배열안에 몇개나 있는지 찾는 알고리즘. 머지소트를 이용한다. O(nlogn), Naive Approach : O(n^2)

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

