import java.util.*;

public class LasrgestSubZeroesOnes {
    
    public static int solution(int[] arr) {
        // write your code here
        HashMap<String,Integer> map = new HashMap<>();
        map.put("0#0",-1);
        int maxlen = Integer.MIN_VALUE;
        int n0 = 0, n2 = 0, n1 = 0;
        for (int i = 0 ; i < arr.length; i++){
            
            if (arr[i] == 0){
                n0++;
            }
            else if (arr[i] == 1){
                n1++;
            }
            else{
                n2++;
            }
            int d1 = n1-n0;
            int d2 = n2-n1;
            if (map.containsKey("d1#d2")){
                maxlen = Math.max(maxlen,i-map.get("d1#d2"));
            }
            else {
                map.put("d1#d2", i);
            }
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
