public class HashtableMapTest{
	public static boolean test1() {
		HashtableMap<String , String> h = new HashtableMap<String,String>(3 );
		h.put("a", "a");
		h.put("b" , "b");
		h.put("c","c"); 
		
		if(h.get("c").equals("c"))
			
		{
			return true;
		}
		
		return false;
	}
	public static boolean test2 () {
		HashtableMap<Integer , Integer> h = new HashtableMap<Integer,Integer>(3 );
		h.put(1, 1);
		h.put(2 , 2);
		h.put(3,3); 
		int oldsize = h.size();
		
		h.clear();
		System.out.println(h.size() + ": this is the size after clearing");
		
		
		if(h.size() < oldsize)
		{
			return true;
		}
		return false;
		
	}
	public static boolean test3 () {
		HashtableMap<Integer , String> h = new HashtableMap<Integer,String>(3 );
		h.put(1, "ist pos");
		h.put(2 , "2nd pos");
		h.put(3,"3rd pos"); 
		h.get(3);
		System.out.println(h.get(3)  );
		if(h.get(3) == "3rd pos")
			return true;
		
		else
			return false;
		
		
		
	}
	public static boolean test4 () {
		HashtableMap<Integer , Integer> h = new HashtableMap<Integer,Integer>(2 );
		h.put(1, 1);
		h.put(2 , 2);
		h.put(3,3);
		h.containsKey(3);
		if(h.containsKey(3)== true )
		{
			return true;
		}
			
		
		
		return false;
		
		
	}
	public static boolean test5 () {
		HashtableMap<Integer , Integer> h = new HashtableMap<Integer,Integer>(2 );
		h.put(1, 11);
		h.put(2 , 21);
		
		 
		if(h.remove(2) == 21)
		{
			
			
			return true; // as removed value is equal to 21 therefore it means that the value has been removed 
			
		}
		
		 
		return false;
		
		
	}
		
	
	
	
	
	
public static void main(String[]args) {
	System.out.println("test1:" +test1());
	System.out.println("test2:" +test2());
	System.out.println("test3:" +test3());
	System.out.println("test4:" +test4());
	System.out.println("test5:" +test5() );
	
}
}

