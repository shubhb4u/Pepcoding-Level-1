import java.io.*;
import java.util.*;

class pairDivisibleByK {
    
    public static boolean solution(int[] arr, int k){
        //write your code here
        
        //Save remainders and their count in a hashmap -
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i< arr.length ; i++){
            int rem = arr[i]%k;
            if (rem < 0) rem = rem+k;
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        
        for (int val : arr){
            
            int rem  = val%k;
            if (rem < 0) rem = rem+k;
            
            if (rem == 0 || 2*rem == k){
                int fq = map.get(rem);
                if (fq%2 == 1) return false;
            }
            else{
                int fq = map.get(rem);
                int ofq = map.getOrDefault(k-rem,0);
                if (fq != ofq) return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr,k));
    }
    
}
