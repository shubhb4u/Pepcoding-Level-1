import java.util.*;

class TreeNode {
    
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val; }
      TreeNode() {}
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    
    public List<Integer> TreeNode(TreeNode root) {
    
          ArrayList<Integer> ans = new ArrayList<>();
          while(root != null){
              
              //root can be visited only once -
              if (root.left == null){
                  ans.add(root.val);
                  root = root.right;
              }
              else{ // Check if first or second visit -
                  TreeNode rootp1 = root.left;
                  
                  // find the rightmost node first -
                  while(rootp1.right != null && rootp1.right != root){
                      rootp1 = rootp1.right;
                  }
                  
                  //First visiting the node -
                  if (rootp1.right == null){
                      ans.add(root.val);
                      rootp1.right = root; // Connection
                      root = root.left;
                  }
                  //Second visiting the node -
                  else if (rootp1.right == root){
                      rootp1.right = null; // disconnect the connection
                      root = root.right;
                  }
                  
              }
        }
          return ans;
    }
}
