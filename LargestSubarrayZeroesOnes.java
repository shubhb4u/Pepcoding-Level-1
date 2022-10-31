import java.util.*;

public class LargestSubarrayZeroesOnes {
    
    public static int solution(int[] arr) {
        // write your code here
        int maxlen = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        map.put(0,-1);
        int ratio = 0;
        for (int i = 0 ; i < arr.length; i++){
            int len = 0;
            
            if (arr[i] == 1) ratio++;
            else ratio--;
            if(map.containsKey(ratio)){
                len = i-map.get(ratio);
            }
            else{
                map.put(ratio,i);
            }
            maxlen = Math.max(len,maxlen);
        }
        
        return maxlen;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}
