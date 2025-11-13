package Collections.InventoryManagementSystem;

public class Order implements Comparable<Order>{
    private String orderId;
    private boolean isExpress;// true for express order and false for regular ones

    public Order(String orderId,boolean isExpress){
        this.orderId=orderId;
        this.isExpress=isExpress;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setExpress(boolean express) {
        isExpress = express;
    }

    public String getOrderId() {
        return orderId;
    }
    public boolean getIsExpress(){
        return isExpress;
    }

    @Override
    public int compareTo(Order o) {
        if(this.isExpress == o.isExpress){
            return this.orderId.compareTo(o.orderId);
        } else if (this.isExpress) {
            return -1;
        }
        else return 1;
    }
}
