import java.util.ArrayList;

public class PlaceHolderForAlgorithmEngineer {

  public ArrayList getShortestPath(String startCity, String end) {
    // TODO Auto-generated method stub
    ArrayList<String> output = new ArrayList();
    output.add("shortestPath");
    return output;
  }

  public ArrayList getAllCities() {
    // TODO Auto-generated method stub
    ArrayList<String> output = new ArrayList();
    output.add("London");
    output.add("Belgium");
    output.add("Paris");
    output.add("Madrid");
    return output;
  }

  public int getShortestCost(String end) {
    // TODO Auto-generated method stub
    if(end.equals("Madrid")) return 1;
    else if(end.equals("London")) return 5;
    else if(end.equals("Belgium")) return 10;
    else if(end.equals("Paris")) return 15;
    else return 0;
  }

}
