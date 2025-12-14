package service;

import java.util.*;
import model.*;

public class BaggageService {

    public PassengerResult processPassenger(Passenger p, List<AirlineRule> rules) {
        AirlineRule matchedRule = null;

        for (AirlineRule rule : rules) {
            if (rule.getAirlineName().equalsIgnoreCase(p.getAirlineName()) &&
                rule.getFlightNumber().equalsIgnoreCase(p.getFlightNumber())) {
                matchedRule = rule;
                break;
            }
        }

        if (matchedRule == null) {
            return new PassengerResult(p, 0, "No Rule Found");
        }

        double excess = p.getBaggageWeight() - matchedRule.getBaggageAllowance();
        if (excess <= 0) {
            return new PassengerResult(p, 0, "Within Limit");
        }

        double penalty = excess * matchedRule.getPenaltyRate();
        return new PassengerResult(p, penalty, "Exceeded Limit");
    }
}
