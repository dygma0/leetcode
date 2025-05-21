class Solution {
    private int totalTime = 0;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        this.dfs(0, -1, adj, hasApple);

        return this.totalTime;
    }

    private boolean dfs(int currentNode, int parentNode, List<List<Integer>> adj, List<Boolean> hasApple) {
        boolean hasAppleInSubtreeFromChildren = false;

        for (int neighbor : adj.get(currentNode)) {
            if (neighbor == parentNode) {
                continue;
            }

            if (dfs(neighbor, currentNode, adj, hasApple)) {
                this.totalTime += 2;
                hasAppleInSubtreeFromChildren = true;
            }
        }

        return hasApple.get(currentNode) || hasAppleInSubtreeFromChildren;
    }
}
