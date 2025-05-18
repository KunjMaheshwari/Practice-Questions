import java.util.*;

class HotelManager {

    private List<String> hotelList = new ArrayList<>();

    public void addHotelDetails(String hotelDetails) {
        hotelList.add(hotelDetails);
    }

    public List<String> getHotelByRating(double minRating) {
        List<String> filteredHotel = new ArrayList<>();

        if (minRating < 0) {
            System.out.println("Invalid Rating");
            return filteredHotel;
        }

        for (String hotel : hotelList) {
            String details[] = hotel.split(":");
            if (details.length == 2) {
                try {
                    double rating = Double.parseDouble(details[1].trim());
                    if (rating >= minRating) {
                        filteredHotel.add(details[0].trim());
                    }
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return filteredHotel;
    }
}

public class HotelRecommendationSystem {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        HotelManager manager = new HotelManager();

        System.out.println("Enter the number of hotels to be added");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Enter hotel details(name:rating)");
        for (int i = 0; i < n; i++) {
            String hotelDetails = sc.nextLine();
            manager.addHotelDetails(hotelDetails);
        }

        System.out.println("Enter the minimum rating");
        double minRating = sc.nextDouble();

        List<String> filteredHotels = manager.getHotelByRating(minRating);

        if (filteredHotels.isEmpty()) {
            System.out.printf("No hotels were found with minimum rating of %.1f\n", minRating);
        } else {
            System.out.printf("Hotels with a rating of at least %.1f\n", minRating);
            for (String hotel : filteredHotels) {
                System.out.println(hotel);
            }
        }

        sc.close(); // good practice to close Scanner
    }
}