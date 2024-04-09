import java.util.*;

public class Graphs {
    public static void main(String[] args) {
        // adjacencyMatrix(5, 6);
        // adjacencyList(5, 6);

        // BFS of Graph
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // adj.add(new ArrayList<>());
        // adj.add(new ArrayList<>());
        // adj.add(new ArrayList<>());
        // adj.add(new ArrayList<>());
        // adj.add(new ArrayList<>());

        // adj.get(0).add(1);
        // adj.get(0).add(2);
        // adj.get(0).add(3);
        // adj.get(2).add(4);

        // ArrayList<Integer> ans = bfsOfGraph(5, adj);
        // for (Integer i : ans) {
        // System.out.print(i + " ");
        // }
        // System.out.println();

        // DFS of Graph
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // adj.add(new ArrayList<>(List.of(2, 3, 1)));
        // adj.add(new ArrayList<>(List.of(0)));
        // adj.add(new ArrayList<>(List.of(0, 4)));
        // adj.add(new ArrayList<>(List.of(0)));
        // adj.add(new ArrayList<>(List.of(2)));
        // ArrayList<Integer> ans = dfsOfGraph(5, adj);
        // for (Integer i : ans) {
        // System.out.print(i + " ");
        // }
        // System.out.println();

        // No of provinces
        // ArrayList<ArrayList<Integer>> adjacencyMatrix = new ArrayList<>(
        // Arrays.asList(
        // new ArrayList<>(Arrays.asList(1, 0, 1)),
        // new ArrayList<>(Arrays.asList(0, 1, 0)),
        // new ArrayList<>(Arrays.asList(1, 0, 1))));
        // System.out.println(numProvinces(adjacencyMatrix, 3));

        // No of islands
        // char[][] matrix = {
        // { '0', '1' },
        // { '1', '0' },
        // { '1', '1' },
        // { '1', '0' }
        // };
        // System.out.println(numIslands(matrix));

        // Topological Sort
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        // adj.add(new ArrayList<>(Arrays.asList(3)));
        // adj.add(new ArrayList<>(Arrays.asList(3)));
        // adj.add(new ArrayList<>());
        // int[] ans = topoSort(4, adj);
        // for (int i : ans) {
        // System.out.print(i + " ");
        // }

        // Flood Fill
        // int[][] image = {
        // { 1, 1, 1 },
        // { 1, 1, 0 },
        // { 1, 0, 1 }
        // };
        // int sr = 1;
        // int sc = 1;
        // int newColor = 2;
        // int[][] ans = floodFill(image, sr, sc, newColor);
        // for (int i = 0; i < ans.length; i++) {
        // for (int j = 0; j < ans[0].length; j++) {
        // System.out.print(ans[i][j] + " ");
        // }
        // System.out.println();
        // }

        // Nearest 1 in a matrix
        // int[][] grid = { { 0, 1, 1, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 } };
        // int[][] ans = nearest(grid);
        // for (int i = 0; i < ans.length; i++) {
        // for (int j = 0; j < ans[0].length; j++) {
        // System.out.print(ans[i][j] + " ");
        // }
        // System.out.println();
        // }

        // Rotting Oranges
    }

    public static void adjacencyMatrix(int N, int M) {
        // n represents the number of vertices/nodes
        // m represents the number of edges
        int[][] matrix = new int[N][N];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }
        sc.close();
        System.out.println("Adjacency Matrix: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void adjacencyList(int N, int M) {
        // n represents the number of vertices/nodes
        // m represents the number of edges

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            al.add(new ArrayList<>());
        }
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            al.get(u).add(v);
            al.get(v).add(u);
        }
        System.out.println("Adjacency List: ");

        for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < al.get(i).size(); j++) {
                System.out.print(al.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int temp = q.remove();
            ans.add(temp);
            for (Integer i : adj.get(temp)) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return ans;
    }

    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfs(adj, ans, visited, 0);
        return ans;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, boolean[] visited, int temp) {
        visited[temp] = true;
        ans.add(temp);
        for (Integer i : adj.get(temp)) {
            if (!visited[i]) {
                dfs(adj, ans, visited, i);
            }
        }
    }

    public static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int count = 0;
        boolean[] visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                helper(adj, visited, i);
                count++;
            }
        }
        return count;
    }

    public static void helper(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int temp) {
        Queue<Integer> q = new LinkedList<>();
        q.add(temp);
        visited[temp] = true;
        while (!q.isEmpty()) {
            int k = q.poll();
            k--;
            for (int i = 0; i < adj.get(k).size(); i++) {
                int val = adj.get(k).get(i);
                if (val == 1 && !visited[i + 1] && i != k) {
                    q.add(i + 1);
                    visited[i + 1] = true;
                }
            }
        }
    }

    public static class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int numIslands(char[][] grid) {

        int islands = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    helper(grid, visited, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public static void helper(char[][] grid, boolean[][] visited, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        visited[row][col] = true;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int rr = p.r;
            int cc = p.c;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nrow = rr + i;
                    int ncol = cc + j;
                    if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && !visited[nrow][ncol]
                            && grid[nrow][ncol] == '1') {
                        q.add(new Pair(nrow, ncol));
                        visited[nrow][ncol] = true;
                    }

                }
            }
        }
    }

    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] incomingEdges = new int[V];
        int[] ans = new int[V];
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                incomingEdges[adj.get(i).get(j)]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (incomingEdges[i] == 0)
                q.add(i);
        }

        int k = 0;
        while (!q.isEmpty()) {
            int temp = q.remove();
            ans[k++] = temp;
            for (int i = 0; i < adj.get(temp).size(); i++) {
                incomingEdges[adj.get(temp).get(i)]--;
                if (incomingEdges[adj.get(temp).get(i)] == 0)
                    q.add(adj.get(temp).get(i));
            }
        }
        return ans;
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int initColor = image[sr][sc];
        bfs(image, sr, sc, initColor, newColor);
        return image;

    }

    public static void bfs(int[][] image, int sr, int sc, int initColor, int newColor) {
        int m = image.length;
        int n = image[0].length;

        image[sr][sc] = newColor;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int rr = p.r;
            int cc = p.c;
            int row[] = { -1, 0, 1, 0 };
            int col[] = { 0, 1, 0, -1 };
            for (int i = 0; i < 4; i++) {
                int nrow = row[i] + rr;
                int ncol = col[i] + cc;
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && image[nrow][ncol] == initColor
                        && image[nrow][ncol] != newColor) {
                    image[nrow][ncol] = newColor;
                    q.add(new Pair(nrow, ncol));
                }
            }

        }
    }

    static class Pair1 {
        int row;
        int col;
        int dist;

        Pair1(int i, int j, int k) {
            row = i;
            col = j;
            dist = k;
        }
    }

    public static int[][] nearest(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<Pair1> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    q.add(new Pair1(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            Pair1 p = q.remove();
            int row = p.row;
            int col = p.col;
            int dist = p.dist;
            ans[row][col] = dist;
            int r1[] = { -1, 0, 1, 0 };
            int c1[] = { 0, 1, 0, -1 };
            for (int i = 0; i < 4; i++) {
                int nrow = r1[i] + row;
                int ncol = c1[i] + col;
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && !visited[nrow][ncol]) {

                    visited[nrow][ncol] = true;
                    q.add(new Pair1(nrow, ncol, dist + 1));
                }
            }
        }
        return ans;
    }

}
