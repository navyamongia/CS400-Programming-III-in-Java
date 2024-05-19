import java.util.NoSuchElementException;
import java.util.ArrayList;

public class GraphBackend<NodeType> implements IGraphBackend<NodeType> {
  
  public NodeType  startCity;
  CS400Graph  path;
  
  public GraphBackend(NodeType startCity) {
    this.startCity=startCity;
    CityLoader cities = new CityLoader();
    path =(CS400Graph) cities.CityLoad();
  }
  
  public GraphBackend(){
  	CityLoader cities = new CityLoader();
	path = (CS400Graph) cities.CityLoad();
  }
	
  @Override
  public void changeStart(NodeType start) {
    this.startCity=start;
  }
  
  @Override
  public ArrayList<NodeType> shortestPathToTake(NodeType  end) {
	 try{
	  return (ArrayList) path.shortestPath(startCity,end).graphToListIsomorphicBijection();
  }
  catch(NoSuchElementException e){
  	return null;
  }
  }

  @Override
  public ArrayList<NodeType> getAllCities() {
    // TODO Auto-generated method stub
    //
    ArrayList<NodeType> output = new ArrayList<NodeType>();
    return  output;
  }

  @Override
  public double shortestPathLength(NodeType end) {
    // TODO Auto-generated method stub
    //
    try{
    return path.getPathCost(startCity, end);
  }
  	catch(NoSuchElementException e){
		return -1;
	}
  }

  @Override
  public ArrayList  getCitiesCloseBy(int miles) {
    // TODO Auto-generated method stub
    ArrayList<NodeType> allCities = new ArrayList();
    ArrayList<NodeType> closestCities = new ArrayList();
   // allCities.addAll(path.getAllCities());
   // for(String s: allCities) {
     // if(path.getPathCost(startCity,s)<=miles) {
       // closestCities.add(s);
     // }
    //}
    return closestCities;
  }

}
