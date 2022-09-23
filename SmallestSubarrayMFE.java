import java.util.*;

public class SmallestSubarrayMFE {
    
    public static void solution(int[] arr) {
        // write your code here
    
        HashMap<Integer, Integer> fMap = new HashMap<>();
        HashMap<Integer, Integer> sMap = new HashMap<>();
    
        int hfreq = 0;
        int ele = arr[0];
        int sp = 0;
        int ep = 0;
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
    
            if (fMap.containsKey(arr[i])) {
                fMap.put(arr[i], fMap.get(arr[i]) + 1);
            } else {
                fMap.put(arr[i], 1);
                sMap.put(arr[i], i);
            }
    
            if (fMap.get(arr[i]) > hfreq) {
                ele = arr[i];
                hfreq = fMap.get(arr[i]);
                len = i - fMap.get(arr[i]) + 1;
                ep = i;
            } else if (fMap.get(arr[i]) == hfreq) {
                int clen = i - sMap.get(arr[i]) + 1;
                if (clen < len) {
                    ele = arr[i];
                    hfreq = fMap.get(arr[i]);
                    len = i - fMap.get(arr[i]) + 1;
                    ep = i;
                }
            }
        }
    
        System.out.println(ele);
        System.out.println(sMap.get(ele));
        System.out.println(ep);
    }
    
        public static void main (String[]args){
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }
            solution(arr);
        }
    
    }
