import java.util.ArrayList;
import java.util.List;
//递归函数一般都写成void的形式
//数组和string其实都差不多，给一个index的指针作为参数会比较方便
//不要想着去拷贝数组或删除一些元素，空间时间复杂度会比较高
//比如：判断头几个字母是否palindrome，想着把它单独提取出来成为新的string是不对的
//取index pointer作为参数才是正确的思路

public class partitionPalindrome {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		List<String> current = new ArrayList<>();
		helper(result, current, s, 0);
		return result;	
	}
	public void helper(List<List<String>> result, List<String> current, String s, int p){
		//写递归函数 什么时候停止递归最难 下面的if判断
		if(current.size() >0 && p >= s.length()){
			List<String> temp = new ArrayList<>();
			//temp=current？？会有传递性的问题？
			temp = current;
			result.add(temp);
		}
		for(int i = p; i < s.length(); i++){
			if(checkPalindrome(s, p, i)){
				if(p == i){
					current.add(Character.toString(s.charAt(p)));
				}else{
					current.add(s.substring(p, i+1));
				}
				helper(result, current, s, i+1);
				current.remove(current.size()-1);
			}
		}
	}
	//写这个判断palindrome的函数也有技巧
	public boolean checkPalindrome(String str, int start, int end){
		if(start == end){
			return true;
		}
		while(start < end){
			if(str.charAt(start) != str.charAt(end)){
				return false;
			}
			start ++;
			end --;
		}
		return false;
	}
	
}
	





















//思路是正确的，但是想法有所偏差
/*public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        result = findPartition(s);
        return result;
        
    }
	public List<List<String>> findPartition(String s){
		// possbilePartition 用来存储调用自身得到的List<List<String>>
		List<List<String>> possiblePartition = new ArrayList<>();
		List<List<String>> result = new ArrayList<>();
        int l = s.length();
        //递归调用的停止条件，长度小于1
        if(l > 0){
        	for(int i = 1; i <= l; i++){
        		//如果对于subString(0,i)是palindrome，找到剩下的所有partition
        		if(checkPalindrome(s.substring(0,i))){
        			List<String> temp = new ArrayList<>();
        			// substring的开始结束要注意！！
                    temp.add(s.substring(0,i));
                    possiblePartition = findPartition(s.substring(i,l));
                    //possiblepartition里的每个元素都加到temp中，然后加到result中
                    for(int m = 0; m < possiblePartition.size(); m++){
                    	// temp是一个存储String的ArrayList,所以要在里面加入String
                    	// 如何把possiblePartition里的所有String提取出来？？
                    	// 涉及到Sting的操作
                    	temp.add(possiblePartition.subList(m,m+1));
                        result.add(temp);
                        //result 加了一个temp之后，把temp中新加入的循环元素移除
                        temp.remove(temp.size() - 1);
                    }
        		}
        	}
        }
        return result;
        
    }
	
	public boolean checkPalidrome(String k){
		if(k.length() == 1){
			return true;
		}
		
	}
*/

