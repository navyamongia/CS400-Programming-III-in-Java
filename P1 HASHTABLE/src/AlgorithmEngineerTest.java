

public class AlgorithmEngineerTest {
	public static boolean Test1() { //test for valid isbn , returns true if isbn is valid

		IISBNChecker c = new IISBNChecker();
		if(c.validate("9780306406157") == true)
		{
			return true;
		}
		else
		{
		return false;
		}
		
	}
	public static boolean Test2() {

		IISBNChecker c = new IISBNChecker(); // test for invalid isbn , returns true if not valid
		if(c.validate("000000") != true)
		{
			return true;
		}
		else
		{
		return false;
		}
		
	}
	public static boolean Test3() { 
		
		iteratorclass<Integer,Integer> ic = new iteratorclass<Integer,Integer>();
	    ic.put(1, 1);
	    ic.put(2, 2);
	    System.out.println(ic.size);
	    
	   if(ic.size ==2 )
	    {return true;}
	   return false;
	    
		
	}
	public static boolean Test4() {
		iteratorclass<Integer,Integer> ic = new iteratorclass<Integer,Integer>();
	    ic.put(2,3);
	    ic.put(3, 4);
	    if(ic.containsKey(2) == true)
	    {
	    	return true;
	    }
	    return false;
		
	
	}
	public static boolean Test5() { //returns true if it contains the key 
		iteratorclass<Integer,Integer> ic = new iteratorclass<Integer,Integer>();
		  ic.put(0, 1);
	        ic.put(1, 10);
	        ic.put(2, 20);
	        ic.put(3, 30);
	        if(ic.get(1)== 10)
	        {
	        	return true;
	        }
		
		
			return false;
	}
	
	
	
	public static void main(String[] args)
	{
		System.out.println("test1:" +Test1());
		System.out.println("test2:" +Test2());
		System.out.println("test3:" +Test3());
		System.out.println("test4:" +Test4());
		System.out.println("test5:" +Test5());
		
	}
	

}
