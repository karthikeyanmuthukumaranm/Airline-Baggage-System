package model;

public class Passenger {
    private String name;
    private String flightNumber;
    private String airlineName;
    private double baggageWeight;

    public Passenger(String name, String flightNumber, String airlineName, double baggageWeight) {
        this.name = name;
        this.flightNumber = flightNumber;
        this.airlineName = airlineName;
        this.baggageWeight = baggageWeight;
    }

    public String getName() {
        return name;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public double getBaggageWeight() {
        return baggageWeight;
    }
}
