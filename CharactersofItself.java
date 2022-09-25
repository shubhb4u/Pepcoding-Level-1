import java.util.*;

public class CharactersofItself {
    
    public static int solution(String str){
        // write your code here
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
    
        for (int i = 0 ; i< str.length() ; i++){
            set.add(str.charAt(i));
        }
    
        int i = 0, j = 0, min = Integer.MAX_VALUE;
        boolean flag = true;
        while (j < str.length()){
        
            if (map.size() != set.size()){
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j),0)+1);
                j++;
                flag = false;
            }
            if(map.size() == set.size()){
                min = Math.min(min,j-i);
                int freq = map.get(str.charAt(i));
                if (freq == 1){
                    map.remove(str.charAt(i));
                }
                else{
                    map.put(str.charAt(i),freq-1);
                }
                flag = false;
                i++;
            }
            if (flag == true) break;
        }
        return min;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}
