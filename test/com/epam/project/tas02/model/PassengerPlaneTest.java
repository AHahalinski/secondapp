package com.epam.project.tas02.model;

public class PassengerPlaneTest {
/*
    @DataProvider(name = "planes")
    private Object[][] getPassengerPlane() {
        return new Object[][]{
                {
                        new PassengerPlane(PlaneType.PASSENGER_PLANE, "A752", 3500, 900, 11500, 2500),
                        new PassengerPlane(PlaneType.PASSENGER_PLANE, "A752", 3500, 900, 11500, 2500),
                        true},
                {
                        new PassengerPlane(PlaneType.TRANSPORT_PLANE, "ff45", 5000, 896, 13500, 2500),
                        new PassengerPlane(PlaneType.PASSENGER_PLANE, "A752", 3500, 900, 11500, 4200),
                        false},
                {
                        new PassengerPlane(PlaneType.PASSENGER_PLANE, "A752", 3500, 900, 11500, 4500),
                        null,
                        false},
                {
                        new PassengerPlane(PlaneType.PASSENGER_PLANE, "A752", 3500, 900, 11500, 6000),
                        new PassengerPlane(PlaneType.PASSENGER_PLANE, "A752", 3500, 900, 11500, 4500),
                        false},
                {
                        new PassengerPlane(PlaneType.PASSENGER_PLANE, "A752", 3500, 900, 11500, 2500),
                        new TransportPlane(PlaneType.PASSENGER_PLANE, "A752", 3500, 900, 11500, 2500),
                        false}
        };
    }

    @Test(dataProvider = "planes")
    public void testTestEquals(Plane o1, Plane o2, boolean expectedResult) {
        boolean actualResult = o1.equals(o2);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "planes")
    public void testTestHashCode(Plane o1, Plane o2, boolean expectedResult) {
        if (o1 != null && o2 != null) {
            int hashCodeO1 = o1.hashCode();
            int hashCodeO2 = o2.hashCode();
            boolean actualResult = hashCodeO1 == hashCodeO2;
            Assert.assertEquals(actualResult, expectedResult);
        }
    }
    */
}