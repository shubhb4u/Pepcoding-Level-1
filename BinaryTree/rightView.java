package BinaryTree;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class rightView {
    
    public void preorder(TreeNode root, int level , ArrayList<Integer> ans){
        
        if (root == null) return;
        if (ans.size() == level) ans.add(root.val);
        preorder(root.right, level+1,ans);
        preorder(root.left, level+1,ans);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
     
     ArrayList<Integer> ans  = new ArrayList<>();
     preorder(root, 0, ans);
//     Deque<TreeNode> mq= new ArrayDeque<>();
//     Deque<TreeNode> hq= new ArrayDeque<>();
//
//     if(root == null) return ans;
//     ans.add(root.val);
//     mq.add(root);
//
//     while (mq.size() > 0){
//
//      TreeNode rem = mq.remove();
//      if (rem.left != null){
//         hq.add(rem.left);
//      }
//      if (rem.right != null){
//         hq.add(rem.right);
//      }
//      if (mq.size() == 0){
//         if (hq.size()>0){
//            ans.add(hq.getLast().val);
//            mq = hq;
//            hq = new ArrayDeque<>();
//         }
//        }
//     }
     
     
     return ans;
     
    }
}

