package hello.core.order;

public interface OrderService {
    Order createOrder(Long memderID, String itemName, int itemPrice);
}
