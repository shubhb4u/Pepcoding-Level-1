//import java.io.*;
//import java.util.*;
//
//class Main {
//
//    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        int n = scn.nextInt();
//        HashMap<String, HashSet<String>> tree = new HashMap<>();
//        String ceo = "";
//
//        for (int i = 0 ; i<n ;i++){
//
//            String emp = scn.next();
//            String man = scn.next();
//
//            if (man.equals(emp)){
//                ceo = emp;
//            }
//            else if (tree.containsKey(man)){
//                HashSet<String> empList = tree.get(man);
//                empList.add(emp);
//            }
//            else{
//                HashSet<String> empList = new HashSet<>();
//                empList.add(emp);
//                tree.put(man,empList);
//            }
//        }
//        HashMap<String, Integer> ans = new HashMap<>();
//        traverse(ans,ceo,tree);
//
//
//    }
//
//    public static int traverse(HashMap<String, Integer> ans, String manager, HashMap<String, HashSet<String>> tree){
//
//
//
//}