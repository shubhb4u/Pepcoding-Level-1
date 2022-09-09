import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashMap<String, HashSet<String>> tree = new HashMap<>();
        
        String ceo = "";
        for (int i = 0 ; i < n ; i++){
            
            String emp = scn.next();
            String manager =scn.next();
            
            if (emp.equals(manager)){
                ceo = emp;
            }
            else{
                if (tree.containsKey(manager)){
                    HashSet<String> empList = tree.get(manager);
                    empList.add(emp);
                }
                else{
                    HashSet<String> empList = new HashSet<>();
                    empList.add(emp);
                    tree.put(manager,empList);
                }
            }
        }
//        System.out.println(tree);
        HashMap<String, Integer> ans = new HashMap<>();
        traverse(ans,ceo,tree);
        for(String manager : ans.keySet()){
            int freq = ans.get(manager);
            System.out.println(manager+" "+freq);
        }
    }
    
    public static int traverse(HashMap<String, Integer> ans, String manager, HashMap<String, HashSet<String>> tree){
        
        HashSet<String> empList = tree.get(manager);
        if (empList == null){
            ans.put(manager,0);
            return 1;
        }
        int size = 0;
        for (String st : empList){
            size += traverse(ans,st,tree);
        }
        ans.put(manager,size);
        return size+1;
    }
}