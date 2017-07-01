package init;

public class findComplement {
	int result;
	public int FindComplement(int num) 
    {
        int i = 0;
        int j = 0;
        
        while (i < num)
        {
            i += Math.pow(2, j);
            j++;
        }
        
        return result = (i - num);
    }

}
