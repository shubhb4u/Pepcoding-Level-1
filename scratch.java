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

import static java.util.stream.Collectors.*;


class newClass {
    
    public static int solution(int [] A) {
        
        int minDifference = Integer.MAX_VALUE;
        ArrayList<Integer> sides =  new ArrayList<>(); // To store potential sides
        HashMap<Integer,Integer> map = new HashMap<>(); // To check the count of potential sides
        
        if (A.length<4) {
            return -1;
        }
        else{
            
            for (int i = 0; i<A.length ; i++){
                map.put(A[i], map.getOrDefault(A[i],0)+1);
            }
            
            
            int count = 0; // To check if we have min 4 values to form a rectangle
            for (int val : map.keySet()){
                if (map.get(val)>=2){
                    sides.add(val); //Add the potential rectangle sides to our arraylist.
                    count++;
                }
            }
            
            Collections.sort(sides);
            if (sides.size() >=2) {
                minDifference = sides.get(sides.size() - 1) - sides.get(sides.size() - 2);
                return minDifference;
            }else{
                if (map.size() == 1){
                    minDifference = 0;
                }
            }
            
        }
        return minDifference;
    }
        public static void main(String[] args) {
    
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int [] arr= new int[n];
            for (int i = 0 ;i < n ;i++){
                arr[i] = scn.nextInt();
            }
            System.out.println(solution(arr));
        }
}