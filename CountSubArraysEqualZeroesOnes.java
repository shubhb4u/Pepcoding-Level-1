import java.util.*;
import java.util.HashMap;

public class CountSubArraysEqualZeroesOnes {
    
    
    public static int solution(int[] arr) {
        // write your code here
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int ratio = 0;
        int count = 0;
        map.put(0,1);

        for (int i = 0 ; i<arr.length ; i++){
        
            if (arr[i] == 0){
                ratio--;
                if (map.containsKey(ratio)){
                    count += map.getOrDefault(ratio,0);
                }
                map.put(ratio,map.getOrDefault(ratio,0)+1);
            }
            else{
                ratio++;
                if (map.containsKey(ratio)){
                    count += map.getOrDefault(ratio,0);
                }
                map.put(ratio,map.getOrDefault(ratio,0)+1);
            }
        }
        
        return count;
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
