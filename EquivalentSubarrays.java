import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;

public class EquivalentSubarrays {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        //write your code here
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0 ; i< arr.length ; i++){
            set.add(arr[i]);
        }
        
        int i = 0, j = 0, count = 0;
        boolean flag = true;
        while (j < arr.length){
            
            if (map.size() != set.size()){
                map.put(arr[j], map.getOrDefault(arr[j],0)+1);
                j++;
                flag = false;
            }
            else{
                count += arr.length-j+1;
                if (map.get(arr[i])==1){
                    map.remove(arr[i]);
                }else{
                    map.put(arr[i],map.get(arr[i])-1);
                }
                flag = false;
                i++;
            }
            if (flag == true) break;
            
        }
        System.out.println(count);
    }
}