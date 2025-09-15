import model.*;
import repository.*;
import service.*;


public class main {
    public static void main(String[] args) {
        OrderRepository repo = new OrderRepository();
        OrderService svc = new OrderService(repo);


        Order o = svc.criarPedido();
        svc.addItem(o, new Item("Coxinha", 5.0, 2));
        svc.addItem(o, new Item("Refri", 4.5, 1));


        svc.pagar(o);
        svc.imprimirRecibo(o);
    }
}