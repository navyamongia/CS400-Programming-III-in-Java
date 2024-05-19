// --== CS400 Fall 2022 File Header Information ==--
// Name:  Navya Mongia
// Email: mongia@wisc.edu
// Team: DC
// TA: Yelun Bao

public class CityPlaceholder implements ICity{
	String startCity;
	String endCity;
	double distance;
	
	
	public void setstartCity(String startCity) {
		// TODO Auto-generated method stub
		this.startCity = startCity;
		
	}
	
	public void setendCity(String endCity) {
		// TODO Auto-generated method stub
		this.endCity = endCity;
		
	}
	
	public void setdistance(double distance)
	{
		this.distance = distance;
	}
	
	public String getstartCity() {
		// TODO Auto-generated method stub
		return this.startCity;
	}

	
	public String getendCity() {
		// TODO Auto-generated method stub
		return this.endCity;
	}
	
	public double getdistance()
	{
		return this.distance ;
	}
	

}
