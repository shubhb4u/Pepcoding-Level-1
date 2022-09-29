package BinaryTree;
import com.sun.source.tree.Tree;
import java.io.*;
import java.sql.Array;
import java.util.*;

import java.util.*;

public class Serialize {
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
 
    public class Codec {
    
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
        
            StringBuilder sb = new StringBuilder();
            serializeHelper(root,sb);
            return sb.toString();
        }
        
        public void serializeHelper(TreeNode root, StringBuilder sb){
    
            if (root == null){
                sb.append("null ");
                return;
            }
            
            sb.append(root.val+" ");
            serializeHelper(root.left,sb);
            serializeHelper(root.right,sb);
            
        }
        
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            
            String[] arr = data.split(" ");
            this.idx = 0;
            return deserializeHelper(arr);
        }
        
        static int idx = 0;
        private TreeNode deserializeHelper(String [] input){
            
            if (idx == input.length){
                return null;
            }
            if (input[idx].equals(null)){
                return null;
            }
            
            TreeNode node = new TreeNode(Integer.parseInt(input[idx]));
            
            idx++;
            node.left = deserializeHelper(input);
            idx++;
            node.right = deserializeHelper(input);
            return node;
    
        }
    }
}
