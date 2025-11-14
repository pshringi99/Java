package Collections.InventoryManagementSystem;

import java.util.*;

public class Inventory<T extends Item>{
    HashMap<String,T> inventory;

    public Inventory(){
        this.inventory = new HashMap<>();
    }
    public void addItem(T item) throws InvalidQuantityExecption, DuplicateItemExecption {
        if(item.getQuantity()<0){
            throw new InvalidQuantityExecption("Quantity less than equal to zero is invalid");
        }
        if(inventory.containsKey(item.getId())){
            throw  new DuplicateItemExecption("Item "+ item.getId()+" already exists.");
        }
        inventory.put(item.getId(),item);
    }
    public void removeItem(T item){
        inventory.remove(item.getId());
    }
    public T getItem(String id){
        return inventory.get(id);
    }
    public List<T> getAllItem(){
        return new ArrayList<>(inventory.values());
    }
    public List<T> filterByPriceRange(double minPrice,double maxPrice){
        List<T> filteredList = new ArrayList<>();
        for(T item: inventory.values()){
            if(minPrice<=item.getPrice() && item.getPrice()<maxPrice){
                filteredList.add(item);
            }
        }
        return filteredList;
    }
    public List<T> filterByAvailability(){
        List<T>filteredList = new ArrayList<>();
        for (T item: inventory.values()){
            if(item.getQuantity()>0){
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    public List<T> sortItem(Comparator<T> comparator){
        List<T> sortedItems = new ArrayList<>(inventory.values());
        Collections.sort(sortedItems,comparator);
        return sortedItems;
    }
}
