import java.io.*;
import java.util.*;

public class scratch {
    
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i<n ; i++){
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        int ans = firstIndex(arr , 0 , x);
        System.out.println(ans);
    }
    
    public static int firstIndex(int[] arr, int idx, int x) {
    
        if (idx == arr.length-1) return idx;
        int recAns = firstIndex(arr, idx + 1, x);
        if (arr[recAns] == x) return recAns;
        else return -1;
    }
}
