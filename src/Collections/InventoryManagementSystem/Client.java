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



    }
}
