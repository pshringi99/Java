package Collections.InventoryManagementSystem;

public class Item implements Comparable<Item>{
    private String id;
    private String name;
    private double price;
    private int quantity;

    public Item(String id, String name, double price, int quantity){
        this.id=id;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    String getId(){
        return id;
    }

    String getName(){
        return name;
    }

    double getPrice(){
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Item o) {
        if(this.price <o.price){
            return -1;
        }
        else if(this.price>o.price){
            return 1;
        }
        else{
            if (this.quantity<o.quantity){
                return -1;
            }
            else if(this.quantity>o.quantity){
                return 1;
            }
            else return 0;
        }
    }
    /*
this.compareTo(other)

< 0 -> current object is smaller than the other object -> | this ... other|
= 0 -> both items are equal -> |this ... other | or | other ... this |
> 0 -> current object is greater than the other object -> | other ... this |
 */
}
