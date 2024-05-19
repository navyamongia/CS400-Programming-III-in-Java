
public class IISBNChecker implements IISBNValidator{
	//String isbn13;
	
 /*public IISBNChecker(String isbn13)
{
	this.isbn13 = isbn13;
}*/
	
	
	@Override
	public boolean validate(String isbn13) {
		// TODO Auto-generated method stub
		int isbn_len = isbn13.length(); //to get the length of the string
		if(isbn_len  != 13) //since its isbn13 therefor length of isbn should be 13
		{
			
			return false; //if not then return false
		}
		int array[] = new int[isbn_len]; //to store the digits of isbn
		int i ;
		int sum =0;
		StringBuffer sb = new StringBuffer(isbn13);
		for(i=0; i<isbn_len;i++) 
		{
			 array[i] =sb.charAt(i) - '0'; // an array is required to store all the digits of an isbn in int datatype
			 //System.out.println(array[i]);
			 
			 
		}
		int x;
		int check_digit;
		for(x = 0 ; x<12 ; x = x +2)
		{
			sum = sum + array[x] * 1 + array[x+1] *3 ;
			//System.out.println(sum);
		}
		//System.out.println(sum);
		check_digit = 10 -(sum % 10) ; //if check digit is equal to last digit of string , then isbn13 
		if(check_digit == array[12])
		{
			System.out.println(check_digit + ":this is the check digit which is also equal to last digit of isbn");
			System.out.println("isbn number is valid as check digit is equal to last digit of isbn");
			return true;
		}
		else
			return false;
		
		
		
		
		
		
		
		
	
		
	}
	

	

};
