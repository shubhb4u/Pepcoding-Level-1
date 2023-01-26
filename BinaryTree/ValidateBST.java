//package BinaryTree;
//import java.util.Scanner;
//import java.util.*;
//import java.io.*;
//import java.lang.*;
//
//
//// Uncomment this part when running -----------***************     ***** * * * ** ______
//
////class Node {
////    int data;
////    Node left;
////    Node right;
////
////    Node(int data) {
////        this.data = data;
////        left = null;
////        right = null;
////    }
////}
//
//class GfG {
//
//    static Node buildTree(String str) {
//
//        if (str.length() == 0 || str.charAt(0) == 'N') {
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
//        while (queue.size() > 0 && i < ip.length) {
//
//            // Get and remove the front of the queue
//            Node currNode = queue.peek();
//            queue.remove();
//
//            // Get the current node's value from the string
//            String currVal = ip[i];
//
//            // If the left child is not null
//            if (!currVal.equals("N")) {
//
//                // Create the left child for the current node
//                currNode.left = new Node(Integer.parseInt(currVal));
//                // Push it to the queue
//                queue.add(currNode.left);
//            }
//
//            // For the right child
//            i++;
//            if (i >= ip.length)
//                break;
//
//            currVal = ip[i];
//
//            // If the right child is not null
//            if (!currVal.equals("N")) {
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
//
//    static void printInorder(Node root) {
//        if (root == null)
//            return;
//
//        printInorder(root.left);
//        System.out.print(root.data + " ");
//
//        printInorder(root.right);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int t = Integer.parseInt(br.readLine());
//
//        while (t > 0) {
//            String s = br.readLine();
//            int target = Integer.parseInt(br.readLine());
//            Node root = buildTree(s);
//
//            ValidateBST g = new ValidateBST();
////            System.out.println(g.minTime(root, target));
//            t--;
//
//        }
//    }
//}
//
//class BSTPair{
//    boolean isBst;
//    long min;
//    long max;
//}
//class Solution {
//    public boolean isValidBST(TreeNode root) {
//
//        BSTPair ans  = isBST(root);
//        if (ans.isBst)
//            return true;
//        else return false;
//    }
//
//    public static BSTPair isBST(TreeNode root){
//
//        if (root == null){
//            BSTPair base = new BSTPair();
//            base.min = Long.MAX_VALUE;
//            base.max = Long.MIN_VALUE;
//            base.isBst = true;
//            return base;
//        }
//        BSTPair lc = isBST(root.left);
//        BSTPair rc = isBST(root.right);
//        BSTPair mp = new BSTPair();
//        mp.isBst = (lc.isBst && rc.isBst) && root.val >= lc.max && root.val <= rc.min;
//        mp.min = Math.min(root.val, Math.min(lc.min,rc.min));
//        mp.max = Math.max(root.val, Math.max(lc.max,rc.max));
//        return mp;
//    }
//}
