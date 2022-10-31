import java.util.HashMap;
import java.util.*;

public class CountSubEqualToK {
    
    public int subarraySum(int[] nums, int k) {
    
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(sum,count);
    
        for (int i = 0 ; i< nums.length; i++){
            sum += nums[i];
            if (map.containsKey(sum-k)) {
                count++;
                map.put(sum, count);
            }
            else{
                map.put(sum,1);
            }
        }
        return count;
    }
}
