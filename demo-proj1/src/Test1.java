import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;

public class Test1 {
public static void main(String[] args) {
	HashMap<Integer,Integer> hm;
	HashSet<Integer> hs;
	ArrayBlockingQueue<Integer> abq; 
	Collections.reverseOrder();
}
//
//public void put(K newKey, V data){
//    if(newKey==null)
//        return;    //does not allow to store null.
//   
//    //calculate hash of key.
//    int hash=hash(newKey);
//    //create new entry.
//    Entry<K,V> newEntry = new Entry<K,V>(newKey, data, null);
//   
//    //if table location does not contain any entry, store entry there.
//     if(table[hash] == null){
//      table[hash] = newEntry;
//     }else{
//        Entry<K,V> previous = null;
//        Entry<K,V> current = table[hash];
//        
//        while(current != null){ //we have reached last entry of bucket.
//        if(current.key.equals(newKey)){           
//            if(previous==null){  //node has to be insert on first of bucket.
//                  newEntry.next=current.next;
//                  table[hash]=newEntry;
//                  return;
//            }
//            else{
//                newEntry.next=current.next;
//                previous.next=newEntry;
//                return;
//            }
//        }
//        previous=current;
//          current = current.next;
//      }
//      previous.next = newEntry;
//     }
// }
}
