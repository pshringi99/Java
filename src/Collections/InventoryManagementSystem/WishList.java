package Collections.InventoryManagementSystem;

import java.util.HashSet;
import java.util.Set;

public class WishList<T extends Item> {
    private Set<T> wishlist;

    public WishList(){
        wishlist= new HashSet<>();
    }

    public boolean addToWishList(T item){
        return wishlist.add(item);
    }

    public boolean removeFromWishList(T item){
        return wishlist.remove(item);
    }
}
