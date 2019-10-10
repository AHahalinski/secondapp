import com.epam.project.task02.airline.Airline;
import com.epam.project.task02.loader.Loader;
import com.epam.project.task02.model.Plane;

import java.util.List;

public class MainTest {

    private static final String PATH = "resources/airlineData.txt";

    public static void main(String[] args) {

        Airline airline = Airline.getInstance("the First Company");

        List<Plane> planes = Loader.loadData(PATH);

        airline.setPlanes(planes);

        System.out.println(airline +" \n");

        airline.findPlanesByFuel(1000, 1500);
        airline.sortByCargoPassengerDistance();
        airline.sortByFuelConsumption();

    }
}
