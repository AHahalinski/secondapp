import com.epam.project.task02.airline.Airline;
import com.epam.project.task02.loader.Loader;
import com.epam.project.task02.model.Plane;

import java.util.List;

public class MainTest {

    private static int a = 1;
    private static int b = a;


    public static void main(String[] args) {

        Airline airline = Airline.getInstance("the First Company");

        List<Plane> planes = Loader.loadData();

        airline.setPlanes(planes);

        System.out.println(airline +" \n");
        airline.sortByCargoPassengerDistance();
        System.out.println(airline);

    }
}
