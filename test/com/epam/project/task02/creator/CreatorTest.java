package com.epam.project.task02.creator;

import com.epam.project.task02.exception.InvalidArgumentHandlerException;
import com.epam.project.task02.exception.TypePlaneNotCorrectHandlerException;
import com.epam.project.task02.model.PassengerPlane;
import com.epam.project.task02.model.Plane;
import com.epam.project.task02.model.PlaneType;
import com.epam.project.task02.model.TransportPlane;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreatorTest {

    private static final Creator CREATOR = new Creator();

    @DataProvider(name = "stringsData")
    private static Object[][] getStringsData(){
        String stringDataPlane1 = "PASSENGER_PLANE; testPlane1;    1000; 900; 1000; 200";

        PassengerPlane plane1 = new PassengerPlane();
        plane1.setType(PlaneType.PASSENGER_PLANE);
        plane1.setBoardName("testPlane1");
        plane1.setMaxDistance(1000);
        plane1.setSpeed(900);
        plane1.setFuelConsumption(1000);
        plane1.setMaxPassengers(200);

        String stringDataPlane2 = "PASSENGER_PLANE; testPlane2;    1500; 980; 1500; 198";

        PassengerPlane plane2 = new PassengerPlane();
        plane2.setType(PlaneType.PASSENGER_PLANE);
        plane2.setBoardName("testPlane2");
        plane2.setMaxDistance(1500);
        plane2.setSpeed(980);
        plane2.setFuelConsumption(1500);
        plane2.setMaxPassengers(198);

        String stringDataPlane3 = "TRANSPORT_PLANE; testPlane3;    5000; 780; 2600; 2500";

        TransportPlane plane3 = new TransportPlane();
        plane3.setType(PlaneType.TRANSPORT_PLANE);
        plane3.setBoardName("testPlane3");
        plane3.setMaxDistance(5000);
        plane3.setSpeed(780);
        plane3.setFuelConsumption(2600);
        plane3.setMaxCargo(2500);

        return new Object[][]{
                {stringDataPlane1, plane1},
                {stringDataPlane2, plane2},
                {stringDataPlane3, plane3}
        };
    }
    @Test (dataProvider = "stringsData")
    public void testCreatePlanePositive(String string, Plane expectedPlane) {
        Plane actualResult = CREATOR.createPlane(string);
        Assert.assertEquals(actualResult, expectedPlane);
    }

    @Test (expectedExceptions = NullPointerException.class)
    public void testCreatePlaneThrowExceptionInvalidArgument() {
        String o = null;
        Plane plane = CREATOR.createPlane(o);
    }

    @Test (expectedExceptions = TypePlaneNotCorrectHandlerException.class)
    public void testCreatePlaneThrowExceptionTypePlaneNotCorrect() {
        String stringDataPlane = "PRIVATE_PLANE; testPlane2;    1500; 980; 1500; 198";
        Plane plane = CREATOR.createPlane(stringDataPlane);
    }
}