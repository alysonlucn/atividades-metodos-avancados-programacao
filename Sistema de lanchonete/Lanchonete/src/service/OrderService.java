package service;


import model.*;
import repository.OrderRepository;


public class OrderService {
    private final OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public Order criarPedido() {
        Order o = new Order(); repo.save(o);
        return o;
    }

    public void addItem(Order o, Item i) {
        o.addItem(i); repo.save(o);
    }

    public void pagar(Order o) {
        o.setStatus(Order.Status.PAGO);
        repo.save(o);
    }

    public void imprimirRecibo(Order o) {
        System.out.println("Pedido: "+o.getId());
        o.getItems().forEach(System.out::println);
        System.out.println("TOTAL: R$"+o.total());
        System.out.println("STATUS: "+o.getStatus());
    }
}