package BinaryTree;
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
        
        while(t-- > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Tree g = new Tree();
            ArrayList<Integer> diagonalNode = g.diagonal(root);
            for(int i = 0 ;i<diagonalNode.size();i++){
                System.out.print(diagonalNode.get(i)+ " ");
            }
            System.out.println();
        }
    }
}



// } Driver Code Ends


class Tree
{
    public class Pair{
        Node node;
        int idx;
        
        Pair(Node node, int idx){
            this.node = node;
            this.idx= idx;
        }
    }
    
    public int widthOfBinaryTree(Node root) {
        
        Queue<Pair> q= new ArrayDeque<>();
        q.add(new Pair(root,1));
        int maxWidth = 0;
        
        while (q.size() > 0){
            
            int s = q.size();
            int t = q.size();
            int first = 0, last = 0;
            
            while (s>0) {
                
                Pair rem = q.remove();
                int pid = rem.idx;
    
                if (s == t) first = pid;
                if (s == 1) last = pid;
    
                if (rem.node.left != null) {
                    q.add(new Pair(rem.node.left, pid*2));
                }
                if (rem.node.right != null) {
                    q.add(new Pair(rem.node.right, pid*2+1));
                }
            }
            
            maxWidth = Math.max(maxWidth,last-first+1);
        }
        return maxWidth;
    }
}
