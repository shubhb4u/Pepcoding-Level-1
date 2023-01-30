package LeetCode;

import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;

class MinSubsetDiff {
    
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
    
    
    public static boolean subsetSum(int[] arr, int range, boolean[][] t){
    
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                
                if(i == 0) t[i][j] = false;
                if(j == 0) t[i][j] = true;
            }
        }
    
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                
                if (arr[i-1] <= range){
                    t[i][j] = (t[i][j-arr[i-1]] || t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[arr.length][range];
        
    }
    
    public static int minimumDifference(int[] nums) {
       
        int range = 0;
        for(int val : nums){
            range+= val;
        }
        boolean[][] t = new boolean[nums.length+1][range+1];
        subsetSum(nums,range, t);
        
        ArrayList<Integer> lastRow = new ArrayList<>();
        for (int i = t.length, j = 0 ; j < (t[0].length)/2; j++){
            if(t[i][j] == true) {
                lastRow.add(j);
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int val : lastRow){
            min = Math.min(Math.abs(range-2*val), min);
        }
        return min;
    }
    
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
//        int k = scn.nextInt();
        
        int[] nums = new int[n];
        for (int i = 0; i < n ; i++){
            nums[i] = scn.nextInt();
        }
        
        int ans = minimumDifference(nums);
        System.out.println(ans);
     
    }
}

