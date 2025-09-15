package model;


public class Item {
    private final String nome;
    private final double preco;
    private final int qtd;

    public Item(String nome, double preco, int qtd) {
        this.nome = nome; this.preco = preco; this.qtd = qtd;
    }

    public double subtotal() {
        return preco * qtd;
    }

    @Override public String toString() {
        return nome+" x"+qtd+" = R$"+subtotal();
    }
}