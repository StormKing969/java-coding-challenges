package Companies.Kayak.Practice_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FlightSearch {
    public List<Flight> filterFlights(List<Flight> flights, Integer maxPrice, Integer maxStops, String airline) {
        if (maxPrice == null && maxStops == null && airline == null) return flights;

        if (flights.isEmpty()) return new ArrayList<>();

        boolean hasPrice = maxPrice != null;
        boolean hasStops = maxStops != null;
        boolean hasAirline = airline != null;

        return flights.stream().filter((flight) -> {
            boolean checkedPrice = true;
            boolean checkedStops = true;
            boolean checkedAirline = true;
            if (hasPrice) {
                checkedPrice = flight.price() <= maxPrice;
            }

            if (hasStops) {
                checkedStops = flight.stops() <= maxStops;
            }

            if (hasAirline) {
                checkedAirline = flight.airline().equals(airline);
            }

            return checkedPrice && checkedStops && checkedAirline;
        }).toList();
    }

    public List<Flight> sortFlights(List<Flight> flights, String sortBy) {
        if (flights.isEmpty()) return new ArrayList<>();

        if (sortBy.isEmpty()) return flights;

        List<Flight> sortFlightList = new ArrayList<>(flights);
        if (sortBy.equals("price")) sortFlightList.sort(Comparator.comparing(Flight::price));
        else if (sortBy.equals("duration")) sortFlightList.sort(Comparator.comparing(Flight::duration));
        else sortFlightList.sort(Comparator.comparing(Flight::departure));

        return sortFlightList;
    }

    public List<Flight> searchFlights(List<Flight> flights, Integer maxPrice, Integer maxStops, String airline, String sortBy) {
        if (flights.isEmpty()) return new ArrayList<>();
        List<Flight> newFlightList = filterFlights(flights, maxPrice, maxStops, airline);

        return sortFlights(newFlightList, sortBy);
    }

    public Flight getBestValue(List<Flight> flights) {
        double bestValue = (double) flights.getFirst().price() / flights.getFirst().duration();
        int flightIndex = 0;
        for (int i = 0; i < flights.size(); i++) {
            double currentValue = (double) flights.get(i).price() / flights.get(i).duration();
            if (currentValue < bestValue) {
                bestValue = currentValue;
                flightIndex = i;
            }
        }

        return flights.get(flightIndex);
    }
}
