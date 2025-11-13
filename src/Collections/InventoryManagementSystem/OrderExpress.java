package Collections.InventoryManagementSystem;

import java.util.PriorityQueue;
import java.util.Queue;

public class OrderExpress {
    private Queue<Order> pq;

    public OrderExpress(){
        pq=new PriorityQueue<Order>();
    }
    public void addOrder(Order order){
        pq.add(order);
    }
    public Order processOrder(Order order){
        return pq.poll();
    }
    public int getSize(){
        return pq.size();
    }
}
