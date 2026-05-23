/* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/
class Solution {
    public void toSumTree(Node root) {
        // code here
             convert(root);
    }
    
    private int convert(Node node) {
        if (node == null) return 0;
        
        int leftSum = convert(node.left);
        int rightSum = convert(node.right);
        
        int oldValue = node.data;
        
        node.data = leftSum + rightSum;
        
        return oldValue + node.data;
    }
}