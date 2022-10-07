package BinaryTree;

//{ Driver Code Starts
import java.sql.Array;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
//class Node
//{
//    int data;
//    Node left, right;
//
//    Node(int item)
//    {
//        data = item;
//        left = right = null;
//    }
//}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
            
            // Get the current node's value from the string
            String currVal = ip[i];
            
            // If the left child is not null
            if(!currVal.equals("N")) {
                
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
            
            // For the right child
            i++;
            if(i >= ip.length)
                break;
            
            currVal = ip[i];
            
            // If the right child is not null
            if(!currVal.equals("N")) {
                
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
        
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Tree g = new Tree();
            ArrayList<Integer> result = g.leftView(root);
            for(int value : result){
                System.out.print(value + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// A Binary Tree node


class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        
        while(q.size() > 0){
            
            Node rem = q.remove();
            ans.add(rem.data);
            if (root.left != null){
                q.add(root.left);
            }
        }
        return ans;
    }
}
public class leftView {
    
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        Queue<Node> mq = new ArrayDeque<>();
        Queue<Node> hq = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(root.data);
        mq.add(root);
        
        while (mq.size() > 0){
            
            Node rem = mq.remove();
            if (rem.left != null){
                hq.add(rem.left);
            }
            if (rem.right != null){
                hq.add(rem.right);
            }
            if (mq.size() == 0){
                if (hq.size()>0){
                    ans.add(hq.peek().data);
                    mq = hq;
                    hq = new ArrayDeque<>();
                }
            }
        }
        return ans;
    }
}
