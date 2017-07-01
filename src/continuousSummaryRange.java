import java.util.ArrayList;
import java.util.List;
//我这个写法是只有当出现不联系的时候才停下来打印，不然一直continue
//所以当[1 2]的时候应该打印[1 -> 2]但是我这个不打印。。
//如果改变策略。。
//如果写出了这样的程序但是编译不过，那么想问题出在哪里了，如何解决。
//答案的思路是多给了一重的限制条件！！很重要的思路。
public class continuousSummaryRange {
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
        int start = 0;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] - nums[i - 1] == 1){
                continue;
            }
            if(start != i - 1 ){
                result.add(nums[start] + "->" + nums[i-1]);
                start = i;
            }else{
                result.add(nums[start]+"");
                start = i;
            }
        }
        return result;
	}

}


//思考下为什么他这样可以？
//算是一种新的跳过重复元素的方式？？？？
//string list 加一个int 要加“”不然不会自动转成int？
/*
List<String> list=new ArrayList();
if(nums.length==1){
	list.add(nums[0]+"");
	return list;
}
for(int i=0;i<nums.length;i++){
	int a=nums[i];
	while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
		i++;
	}
	if(a!=nums[i]){
		list.add(a+"->"+nums[i]);
	}else{
		list.add(a+"");
	}
}
return list;
*/