package repository;


import model.Order;
import java.util.*;


public class OrderRepository {
    private final Map<UUID, Order> store = new HashMap<>();

    public void save(Order o) {
        store.put(o.getId(), o);
    }
    public Order find(UUID id) {
        return store.get(id);
    }
}