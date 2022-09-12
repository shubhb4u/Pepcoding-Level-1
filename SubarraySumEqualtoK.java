import java.util.*;

public class SubarraySumEqualtoK {
    
    public static int solution(int[] arr, int k) {
        // write your code here
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        int freq = 1;
        map.put(sum,freq);
        
        for (int i = 0 ; i < arr.length ; i++){
            
            sum+= arr[i];
            if (map.containsKey(sum-k)){
                
                count++;
                map.put(sum, sum-k);
            }
            else{
                map.put(sum, 1);
            }
        }
    
        System.out.println(map);
        
        return count;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr,k));
        
    }
    
}