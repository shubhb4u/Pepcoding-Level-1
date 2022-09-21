import java.util.*;

public class largestSubarrayContiguous {
    
    public static int solution(int[] arr) {
        // write your code here
        
        int maxLen = 0;
        for (int j = 0; j<arr.length-1 ; j++){
            
            HashSet<Integer> set = new HashSet<>();
            int min = arr[j];
            int max = arr[j];
            set.add(arr[j]); // How is the code affected if we donot add this ?? Try to debug -- because we are
            // missing this element evrytime in the set.
            
            for (int i = j+1 ; i<arr.length ; i++){
                
                set.add(arr[i]);
                max = Math.max(max,arr[i]);
                min = Math.min(min,arr[i]);
                
                if (set.size() == i-j+1){
                    if (max-min == i-j){
                        maxLen = Math.max(maxLen,i-j+1);
                    }
                }
                else{
                    j++;
                    break;
                }
            }
        }
        
        return maxLen;
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
