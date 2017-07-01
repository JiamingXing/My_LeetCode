package init;
public class teemoAttacking {
	
	
	
	
	
	public int findPoisonedDuration(int[] timeSeries, int duration) {
        int i =0;
        int PositionDuration = 0;
        if(timeSeries.length == 1){
            PositionDuration = duration;
        }
        while(i < timeSeries.length-1){
            if(timeSeries[i+1] - timeSeries[i] >= duration){
                PositionDuration += duration;
                i++;
                if(i == timeSeries.length -1 ){
                    PositionDuration += duration;
                }
            }else{
                int j =i+1;
                while(j < timeSeries.length -1 && timeSeries[j+1] - timeSeries[j] < duration){
                    j = j + 1;
                }
                PositionDuration = PositionDuration + timeSeries[j] - timeSeries[i] + duration;
                i = j + 1;
                if(i == timeSeries.length - 1){
                    PositionDuration = PositionDuration + duration;
                }
            }
        }
        return PositionDuration;
        
    }

}
//这是自己按照逻辑一步步分类得到最基本的方法，但是期间出现无数次错误！
//如何避免逻辑上的不周密？很有可能没有考虑所有的情况
//还有没有别的容易的方法?


/* 
 * public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int begin = timeSeries[0], total = 0;
        for (int t : timeSeries) {
            total+= t < begin + duration ? t - begin : duration;
            begin = t;
        }   
        return total + duration;
    } 
*/
