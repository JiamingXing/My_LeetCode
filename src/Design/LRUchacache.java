package Design;
// LRU : Least Recently Used(time)
// LFU : Least Frequently Used

//判断是否在cache中有某个key
//判断least recent used element
//添加新元素
//最关键的是怎么判断least recent used element
public class LRUchacache {
	private class DLinkedNode {
		int key;
		int value;
		DLinkedNode pre;
		DLinkedNode post;
		
		
	}
	public LRUCache(int capacity) {
        
    }
    
    public int get(int key) {
        
    }
    
    public void put(int key, int value) {
        
    }
	
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */