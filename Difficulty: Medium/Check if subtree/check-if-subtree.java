/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
class Solution {
     boolean isIdentical(Node a, Node b) {

        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.data != b.data) {
            return false;
        }

        return isIdentical(a.left, b.left) &&
               isIdentical(a.right, b.right);
    }

    public boolean isSubTree(Node rootT, Node rootS) {

        if (rootS == null) {
            return true;
        }

        if (rootT == null) {
            return false;
        }

        if (isIdentical(rootT, rootS)) {
            return true;
        }

        return isSubTree(rootT.left, rootS) ||
               isSubTree(rootT.right, rootS);
    }
}