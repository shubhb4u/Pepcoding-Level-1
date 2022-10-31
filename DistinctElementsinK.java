import java.util.*;

public class DistinctElementsinK {
    
    public static ArrayList<Integer> solution(int[] arr, int k) {
        //write your code here
    
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0,j = 0 ; j < k; j++){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
        }
        ans.add(map.size());
        
        for (int l = 0, m = k ; m < arr.length ; l++,m++){
            map.put(arr[m], map.getOrDefault(arr[m],0)+1);
            if (map.getOrDefault(arr[l],0) == 1) map.remove(arr[l]);
            else {
                map.put(arr[l], map.getOrDefault(arr[l],0)-1);
            }
            ans.add(map.size());
        }
    
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        ArrayList<Integer> ans = solution(arr,k);
        for(int a : ans){
            System.out.print(a + " ");
        }
    }
}


