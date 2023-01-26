package BinaryTree;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

class Main {
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            ConstructBSTfromLOT obj = new ConstructBSTfromLOT();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
    }
    
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}

  class Pair{
    Node par = null;
    int lb = -(int)1e9;
    int rb = (int)1e9;
    
    Pair(Node par, int lb , int rb){
        this.par = par;
        this.lb = lb;
        this.rb = rb;
    }
    
    Pair(){
    
    }
}

public class ConstructBSTfromLOT {
    
    //Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] arr)
    {
        
        LinkedList<Pair> que = new LinkedList<>();
        que.add(new Pair());
        int idx = 0;
        Node root = null;
        
        while(que.size()>0 && idx < arr.length){
            
            Pair rem = que.removeFirst();
            int ele = arr[idx];
            if (ele < rem.lb || ele > rem.rb) continue;
            
            Node node = new Node(ele);
            if(rem.par == null) root = node;
            else{
                Node par = rem.par;
                if (ele < par.data){
                    par.left = node;
                }
                else{
                    par.right = node;
                }
            }
            que.addLast(new Pair(node,rem.lb,ele));
            que.addLast(new Pair(node,ele,rem.rb));
        }
        return root;
    }
}
