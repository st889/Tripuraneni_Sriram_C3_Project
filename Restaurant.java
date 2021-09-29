import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();
   // List<String> menu_names = new ArrayList<>();
    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        if(getCurrentTime().isAfter(openingTime) && getCurrentTime().isBefore(closingTime)){
            return true;
        }
        else{
            return false;
        }
        //return true;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    }

    public static LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {


        return menu;
        //return null;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
        //menu_names.add(name);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
        //menu_names.remove(itemName);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }
    /*public static void main(String[] args){
        Restaurant r = new Restaurant("Savitri", "Bengaluru",LocalTime.parse("10:00:00"),LocalTime.parse("22:00:00"));
        r.addToMenu("Dosa", 5000);
        System.out.println(r.getMenu());
    }*/
}

