package Companies.Kayak.TakeHome;

import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class Solution {

    static class Price {
        public double BaseFare;
        public double Tax;
        public double TotalAmount;
        public String Currency;

        public boolean hasMismatch() {
            double calculated = Math.round((BaseFare + Tax) * 100.0) / 100.0;
            return Math.abs(calculated - TotalAmount) > 0.01;
        }

        public double calculatedTotal() {
            return Math.round((BaseFare + Tax) * 100.0) / 100.0;
        }
    }

    static class Segment {
        public String flightNumber;
        public String marketingAirline;
        public String departureAirport;
        public String arrivalAirport;
        public String departureDatetime;
        public String arrivalDatetime;
        public String fareBasis;
        public String cabin;

        public Duration getDuration() {
            LocalDateTime dep = LocalDateTime.parse(departureDatetime);
            LocalDateTime arr = LocalDateTime.parse(arrivalDatetime);
            return Duration.between(dep, arr);
        }
    }

    static class Flight {
        public Price price;
        public List<Segment> outbound;

        public Segment getLongestSegment() {
            if (outbound == null) return null;
            return outbound.stream()
                    .max(Comparator.comparing(Segment::getDuration))
                    .orElse(null);
        }
    }

    static class FlightData {
        public String error;
        public List<Flight> availableFlights;
    }

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        FlightData data = mapper.readValue(
                new File("src/main/resources/flight_data.json"), FlightData.class);

        List<Flight> flights = data.availableFlights;

        // Q1: Outbound flight count
        long outboundCount = flights.stream()
                .filter(f -> f.outbound != null)
                .mapToLong(f -> f.outbound.size())
                .sum();
        System.out.println("1. Outbound flights: " + outboundCount);

        // Q2: Cheapest outbound
        flights.stream()
                .min(Comparator.comparingDouble(f -> f.price.TotalAmount))
                .ifPresent(f -> System.out.printf("2. Cheapest outbound: $%.2f%n", f.price.TotalAmount));

        // Q3: Pricing mismatch
        flights.stream()
                .filter(f -> f.price.hasMismatch())
                .forEach(f -> System.out.printf(
                        "3. Mismatch: %.2f + %.2f = %.2f, but TotalAmount = %.2f%n",
                        f.price.BaseFare, f.price.Tax,
                        f.price.calculatedTotal(), f.price.TotalAmount));

        // Q4 BONUS: Longest flight by fare basis
        flights.stream()
                .filter(f -> f.outbound != null)
                .flatMap(f -> f.outbound.stream())
                .max(Comparator.comparing(Segment::getDuration))
                .ifPresent(s -> System.out.println("4. Longest flight fare basis: " + s.fareBasis));
    }
}