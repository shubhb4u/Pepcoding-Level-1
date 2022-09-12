import java.util.*;
import java.util.HashMap;


public class LargestSubArrayDivisibleByK {
        
    
        public static int solution(int[] arr, int k) {
            // write your code here
    
            HashMap<Integer,Integer> map = new HashMap<>();
    
            int sum = 0;
            int rem = 0;
            int idx = -1;
            int mlen = 0;
            map.put(rem,idx);
    
            for (int i = 0 ; i < arr.length ; i++){
        
                sum += arr[i];
                rem = sum%k;
                rem  = (rem < 0) ? rem + k : rem;
                if (map.containsKey(rem)){
            
                    int len = i - map.get(rem);
                    if (len > mlen) mlen = len;
                }
                else{
                    map.put(rem, i);
                }
            }
    
            return mlen;
        }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }
}
