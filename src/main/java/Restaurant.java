import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen(boolean b) {


        if (LocalTime.now().isAfter(openingTime) && LocalTime.now().isBefore(closingTime))
            return true;
        else
            return false;



        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    }




    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        return Collections
                .unmodifiableList(menu);
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
    }



    //it should fail when no item are selected
    // second  case give total amount then the items are selected



    public int calculateTotalCost(int totalCost )
    {
        int item = 0;
        if ( item !=0 ){
        for ( item = 1;  item ==0; item ++) {
            totalCost =  Item.Prices() + totalCost;
        }
        }
        else {
            System.out.println("no item selected");
        }
        return totalCost;
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
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
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


}
