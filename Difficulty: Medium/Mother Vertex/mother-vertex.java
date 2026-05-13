class Solution {
    public int findMotherVertex(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }

        boolean[] vis = new boolean[V];
        int candidate = -1;

        for (int i = 0; i < V; i++) {

            if (!vis[i]) {

                dfs(i, adj, vis);

                candidate = i;
            }
        }
        vis = new boolean[V];

        dfs(candidate, adj, vis);

        for (int i = 0; i < V; i++) {

            if (!vis[i]) {
                return -1;
            }
        }

        return candidate;
    }
      void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {

        vis[node] = true;

        for (int nei : adj.get(node)) {

            if (!vis[nei]) {
                dfs(nei, adj, vis);
            }
        }
    }
}