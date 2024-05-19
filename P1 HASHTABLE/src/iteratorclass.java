
import java.util.Iterator;
import java.util.LinkedList;
public class iteratorclass<KeyType,ValueType> extends HashtableMap<KeyType , ValueType> implements IterableMapADT<KeyType , ValueType> { 
	




public class HashtableIterationClass  implements Iterator<ValueType> {
	
    int index_list = 0; //index of linked list
    int hashIndex = 0; //the index of the array/ the hashindex

    
    KeyType key; //variable declarations
    ValueType value;

    @Override
    public boolean hasNext() { //method to check if there is something present in the next index 
    	
       /*  return buckets[this.hashIndex] != null
               && buckets[this.hashIndex].get(this.index_list) != null;*/
    	if(hashIndex == 0 && index_list == 0)
    	{
    		while(hashIndex < (buckets.length -1)&& buckets[hashIndex]== null)
    		{
    			hashIndex++;
    		}
    	}
    	if(buckets[hashIndex]!= null)
    	{
    		if(buckets[hashIndex].get(index_list) != null)
    		{
    			return true;
    		}
    		
    	}
   
			return false;
        
    }

    //@Override
    public ValueType next() {
        // TODO Auto-generated method stub

        
        ValueType next_val; //the value that the method will return

        if (this.hasNext()) {
            next_val = buckets[this.hashIndex].get(this.index_list).v; //this will return the value at that index 
            for(;;hashIndex++) {
            	if(buckets[this.hashIndex] != null) 
            		break;
            }
            // this.hashIndex++;
            return next_val;
           
        }
        return null;
    }


    

}

				
			 
		
	@Override
	public java.util.Iterator<ValueType> iterator() {
		// TODO Auto-generated method stub
		return new HashtableIterationClass();
	}
	
}


