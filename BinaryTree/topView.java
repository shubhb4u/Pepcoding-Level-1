//package BinaryTree;
//
////{ Driver Code Starts
//import java.util.LinkedList;
//import java.util.Queue;
//import java.io.*;
//import java.util.*;
//
//class Node{
//    int data;
//    Node left;
//    Node right;
//    Node(int data){
//        this.data = data;
//        left=null;
//        right=null;
//    }
//}
//
//class GfG {
//
//    static Node buildTree(String str){
//
//        if(str.length()==0 || str.charAt(0)=='N'){
//            return null;
//        }
//
//        String ip[] = str.split(" ");
//        // Create the root of the tree
//        Node root = new Node(Integer.parseInt(ip[0]));
//        // Push the root to the queue
//
//        Queue<Node> queue = new LinkedList<>();
//
//        queue.add(root);
//        // Starting from the second element
//
//        int i = 1;
//        while(queue.size()>0 && i < ip.length) {
//
//            // Get and remove the front of the queue
//            Node currNode = queue.peek();
//            queue.remove();
//
//            // Get the current node's value from the string
//            String currVal = ip[i];
//
//            // If the left child is not null
//            if(!currVal.equals("N")) {
//
//                // Create the left child for the current node
//                currNode.left = new Node(Integer.parseInt(currVal));
//                // Push it to the queue
//                queue.add(currNode.left);
//            }
//
//            // For the right child
//            i++;
//            if(i >= ip.length)
//                break;
//
//            currVal = ip[i];
//
//            // If the right child is not null
//            if(!currVal.equals("N")) {
//
//                // Create the right child for the current node
//                currNode.right = new Node(Integer.parseInt(currVal));
//
//                // Push it to the queue
//                queue.add(currNode.right);
//            }
//            i++;
//        }
//
//        return root;
//    }
//    static void printInorder(Node root)
//    {
//        if(root == null)
//            return;
//
//        printInorder(root.left);
//        System.out.print(root.data+" ");
//
//        printInorder(root.right);
//    }
//
//    public static void main (String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int t=Integer.parseInt(br.readLine());
//
//        while(t > 0){
//            String s = br.readLine();
//            Node root = buildTree(s);
//            Tree g = new Tree();
//            ArrayList<Integer> result = g.leftView(root);
//            for(int value : result){
//                System.out.print(value + " ");
//            }
//            System.out.println();
//            t--;
//        }
//    }
//}
//
//// } Driver Code Ends
//
//
////User function Template for Java
//
//// A Binary Tree node
//
//
//class Tree
//{
//    //Function to return list containing elements of left view of binary tree.
//    ArrayList<Integer> leftView(Node root)
//    {
//        // Your code here
//        ArrayList<Integer> ans = new ArrayList<>();
//        Queue<Node> q = new ArrayDeque<>();
//        q.add(root);
//
//        while(q.size() > 0){
//
//            Node rem = q.remove();
//            ans.add(rem.data);
//            if (root.left != null){
//                q.add(root.left);
//            }
//        }
//        return ans;
//    }
//}
//
//class Pair{
//
//    Node node;
//    int level;
//
//    Pair(Node node, int Pair){
//
//        this.node = node;
//        this.level = level;
//    }
//}
//
//public class topView {
//
//    static ArrayList<Integer> topView(Node root)
//    {
//        ArrayList<Integer> ans = new ArrayList<>();
//        Queue<Pair> mq = new ArrayDeque<>();
//        mq.add(new Pair(root,0));
//        HashMap<Integer,Integer> map = new HashMap<>();
//        int minLevel = 0, maxLevel = 0;
//
//        while (mq.size() > 0){
//
//            Pair rem = mq.remove();
//            if (!map.containsKey(rem.level)){
//                map.put(rem.level,rem.node.data);
//            }
//            minLevel = Math.min(minLevel, rem.level);
//            maxLevel = Math.max(maxLevel, rem.level);
//
//            if (rem.node.left != null){
//                mq.add(new Pair(rem.node.left,rem.level-1));
//            }
//            if (rem.node.right != null){
//                mq.add(new Pair(rem.node.right,rem.level+1));
//            }
//        }
//
//        while(minLevel <= maxLevel){
//            ans.add(map.get(minLevel));
//            minLevel++;
//        }
//        return ans;
//    }
//}
