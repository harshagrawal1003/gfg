class Solution {
    int ans = 1;

    void dfs(Node root, int len) {
        if (root == null) return;

        ans = Math.max(ans, len);

        if (root.left != null) {
            if (root.left.data == root.data + 1)
                dfs(root.left, len + 1);
            else
                dfs(root.left, 1);
        }

        if (root.right != null) {
            if (root.right.data == root.data + 1)
                dfs(root.right, len + 1);
            else
                dfs(root.right, 1);
        }
    }

    public int longestConsecutive(Node root) {
        if (root == null) return -1;

        dfs(root, 1);

        return ans == 1 ? -1 : ans;
    }
}