/**
 * Navya Mongia 
 * FD team blue DC
 */
import java.util.ArrayList;
/**
 * place holder class for backend 
 * @author NavyaMongia
 *
 */

public class FDGraphBackendPlaceholder implements IGraphBackend <String> {
	//  ArrayList<ICity> GraphBackend;
	  
	  ArrayList<String> shortestjourney;
	  ArrayList<Double> shortestjourneydistance;
	  ArrayList<String> allcitiesinbetween;
	  ArrayList<String> citiescloseby;
	
/**
 * returning a array list of hardcoded cities 
 */
	@Override
	public ArrayList<String> shortestPathToTake(String end) {
		// TODO Auto-generated method stub
		shortestjourney = new ArrayList<>();
		shortestjourney.add("New York");
		shortestjourney.add("Chicago");
	shortestjourney.add("Las Vegas");
    shortestjourney.add("Los Angeles");

		return shortestjourney ;
		
	}
/**
 * placeholder method that displays all the cities available for the user
 */
	@Override
	public ArrayList<String> getAllCities() {
		allcitiesinbetween = new ArrayList<>();
		allcitiesinbetween.add("New York");
		allcitiesinbetween.add("Chicago");
		allcitiesinbetween.add("Boston");
		allcitiesinbetween.add("Austin");
		allcitiesinbetween.add("Hawaii");
		allcitiesinbetween.add("Los Angeles");
		return allcitiesinbetween;
		
		
		// TODO Auto-generated method stub
		
	}
/**
 * Returning hardcoded value for shortest path len
 */
	@Override
	public double shortestPathLength(String end) {
		// TODO Auto-generated method stub
		return  2797.2;
	}

	@Override
	public ArrayList<String> getCitiesCloseBy(int miles) {
		// TODO Auto-generated method stub
		citiescloseby = new ArrayList<>();
		citiescloseby.add("Chicago");
		citiescloseby.add("Boston");
		
		return citiescloseby;
	}
	@Override
	public void changeStart(String startCity) {
		// TODO Auto-generated method stub
		
	}
	

	

}
