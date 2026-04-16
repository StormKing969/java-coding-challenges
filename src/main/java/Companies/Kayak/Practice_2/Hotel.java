package Companies.Kayak.Practice_2;

import java.util.List;

public class Hotel {
    int id;
    String name;
    String city;
    double rating;      // 1.0 - 5.0
    int pricePerNight;
    List<String> amenities; // e.g. ["wifi", "pool", "gym", "parking"]
    int distanceFromCenter; // in meters

    public Hotel(int id, String name, String city, double rating,
                 int pricePerNight, List<String> amenities, int distanceFromCenter) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.rating = rating;
        this.pricePerNight = pricePerNight;
        this.amenities = amenities;
        this.distanceFromCenter = distanceFromCenter;
    }
}