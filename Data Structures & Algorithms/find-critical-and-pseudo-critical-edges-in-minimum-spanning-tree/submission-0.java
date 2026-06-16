
class Solution {
    // DSU structure helper class
    class UnionFind {
        int[] parent;
        int count;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
            count = n;
        }

        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }

        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                count--;
                return true;
            }
            return false;
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] newEdges = new int[m][4];
        
        for (int i = 0; i < m; i++) {
            newEdges[i][0] = edges[i][0];
            newEdges[i][1] = edges[i][1];
            newEdges[i][2] = edges[i][2];
            newEdges[i][3] = i; // Save original index
        }

        // Sort edges by weight
        Arrays.sort(newEdges, (a, b) -> Integer.compare(a[2], b[2]));

        // Step 1: Find standard MST weight
        int baseMstWeight = getMstWeight(n, newEdges, -1, -1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();

        // Step 2: Test each edge
        for (int i = 0; i < m; i++) {
            // Check if critical (by ignoring it)
            int weightWithoutEdge = getMstWeight(n, newEdges, i, -1);
            if (weightWithoutEdge > baseMstWeight) {
                critical.add(newEdges[i][3]);
            } else {
                // Check if pseudo-critical (by forcing it)
                int weightWithEdge = getMstWeight(n, newEdges, -1, i);
                if (weightWithEdge == baseMstWeight) {
                    pseudoCritical.add(newEdges[i][3]);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(critical);
        result.add(pseudoCritical);
        return result;
    }

    private int getMstWeight(int n, int[][] edges, int skipEdgeIdx, int forceEdgeIdx) {
        UnionFind uf = new UnionFind(n);
        int weight = 0;

        // If an edge needs to be forced, process it first
        if (forceEdgeIdx != -1) {
            uf.union(edges[forceEdgeIdx][0], edges[forceEdgeIdx][1]);
            weight += edges[forceEdgeIdx][2];
        }

        for (int i = 0; i < edges.length; i++) {
            if (i == skipEdgeIdx || i == forceEdgeIdx) continue;
            
            if (uf.union(edges[i][0], edges[i][1])) {
                weight += edges[i][2];
            }
        }

        // If the graph is not fully connected, return infinity / max value
        if (uf.count > 1) return Integer.MAX_VALUE;
        return weight;
    }
}