import java.io.*;
import java.util.*;

class pairDivisibleByK {
    
    public static void solution(int[] arr, int k){
        //write your code here
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < arr.length ; i++){
            
            int rem = arr[i]%k;
            if (rem < 0) rem = rem+k;
            int freq = map.getOrDefault(rem , 0);
            map.put(rem , freq+1);
        }
        
        for (int val : arr){
            int rem = val%k;
            if (rem < 0) {
                rem = rem + k;
            }
            
            if (rem == 0 || (2*rem == k)){
                int fq = map.get(rem);
                if (fq%2 == 1){
                    System.out.println(false);
                    return;
                }
            }
            else{
                int fq = map.get(rem);
                int ofq = map.get(k-rem);
                if (fq != ofq){
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
        
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        solution(arr,k);
    }
    
}
