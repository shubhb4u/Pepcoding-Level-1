import javax.xml.transform.Result;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class newClass {
    
    public static void main(String[] args) {
    
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        System.out.println(vowelsubstring(s));
    }
    
    public static int vowelsubstring(String s) {
        
        //write your code here
        HashMap<Character, Integer> map = new HashMap<>();
        int k = 5;
        
        int i = 0, j = 0, count = 0;
        boolean flag = true;
        
        while(j<s.length()){
            //Acquire -
            char ch = s.charAt(j);
            if ((ch != 'a') || (ch != 'e') || (ch != 'i') || (ch != 'o') || (ch != 'u')){
                map.clear();
                i = j+1;
                j = j+1;
                flag = false;
                continue;
            }
            if (map.size() != k){
                map.put(ch,map.getOrDefault(ch,0)+1);
                flag = false;
                j++;
            }
            if(map.size() == k) {
                count ++;
                int freq = map.get(ch);
                if (freq == 1){
                    map.remove(ch);
                }
                else{
                    map.put(ch, freq - 1);
                }
                flag = false;
                i++;
            }
            if (flag == true) break;
        }
        return count;
    }
}
