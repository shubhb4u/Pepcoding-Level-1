import java.util.*;

public class DistinctElementsinK {
    
    public static ArrayList<Integer> solution(int[] arr, int k) {
        //write your code here
    
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
    
        for (int i = 0; i < k; i++) {
            int freq = map.getOrDefault(arr[i], 0) + 1;
            map.put(arr[i], freq);
        }
        ans.add(map.size());
    
        int i = k;
        for (int j = 0; j < arr.length - k; j++) {
    
            //Acquire -
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            
            //Release -
            int freq = map.get(arr[j]);
            if (freq == 1) {
                map.remove(arr[j]);
            }
            else {
                map.put(arr[j], freq - 1);
            }
            ans.add(map.size());
            i++;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        ArrayList<Integer> ans = solution(arr,k);
        for(int a : ans){
            System.out.print(a + " ");
        }
    }
}


