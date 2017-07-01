package init;
public class maxProfitOneTransaction {
	public static void main(String[] args) {
		int prices[] = new int[]{7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
		//System.out.println(1%2);
		
	}
	public static int maxProfit(int[] prices) {
		int midpoint = 0;
		int max_left = 0;
		int max_right = 0;
		int max_mid = 0;
		int max = 0;
		if(prices.length%2 ==0){
			midpoint = prices.length/2 -1;
		}else{
			midpoint = prices.length/2;
		}
		if(midpoint<1){
			
		}
		for(int i=0;i<midpoint;i++){
			int j = prices.length-1;
			while(j>midpoint){
				if(prices[j]-prices[i]>max_mid){
					max_mid = prices[j] - prices[i];
				}
				j--;
			}
					
		}
		int leftsubarray[] = new int[midpoint+1];
		int rightsubarray[] = new int[prices.length - midpoint -1];
		System.arraycopy(prices,0,leftsubarray,0,leftsubarray.length);
		System.arraycopy(prices,midpoint+1,rightsubarray,0,rightsubarray.length);
		max_left = maxProfit(leftsubarray);
		max_right = maxProfit(rightsubarray);
		int max_temp = Math.max(max_left,max_right);
		max = Math.max(max_temp, max_mid);
		return max;
		
		
		
	}
	

}



/* 
public static int maxProfit(int[] prices) {
int max = 0;
for(int i=0; i<prices.length;i++){
	int j =prices.length-1;
	while(j>i){
		if(prices[j]-prices[i]>max){
			max = prices[j] - prices[i];
			
		}
		j--;
	}
}
return max;

}
 最笨的方法 运行时间太久
 写出maximum subarray  用divide-and-conquer的思路
*
*/