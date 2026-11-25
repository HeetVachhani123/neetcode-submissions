class DSU {
    private int[] Parent;
    private int[] Size;

    public DSU(int n) {
        Parent = new int[n + 1];
        Size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            Parent[i] = i;
            Size[i] = 1;
        }
    }

    public int find(int node) {
        if (Parent[node] != node) {
            Parent[node] = find(Parent[node]);
        }
        return Parent[node];
    }

    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) {
            return false;
        }
        if (Size[pu] < Size[pv]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        Size[pu] += Size[pv];
        Parent[pv] = pu;
        return true;
    }
}

public class Solution {
    public int minimumEffortPath(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        List<int[]> edges = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (r + 1 < ROWS) {
                    edges.add(new int[]{Math.abs(heights[r][c] - heights[r + 1][c]), r * COLS + c, (r + 1) * COLS + c});
                }
                if (c + 1 < COLS) {
                    edges.add(new int[]{Math.abs(heights[r][c] - heights[r][c + 1]), r * COLS + c, r * COLS + c + 1});
                }
            }
        }

        edges.sort(Comparator.comparingInt(a -> a[0]));
        DSU dsu = new DSU(ROWS * COLS);
        for (int[] edge : edges) {
            int weight = edge[0], u = edge[1], v = edge[2];
            dsu.union(u, v);
            if (dsu.find(0) == dsu.find(ROWS * COLS - 1)) {
                return weight;
            }
        }
        return 0;
    }
}