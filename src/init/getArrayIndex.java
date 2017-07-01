package init;
public class getArrayIndex {
	int array[];

	public int getAryIndex(int x, int array[]){ // this.array?
		
		for(int i=0; i<array.length; i++){
			if (array[i]==x){
				
				return i;
				//关于break return 还有为什么不能直接返回i？
			}
			
		}
		return -1;
		
	}
	

}
