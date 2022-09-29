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
    
    public static void main(String[] args) {
    
        Scanner scn = new Scanner(System.in);
        int noofpairs_src_des = scn.nextInt();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < noofpairs_src_des; i++) {
            String s1 = scn.next();
            String s2 = scn.next();
            map.put(s1, s2);
        }
        System.out.println();
    
        scn.close();
    
        HashMap<String, Boolean> psrc = new HashMap<>();
        for (String s : map.keySet()) {
            psrc.put(map.get(s), false);
        }
    
        String src = "";
        for (String s : map.keySet()) {
            if (!psrc.containsKey(s)) {
                src = s;
            }
        }
    
        while (true) {
        
            if (map.containsKey(src) == true) {
            
                System.out.print(src + " -> ");
                src = map.get(src);
            } else {
                System.out.print(src + ".");
                break;
            }
        }
    }
    
}