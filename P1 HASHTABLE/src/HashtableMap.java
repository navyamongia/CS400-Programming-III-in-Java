// --== CS400 Project One File Header ==--
// Name: NAVYA MONGIA
// CSL Username: navya
// Email: mongia@wisc.edu
// Lecture #:  003 @2:25pm
// Notes to Grader: <any optional extra notes to your grader>


import java.util.NoSuchElementException; //importing the package

import java.util.LinkedList; //importing linked list package
public class HashtableMap<KeyType,ValueType> implements MapADT<KeyType,ValueType>{
	 
	 float loadfactor = (float) 0.7; // maximum loadfactor 
	  int size =0; // as no linked list present therefore size 0
		protected LinkedList<HashtableEntry<KeyType,ValueType>>[] buckets ;
	  
	@SuppressWarnings("hiding")
	class HashtableEntry<KeyType,ValueType> { //class for my hash table key value pairs
		
		KeyType k; //variable dewclarations
		ValueType v;
		
		
		
		public HashtableEntry(KeyType k , ValueType v) {//the constructor for it
			this.k=k;
			this.v=v;
			
		}
		
	}

	
	@SuppressWarnings("unchecked")
	public HashtableMap() { // default constructor
		 this.buckets=new LinkedList[15]; //creating new linked list of size 15
		this.buckets = (LinkedList<HashtableEntry<KeyType,ValueType>>[])this.buckets; //casting it
		
		}
	@SuppressWarnings("unchecked")
	public HashtableMap(int capacity  ) {
		this.buckets=new LinkedList[capacity]; //if capacity mentioned then we will directly use that
		this.buckets = (LinkedList<HashtableEntry<KeyType,ValueType>>[])this.buckets;
		
		
		
		
		
	}
     
		
	
		
		
		@SuppressWarnings("unused")
		private int hashCode(KeyType key) {
			return key.hashCode();
		}
		
	protected int get_Hashindex( KeyType key) //method to get my hash index for the key 
	{
		int hashcode = key.hashCode();
		int hashindex = Math.abs(hashcode)%buckets.length; //to calculate the index for the key
		return hashindex;
		
			
		
	}
	public int size() {
		
		return size;
		
	}
private void resizehash(){
    	
	if(((double)size/this.buckets.length) >= 0.7) //checking the load factor 
		{
		LinkedList<HashtableEntry<KeyType,ValueType>>[] old_table = this.buckets;//old table for references 
			this.buckets=new LinkedList[old_table.length * 2 ]; //doubling the length of the linked list ( double of the previous one)
			
			 size=0;  
			 
			 for(int i =0 ; i<old_table.length ; i++)
			 {
				 if(old_table[i] != null) // checking the values of the old table and if they are not null then we will run the loop and add these values in the new linked list we made
				 {
					 for(HashtableEntry<KeyType,ValueType>current : old_table[i] )
					 {
						 this.put(current.k , current.v);
					 }
				 }
				 
		     }
			 
			 
			
			
			
		}		
			
			
			
			
			
		}
		
	public boolean put(KeyType key,  ValueType value ) { //method to put key value in the hashtable
		// TODO Auto-generated method stub
		if(containsKey(key)) //if key already present then we cannot add it again
		{
			return false;
		}
		int hashindex = get_Hashindex(key); //getting index for that particular key
		LinkedList<HashtableEntry<KeyType,ValueType>>head = buckets[hashindex]; 
		if(buckets[hashindex]== null)// if nothing present at that index 
		{
			size++;   // then we will increase the size
		  
			 buckets[hashindex] = new LinkedList();} //create new linked list
			
		
			buckets[hashindex].add(new HashtableEntry<KeyType,ValueType>(key,value)); //then add values to it
			 resizehash(); // to check the loadfactor 
			
			return true;
					
		
	
	}
	public ValueType get(KeyType key) throws NoSuchElementException{
		int hashindex = get_Hashindex(key);
		LinkedList<HashtableEntry<KeyType,ValueType>>head = buckets[hashindex]; // we will name that key value pair present at that index as head
		if(head==null) //if head is null then therefore nothing present at that index
		{
			throw new NoSuchElementException();
		}
		for (HashtableEntry<KeyType,ValueType>current : head) // running the for each loop till head
		{
			if(current.k.equals(key)) //if both have equal keys then we will return the value 
			{
				return current.v;
				
				
				
			}
			
			
			
		}
		 
			throw new NoSuchElementException(); //else throw exception
		
		
		
		
	}
	
	public ValueType remove(KeyType key) {
		int hashindex = get_Hashindex(key);
		LinkedList<HashtableEntry<KeyType,ValueType>>head = buckets[hashindex];
		if(head != null) //if head is not null and a pair is present
		{
			
		
		for (HashtableEntry<KeyType,ValueType> rem : head) // to iterate it till head
		{
			if(rem.k.equals(key)) 
			{
				head.remove(); 
				return rem.v; // returning the value that is removed 
				
				
				
				
				
			}
		  
		}
		
		}
		return null;
			
		
	}
		

	 public boolean containsKey(KeyType key) {
		
		 try { 
			 get(key); //if this key returns something then it is present , therefore true .
			 return true;
		 }
		 catch(NoSuchElementException e){ //in case of the key not present it will execute the catch block and catch the exception
			 return false; //else false 
		 }
		 
		
		
	}
	
	
	
	public void clear() {
		// TODO Auto-generated method stub
		int len = buckets.length; //to get the present size/lenght of the list
		for(int i =0; i<len ; i++)
		{
			buckets[i]=null; //will put all buckets null and size as 0 to clear it 
			size = 0;
		}
		
		
	}
	
	
	
	
	
		
				
			
				
}



	
	
	
	
	
	


