package model;

public class Professor extends Pessoa {
    private String especializacao;
    private double salario;

    public Professor(String nome, String dataNascimento, String matricula, String especializacao, double salario) {
        super(nome, dataNascimento, matricula);
        this.especializacao = especializacao;
        this.salario = salario;
    }

    public String getEspecializacao() {
        return especializacao;
    }
    public double getSalario() { return salario; }
}