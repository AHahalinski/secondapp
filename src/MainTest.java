import com.epam.project.tas02.airline.Airline;

public class MainTest {
    public static void main(String[] args) {

        Airline airline = Airline.getInstance("the First Company");

//        List<Plane> planes = Loader.loadData();
//
//        airline.setPlanes(planes);

        System.out.println(airline +" \n");
        airline.sortByCargoPassengerDistance();
        System.out.println(airline);

    }
}
