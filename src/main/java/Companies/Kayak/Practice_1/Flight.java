package Companies.Kayak.Practice_1;

public record Flight(int id, String airline, int price, int duration, int stops, String departure) {

    @Override
    public String toString() {
        return airline + " | $" + price + " | stops: " + stops + " | dep: " + departure;
    }
}