import java.util.HashMap;
import java.util.*;

public class LargestSubArraySumZero {
    
    public static int solution(int[] arr) {
        // write your code here
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int idx = -1;
        int mlen = 0;
        map.put(sum,idx);
        
        for (int i = 0 ; i< arr.length; i++){
            sum += arr[i];
            if (map.containsKey(sum)) {
                mlen = Math.max(mlen,i-map.get(sum));
            }
            else{
                map.put(sum, i);
            }
        }
        return mlen;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}
