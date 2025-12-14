package app;

import java.util.*;
import model.*;
import service.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<AirlineRule> rules = new ArrayList<>();
        List<Passenger> passengers = new ArrayList<>();
        BaggageService service = new BaggageService();

        while (true) {
            System.out.println("\n===== Airport Baggage System =====");
            System.out.println("1. Add Airline Rule");
            System.out.println("2. Add Passenger");
            System.out.println("3. Show Summary");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter airline name: ");
                    String airline = sc.nextLine();
                    System.out.print("Enter flight number: ");
                    String flight = sc.nextLine();
                    System.out.print("Enter baggage allowance (kg): ");
                    int allowance = sc.nextInt();
                    System.out.print("Enter penalty rate per kg: ");
                    double rate = sc.nextDouble();
                    sc.nextLine(); // consume newline
                    rules.add(new AirlineRule(airline, flight, allowance, rate));
                    System.out.println("Airline rule added successfully!");
                    break;

                case 2:
                    System.out.print("Enter passenger name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter flight number: ");
                    String pFlight = sc.nextLine();
                    System.out.print("Enter airline name: ");
                    String pAirline = sc.nextLine();
                    System.out.print("Enter baggage weight (kg): ");
                    double weight = sc.nextDouble();
                    sc.nextLine(); // consume newline
                    passengers.add(new Passenger(name, pFlight, pAirline, weight));
                    System.out.println("Passenger added successfully!");
                    break;

                case 3:
                    if (passengers.isEmpty() || rules.isEmpty()) {
                        System.out.println("No passengers or airline rules found!");
                        break;
                    }
                    List<PassengerResult> results = new ArrayList<>();
                    Map<String, Double> revenue = new HashMap<>();
                    for (Passenger p : passengers) {
                        PassengerResult r = service.processPassenger(p, rules);
                        results.add(r);
                        revenue.put(
                                p.getAirlineName(),
                                revenue.getOrDefault(p.getAirlineName(), 0.0) + r.getPenalty()
                        );
                    }

                    System.out.println("\nPassenger Summary:");
                    for (PassengerResult r : results) {
                        Passenger p = r.getPassenger();
                        System.out.println(p.getName() + " | " + p.getFlightNumber() + " | " +
                                p.getAirlineName() + " | " + p.getBaggageWeight() +
                                "kg | Penalty: " + r.getPenalty() + " | Status: " + r.getStatus());
                    }

                    System.out.println("\nAirline Revenue Summary:");
                    for (String a : revenue.keySet()) {
                        System.out.println(a + " : " + revenue.get(a));
                    }
                    break;

                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
