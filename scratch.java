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
    
        public static void main(String [] args){
            
            Scanner scn = new Scanner(System.in);
            int num1 = scn.nextInt();
            int num2 = scn.nextInt();
            System.out.println(numberOfSetBits(num1));
            System.out.println(numberOfFlips(num1,num2));
            
        }
        
        public static int numberOfSetBits(int num){
    
            int ans = 0;
            while(num != 0) {
        
                if (num % 2 == 1) ans += 1;
                num /= 2;
        
            }
            return ans;
        }
    
        public static int numberOfFlips(int num1, int num2) {
            
            int diff = numberOfSetBits(num1)-numberOfSetBits(num2);
            if (diff == 0) return numberOfSetBits(num1);
            else return diff;
        }
    
        public static int firstSetBitLeft(int num1) {
            
            StringBuilder sb = new StringBuilder();
            while(num1 != 0) {
                
                sb.append(num1%2);
                num1 /= 2;
            }
            
        }
    }