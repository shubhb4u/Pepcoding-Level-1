package BinaryTree;
import java.io.*;
import java.util.*;

public class Cameras {
    
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    
    static int count;
    
    public int minCameraCover(TreeNode root) {
        
        count = 0;
        int res = status(root);
        //If there is just one TreeNode given it will pass -1.
        if(res == -1){
            return count+1;
        }
        return count;
    }
    
    public int status(TreeNode root) {
        
        if (root == null){
            return 1;
        }
        int lc = status(root.left);
        int rc = status(root.right);
        
        if (lc == -1 || rc == -1){
            count++;
            return 0;
        }
        else if(lc == 0 || rc == 0){
            return 1;
        }
        else{
            return -1;
        }
    }
}
