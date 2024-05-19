import java.util.ArrayList;
public interface IGraphBackend<T>{

	public void changeStart(T startCity);

        public ArrayList<T> shortestPathToTake(T end);

        public ArrayList<T> getAllCities();

        public double shortestPathLength(T end);

        public ArrayList<T> getCitiesCloseBy(int miles);


}
