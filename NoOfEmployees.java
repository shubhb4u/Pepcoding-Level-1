import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashMap<String, HashSet<String>> tree = new HashMap<>();
    
        String ceo ="";
        for (int i = 0 ; i<n ; i++) {
            String emp = scn.next();
            String manager = scn.next();
    
            if (manager.equals(emp)) {
                ceo = emp;
            } else {
                HashSet<String> empList = tree.get(manager);
                //Using IsEmpty() throws NPE because no HashSet is present for the manager yet.
                if (empList == null) {
                    empList = new HashSet<>();
                    empList.add(emp);
                    tree.put(manager, empList);
                } else {
                    empList.add(emp);
                }
            }
        }
        System.out.println(tree);
    }
    
}