package LeetCode;

import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    
    static class Pair implements Comparable<Pair>{
        int[] arr;
        int val;
        
        public Pair(int[] arr, int val) {
            this.arr = arr;
            this.val = val;
        }
        
        public int compareTo(Pair o){
            return o.val- this.val;
        }
    }
    
    public static int minCost(int[] nums, int k) {
    
        int i = 0, j = 0;
        while(j < nums.length){
            int l = i;
            
            int[] sub1 = new int[j-l+1];
            int[] sub2 = new int[nums.length-j-2];
            
            while(l <= j){
                sub1[l] = nums[l];
                l++;
            }
            while(j < nums.length-2){
                sub2[j+1] = nums[j+1];
                l++;
            }
    
            for(int val : sub1){
                System.out.println(val);
            }
            System.out.println();
            
            for(int val : sub2){
                System.out.println(val);
            }
        }
        
        return 0;
    }
    
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
//        int m = scn.nextInt();
        int k = scn.nextInt();
        
        int[] nums = new int[n];
        for (int i = 0; i < n ; i++){
            nums[i] = scn.nextInt();
        }
        int ans = minCost(nums,k);
        
//        int[][] score = new int[n][m];
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                score[i][j] = scn.nextInt();
//            }
//        }
        
//        int[][] ans = sortTheStudents(score, k);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(ans+" ");
//            }
//            System.out.println();
//        }
    }
}

