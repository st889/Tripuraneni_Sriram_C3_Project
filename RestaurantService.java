import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();
    Exception restaurantNotFoundException;

    public static Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        String rname_given, rname_list;
        for(int i=0;i<restaurants.size();i++){
            rname_given = restaurantName.toUpperCase();
            rname_list = restaurants.get(i).getName().toUpperCase();
            if(rname_given.equals(rname_list)){
                return restaurants.get(i);
            }
        }
            throw new restaurantNotFoundException(restaurantName);
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    }


    public static Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
    /*public static void main(String[] args){
        System.out.println("Savitri".toUpperCase());
        String n1 = "Savitri".toUpperCase();
        String n2 = "savitri".toUpperCase();
        if(n1.equals(n2)){
            System.out.println("Yes");
        }
        addRestaurant("Jasmine","tnk",LocalTime.now(),LocalTime.NOON);
        restaurants.get(0).addToMenu("Idly",5000);
        restaurants.get(0).addToMenu("Dosa",7000);
        System.out.println(restaurants.get(0).getMenu());
        try {
            System.out.println(findRestaurantByName("Jasmine"));
        } catch (restaurantNotFoundException e) {
            e.printStackTrace();
        }

    }*/
}
