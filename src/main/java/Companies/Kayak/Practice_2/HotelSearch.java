package Companies.Kayak.Practice_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HotelSearch {
    List<Hotel> filterHotels(List<Hotel> hotels, String city, Integer maxPrice,
                             Double minRating, List<String> requiredAmenities) {
        if (hotels.isEmpty()) return new ArrayList<>();

        if (city == null && maxPrice == null && minRating == null && requiredAmenities == null) return hotels;

        boolean includeCity = city != null;
        boolean includeMaxPrice = maxPrice != null;
        boolean includeMinRating = minRating != null;
        boolean includeRequiredAmenities = requiredAmenities != null;

        return hotels.stream().filter(hotel -> {
            boolean filteredCity = true;
            boolean filteredMaxPrice = true;
            boolean filteredMinRating = true;
            boolean filteredRequiredAmenities = true;

            if (includeCity) {
                filteredCity = hotel.city.equals(city);
            }

            if (includeMaxPrice) {
                filteredMaxPrice = hotel.pricePerNight <= maxPrice;
            }

            if (includeMinRating) {
                filteredMinRating = hotel.rating >= minRating;
            }

            if (includeRequiredAmenities) {
                for (String ele : requiredAmenities) {
                    if (!hotel.amenities.contains(ele)) {
                        filteredRequiredAmenities = false;
                        break;
                    }
                }
            }

            return filteredCity && filteredMaxPrice && filteredMinRating && filteredRequiredAmenities;
        }).toList();
    }

    public List<Hotel> sortHotels(List<Hotel> hotels, String sortBy) {
        if (hotels.isEmpty()) return new ArrayList<>();

        if (sortBy.isEmpty()) return hotels;

        List<Hotel> sortedHotels = new ArrayList<>(hotels);

        if (sortBy.equals("price")) {
            sortedHotels.sort(Comparator.comparingInt(a -> a.pricePerNight));
        } else if (sortBy.equals("rating")) {
            sortedHotels.sort(Comparator.comparingDouble(a -> a.rating));
        } else {
            sortedHotels.sort(Comparator.comparingInt(a -> a.distanceFromCenter));
        }

        return sortedHotels;
    }
}
