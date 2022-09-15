import java.util.*;

class MyHashMap {
    
    private class HMNode {
        int key;
        int value;
        
        HMNode(int key , int value){
            this.key = key;
            this.value = value;
        }
    }
    
    LinkedList<HMNode> [] buckets;
    int size;
    
    public MyHashMap() {
        
        size = 0;
        buckets = new LinkedList[5];
        for (int i = 0 ; i<5 ; i++){
            buckets[i] = new LinkedList<>();
        }
    }
    
    
    private int hashFunc(int key){
        
        Integer obj = key;
        int hCode = obj.hashCode();
        int absHcode = Math.abs(hCode);
        int bi = hashFunc(absHcode);
        return bi;
    }
    
    private HMNode find(LinkedList<HMNode> ll,int key){
        
        for (HMNode node : ll){
            if (node.key == key){
                return node;
            }
        }
        return null;
    }
    
    public void put(int key, int value) {
    
        int bi = hashFunc(key);
        HMNode node = find(buckets[bi], key);
        if (node != null){
            node.value = value;
        }
        else{
            HMNode nnode = new HMNode(key,value);
            buckets[bi].addLast(nnode);
            size++;
        }
        
        double lambda = ((size*1.0)/buckets.length);
        
        if (lambda > 2){
            LinkedList<HMNode>[] oldBuckets = buckets;
            buckets = new LinkedList[2*buckets.length];
            for (int i = 0 ; i< buckets.length ; i++){
                buckets[i] = new LinkedList<>();
            }
            
            //Transfer the data from old to new buckets -
            
            for (LinkedList<HMNode> ll : oldBuckets){
                
                for (HMNode n : ll){
                    put(key,value);
                }
            }
        }
        
    }
    
    public int get(int key) {
    
        int bi = hashFunc(key);
        HMNode node = find(buckets[bi] , key);
        if (node!= null){
            return node.value;
        }else{
            return -1;
        }
    }
    
    public void remove(int key) {
    
        int bi = hashFunc(key);
        HMNode node = find(buckets[bi], key);
        if (node != null){
            buckets[bi].remove(node);
            size--;
        }
    }
}