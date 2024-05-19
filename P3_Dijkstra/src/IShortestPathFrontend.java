import java.io.FileNotFoundException;

interface IShortestPathFrontend {

    /**
     *method runs everything for the app to work
     */
    public void runApp();

    /**
     * method displays all the cities available
     */
    public void displayAllCities();


    /**
     * method displays all the cities that is reachable within an input distance from a certain city
     */
    public void displayCitiesInRange();


    /**
     * method that print the length of the shortest path,
     * and the names of the cities on the shortest path, and the distance between 2 cities
     */
    public void displayShortestPath();

    /**
     * method displays the mainMenu and take user's input
     */
    public void displayMainMenu();


}
