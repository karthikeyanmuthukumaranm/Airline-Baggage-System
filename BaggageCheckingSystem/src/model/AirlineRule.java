package model;

public class AirlineRule {
    private String airlineName;
    private String flightNumber;
    private int baggageAllowance;
    private double penaltyRate;

    public AirlineRule(String airlineName, String flightNumber, int baggageAllowance, double penaltyRate) {
        this.airlineName = airlineName;
        this.flightNumber = flightNumber;
        this.baggageAllowance = baggageAllowance;
        this.penaltyRate = penaltyRate;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getBaggageAllowance() {
        return baggageAllowance;
    }

    public double getPenaltyRate() {
        return penaltyRate;
    }
}
