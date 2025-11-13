package Collections.InventoryManagementSystem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RecentlyViewItem {
    private LinkedList<Item> lru;
    private Integer MAX_SIZE;
    public  RecentlyViewItem(int size){
        lru=new LinkedList<>();
        this.MAX_SIZE=size;
    }
    public void addRecentlyViewedItem(Item item){
        //remove the item if exists;
        lru.remove(item);
        // adding the element in the front
        lru.addFirst(item);
        if(lru.size()>MAX_SIZE){
            lru.removeLast();
        }
    }
    public List<Item> getRecentlyViewedItem(){
        return new ArrayList<>(lru);
    }
}
