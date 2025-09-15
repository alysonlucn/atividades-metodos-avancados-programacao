package model;


import java.util.*;


public class Order {
    public enum Status {ABERTO, PAGO}
    private final UUID id = UUID.randomUUID();
    private final List<Item> items = new ArrayList<>();
    private Status status = Status.ABERTO;


    public UUID getId() { return id; }
    public Status getStatus() { return status; }
    public void setStatus(Status s) { this.status = s; }
    public List<Item> getItems() { return items; }

    public void addItem(Item i) {
        items.add(i);
    }

    public double total() {
        return items.stream().mapToDouble(Item::subtotal).sum();
    }
}