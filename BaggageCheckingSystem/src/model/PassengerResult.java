package model;

public class PassengerResult {
    private Passenger passenger;
    private double penalty;
    private String status;

    public PassengerResult(Passenger passenger, double penalty, String status) {
        this.passenger = passenger;
        this.penalty = penalty;
        this.status = status;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public double getPenalty() {
        return penalty;
    }

    public String getStatus() {
        return status;
    }
}
