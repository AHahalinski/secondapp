package com.epam.project.task02.airline;

import com.epam.project.task02.model.PassengerPlane;
import com.epam.project.task02.model.Plane;
import com.epam.project.task02.model.PlaneType;
import com.epam.project.task02.model.TransportPlane;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AirlineTest {

    private static final Airline AIRLINE = Airline.getInstance("TEST_AIRLINE");

    @DataProvider(name = "planes")
    public static Object[][] getTestPlanes() {
        PassengerPlane plane1 = new PassengerPlane();
        plane1.setType(PlaneType.PASSENGER_PLANE);
        plane1.setBoardName("testPlane1");
        plane1.setMaxDistance(1000);
        plane1.setSpeed(900);
        plane1.setFuelConsumption(1000);
        plane1.setMaxPassengers(200);

        PassengerPlane plane2 = new PassengerPlane();
        plane2.setType(PlaneType.PASSENGER_PLANE);
        plane2.setBoardName("testPlane2");
        plane2.setMaxDistance(1500);
        plane2.setSpeed(980);
        plane2.setFuelConsumption(1500);
        plane2.setMaxPassengers(198);

        TransportPlane plane3 = new TransportPlane();
        plane3.setType(PlaneType.TRANSPORT_PLANE);
        plane3.setBoardName("testPlane3");
        plane3.setMaxDistance(5000);
        plane3.setSpeed(780);
        plane3.setFuelConsumption(2600);
        plane3.setMaxCargo(2500);

        return new Object[][]{
                {Arrays.asList(plane1, plane2, plane3), 1000, 1500, Arrays.asList(plane1, plane2)},
                {Arrays.asList(plane1, plane2, plane3), 100, 5000, Arrays.asList(plane1, plane2, plane3)},
                {Arrays.asList(plane1, plane2, plane3), 3000, 5000, Arrays.asList()}
        };
    }

    @Test(dataProvider = "planes")
    public void testFindPlanesByFuelMinToMax(List<Plane> planes, int minFuel, int maxFuel, List<Plane> expectedResult) {
        AIRLINE.setPlanes(planes);
        List<Plane> actualResult = AIRLINE.findPlanesByFuel(minFuel, maxFuel);
        Assert.assertEquals(actualResult, expectedResult);
    }
}