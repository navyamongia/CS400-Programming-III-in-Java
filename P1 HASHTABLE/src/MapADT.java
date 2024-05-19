import java.util.NoSuchElementException;
public interface MapADT<KeyType,ValueType>{
	public boolean put(KeyType key, ValueType value);
	public ValueType get(KeyType key) throws NoSuchElementException;
	public ValueType remove(KeyType key);
	public boolean containsKey(KeyType key);
	public int size();
	public void clear();

	



	
	

}
