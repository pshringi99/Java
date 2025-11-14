package Collections.InventoryManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    static void main() {
        List<Item> items = new ArrayList<>();

        Book book = new Book("123","CLRS",300.10,1,"Dennis Richie");
        Clothing clothing = new Clothing("456","T-shirt",1200,12,"XL");
        Electronics electronics = new Electronics("33","PS3",200.9,11,3);
        Book java = new Book("B1", "Java Programming", 1599.99, 0, "John Doe");
        Clothing tShirt = new Clothing("C1", "T-Shirt", 19.99, 100, "M");
        items.add(book);
        items.add(clothing);
        items.add(electronics);
        int n=items.toArray().length;
        for(Item item:items){
            System.out.print(item.getName()+" ");
        }
        for(int i=1;i<n;i++){
            System.out.println(items.get(i-1).compareTo(items.get(i)));
        }
        Collections.sort(items);
        for(Item item:items){
            System.out.print(item.getName()+" ");
        }

        // we need to sort this by name lexographically;
        //        4 1 5 3 2 : 1 2 3 4 5

        Inventory<Electronics> inventory = new Inventory<>();

        Electronics laptop = new Electronics("E1", "Laptop", 0, 5, 24);
        Electronics mobilePhone = new Electronics("E2", "Mobile", 5000, 10, 12);
        Electronics earphones = new Electronics("E3", "Earphones", 500, 0, 12);

        try {
            inventory.addItem(laptop);
            inventory.addItem(mobilePhone);
            inventory.addItem(earphones);
        } catch (InvalidQuantityExecption ex){
            System.out.println(ex.getMessage());
        } catch (DuplicateItemExecption e) {
            throw new RuntimeException(e);
        }

        inventory.removeItem(mobilePhone);

        Electronics e1 =  inventory.getItem("E1");
        System.out.println(e1.getName());

        List<Electronics> itemsList = inventory.getAllItem();
        System.out.println("Printing all items in the inventory");
        for(Electronics item : itemsList) {
            System.out.println(item.getName());
        }

//        Test recently viewed items
        RecentlyViewItem recentlyViewItems = new RecentlyViewItem(10);

        recentlyViewItems.addRecentlyViewedItem(laptop);
        recentlyViewItems.addRecentlyViewedItem(mobilePhone);
        recentlyViewItems.addRecentlyViewedItem(earphones);
        recentlyViewItems.addRecentlyViewedItem(java);
        recentlyViewItems.addRecentlyViewedItem(earphones);

        for(Item item : recentlyViewItems.getRecentlyViewedItem()) {
            System.out.println(item.getName());
        }

//        Test Order and OrderProcessor

        OrderExpress orderProcessor = new OrderExpress();
        orderProcessor.addOrder(new Order("O1", true));
        orderProcessor.addOrder(new Order("O2", false));
        orderProcessor.addOrder(new Order("O3", false));
        orderProcessor.addOrder(new Order("O4", true));
        orderProcessor.addOrder(new Order("O5", false));

        while(orderProcessor.getSize() > 0){
            System.out.println(orderProcessor.processOrder().getOrderId());
        }
//        test sorting and filtering

        Inventory<Item> inventory2 = new Inventory<>();
//        opened the db connection
        try {
            inventory2.addItem(laptop);
            inventory2.addItem(mobilePhone);
            inventory2.addItem(earphones);
            inventory2.addItem(java);
            inventory2.addItem(tShirt);
//            trying to do something with db
        }  catch (DuplicateItemExecption e) {
            throw new RuntimeException(e);
        } catch (InvalidQuantityExecption e) {
            throw new RuntimeException(e);
        } finally {
//            finally block is always implemented after the try and catch
            System.out.println("Closing the db connection");
        }

        System.out.println("Closing the db connection");

        List<Item> affordableItems = inventory2.filterByPriceRange(0, 100.0);
        System.out.println("Affordable items");
        for (Item item : affordableItems) {
            System.out.println(item.getName());
        }

        List<Item> availableItems = inventory2.filterByAvailability();
        System.out.println("Available items");
        for (Item item : availableItems) {
            System.out.println(item.getName());
        }

        List<Item> sortedItems = inventory2.sortItem(new ItemQuantityComparator());
        System.out.println("Sorted items");
        for (Item item : sortedItems) {
            System.out.println(item.getName());
        }

//        WishList testing

        WishList<Item> wishList = new WishList();

        wishList.addToWishList(laptop);
        wishList.addToWishList(mobilePhone);
        wishList.addToWishList(earphones);

        System.out.println("Wish list");
        for (Item item : wishList.getWishListItems()){
            System.out.println(item.getName());
        }

        List<Item> itemsList1 = inventory2.getAllItem();
        System.out.println(itemsList1.size());
        System.out.println("Printing all items id in the inventory");



    }
}
