class Solution {
    public int shortestPath(int V, int src, int dest, int[][] edges) {
        // code here
        
        int extra = 0;
        for (int[] e : edges) {
            if (e[2] == 2) extra++;
        }

        int totalNodes = V + extra;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < totalNodes; i++) {
            graph.add(new ArrayList<>());
        }

        int newNode = V;

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            if (w == 1) {
                graph.get(u).add(v);
                graph.get(v).add(u);
            } else {
                graph.get(u).add(newNode);
                graph.get(newNode).add(u);

                graph.get(newNode).add(v);
                graph.get(v).add(newNode);

                newNode++;
            }
        }

        int[] dist = new int[totalNodes];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        dist[src] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int nei : graph.get(node)) {
                if (dist[nei] == -1) {
                    dist[nei] = dist[node] + 1;
                    q.offer(nei);
                }
            }
        }

        return dist[dest];
    }
}