import java.util.ArrayList;
import java.util.HashMap;

public class randomizedSetDataStruct {
	HashMap<Integer,Integer> map = new HashMap<>();
    ArrayList<Integer> arr = new ArrayList<>();
    
    public randomizedSetDataStruct() {
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val,1);
            arr.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            map.remove(val);
            arr.remove(arr.indexOf(val));
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        if(arr.size() != 0){
        int val = (int) Math.floor(Math.random() * arr.size());
        return arr.get(val);
        }
        return 0;
    }
    

}
