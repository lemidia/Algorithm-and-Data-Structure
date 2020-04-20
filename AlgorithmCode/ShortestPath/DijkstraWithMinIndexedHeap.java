package ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class DijkstraWithMinIndexedHeap {
    static int n, m;
    static int dist[];
    static int check[];
    static Integer prev[];
    static ArrayList<Edge> adjecentGraph[];

    static void dijkstra(int s, int e){ // Single Source Shortest Path (SSSP)
        dist = new int[n+1];
        check = new int[n+1];

        MinIndexedDHeap<Integer> ipq = new MinIndexedDHeap<>(n);
        ipq.insert(s, 0);

        Arrays.fill(dist, Integer.MAX_VALUE); // Init all the destination
        dist[s] = 0;                          // Init that start is 0
        while (!ipq.isEmpty()){
            int cur = ipq.peekMinKeyIndex();
            int curCost = ipq.pollMinValue();
            // If minCost in the priority queue is greater than
            // current cost then skip.
            // This means that stale outdated node is skipped
            if (dist[cur] < curCost) continue;
            check[cur] = 1; // Visited cur node
            for (Edge nx : adjecentGraph[cur]){
                if (check[nx.to] == 1) // if nx node already has been visited
                    continue;
                int newDist = curCost + nx.cost;
                if (dist[nx.to] > newDist){ // If newDist is less than dist of cur's next dist
                    dist[nx.to] = newDist;  // Edge relaxation
                    prev[nx.to] = cur; // path

                    if (!ipq.contains(nx.to))
                        ipq.insert(nx.to, newDist);
                    else
                        ipq.decrease(nx.to, newDist);
                }
            }
            if (cur == e)
                return;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        prev = new Integer[n+1];
        adjecentGraph = new ArrayList[n+1];
        // Init Graph
        for (int i = 0; i < n+1; i++)
            adjecentGraph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            adjecentGraph[Integer.parseInt(st.nextToken())].add(new Edge(
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
            ));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dijkstra(s, e); // Operate Dijkstra Algorithm
        System.out.print(dist[e]);

        /* Path Print
        System.out.println();
        for (Integer i = e; i != null ; i = prev[i]) {
            sb.append(i).append(">-"); // i.e 1 -> 2 -> 3 ... 5
        }
        System.out.print(sb.reverse().delete(0, 2));
        */
    }

    static class Edge{ // Edge information
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    private static class MinIndexedDHeap<T extends Comparable<T>> {

        // Current number of elements in the heap.
        private int sz;

        // Maximum number of elements in the heap.
        private final int N;

        // The degree of every node in the heap.
        // private final int D;

        // Lookup arrays to track the child/parent indexes of each node.
        private final int[] child, parent;

        // The Position Map (pm) maps Key Indexes (ki) to where the position of that
        // key is represented in the priority queue in the domain [0, sz).
        public final int[] pm;

        // The Inverse Map (im) stores the indexes of the keys in the range
        // [0, sz) which make up the priority queue. It should be noted that
        // 'im' and 'pm' are inverses of each other, so: pm[im[i]] = im[pm[i]] = i
        public final int[] im;

        // The values associated with the keys. It is very important  to note
        // that this array is indexed by the key indexes (aka 'ki').
        public final Object[] values;

        public MinIndexedDHeap(int maxSize) {
            if (maxSize <= 0) throw new IllegalArgumentException("maxSize <= 0");

            N = max(2 + 1, maxSize);

            im = new int[N];
            pm = new int[N];
            child = new int[N];
            parent = new int[N];
            values = new Object[N];

            for (int i = 0; i < N; i++) {
                parent[i] = (i - 1) / 2;
                child[i] = i * 2 + 1;
                pm[i] = im[i] = -1;
            }
        }

        public int size() {
            return sz;
        }

        public boolean isEmpty() {
            return sz == 0;
        }

        public boolean contains(int ki) {
            keyInBoundsOrThrow(ki);
            return pm[ki] != -1;
        }

        public int peekMinKeyIndex() {
            isNotEmptyOrThrow();
            return im[0];
        }

        public int pollMinKeyIndex() {
            int minki = peekMinKeyIndex();
            delete(minki);
            return minki;
        }

        @SuppressWarnings("unchecked")
        public T peekMinValue() {
            isNotEmptyOrThrow();
            return (T) values[im[0]];
        }

        public T pollMinValue() {
            T minValue = peekMinValue();
            delete(peekMinKeyIndex());
            return minValue;
        }

        public void insert(int ki, T value) {
            if (contains(ki)) throw new IllegalArgumentException("index already exists; received: " + ki);
            valueNotNullOrThrow(value);
            pm[ki] = sz;
            im[sz] = ki;
            values[ki] = value;
            swim(sz++);
        }

        @SuppressWarnings("unchecked")
        public T valueOf(int ki) {
            keyExistsOrThrow(ki);
            return (T) values[ki];
        }

        @SuppressWarnings("unchecked")
        public T delete(int ki) {
            keyExistsOrThrow(ki);
            final int i = pm[ki];
            swap(i, --sz);
            sink(i);
            swim(i);
            T value = (T) values[ki];
            values[ki] = null;
            pm[ki] = -1;
            im[sz] = -1;
            return value;
        }

        @SuppressWarnings("unchecked")
        public T update(int ki, T value) {
            keyExistsAndValueNotNullOrThrow(ki, value);
            final int i = pm[ki];
            T oldValue = (T) values[ki];
            values[ki] = value;
            sink(i);
            swim(i);
            return oldValue;
        }

        // Strictly decreases the value associated with 'ki' to 'value'
        public void decrease(int ki, T value) {
            keyExistsAndValueNotNullOrThrow(ki, value);
            if (less(value, values[ki])) {
                values[ki] = value;
                swim(pm[ki]);
            }
        }

        // Strictly increases the value associated with 'ki' to 'value'
        public void increase(int ki, T value) {
            keyExistsAndValueNotNullOrThrow(ki, value);
            if (less(values[ki], value)) {
                values[ki] = value;
                sink(pm[ki]);
            }
        }

        /* Helper functions */

        private void sink(int i) {
            for (int j = minChild(i); j != -1; ) {
                swap(i, j);
                i = j;
                j = minChild(i);
            }
        }

        private void swim(int i) {
            while (less(i, parent[i])) {
                swap(i, parent[i]);
                i = parent[i];
            }
        }

        // From the parent node at index i find the minimum child below it
        private int minChild(int i) {
            int index = -1, from = child[i], to = min(sz, from + 2);
            for (int j = from; j < to; j++) if (less(j, i)) index = i = j;
            return index;
        }

        private void swap(int i, int j) {
            pm[im[j]] = i;
            pm[im[i]] = j;
            int tmp = im[i];
            im[i] = im[j];
            im[j] = tmp;
        }

        // Tests if the value of node i < node j
        @SuppressWarnings("unchecked")
        private boolean less(int i, int j) {
            return ((Comparable<? super T>) values[im[i]]).compareTo((T) values[im[j]]) < 0;
        }

        @SuppressWarnings("unchecked")
        private boolean less(Object obj1, Object obj2) {
            return ((Comparable<? super T>) obj1).compareTo((T) obj2) < 0;
        }

        @Override
        public String toString() {
            List<Integer> lst = new ArrayList<>(sz);
            for (int i = 0; i < sz; i++) lst.add(im[i]);
            return lst.toString();
        }

        /* Helper functions to make the code more readable. */

        private void isNotEmptyOrThrow() {
            if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        }

        private void keyExistsAndValueNotNullOrThrow(int ki, Object value) {
            keyExistsOrThrow(ki);
            valueNotNullOrThrow(value);
        }

        private void keyExistsOrThrow(int ki) {
            if (!contains(ki)) throw new NoSuchElementException("Index does not exist; received: " + ki);
        }

        private void valueNotNullOrThrow(Object value) {
            if (value == null) throw new IllegalArgumentException("value cannot be null");
        }

        private void keyInBoundsOrThrow(int ki) {
            if (ki < 0 || ki >= N)
                throw new IllegalArgumentException("Key index out of bounds; received: " + ki);
        }
    }
}
