package model;

public class Pessoa {
    private String nome;
    private String dataNascimento;
    private final String matricula;

    public Pessoa(String nome, String dataNascimento, String matricula) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.matricula = matricula;
    }

    public String getNome() { return nome; }
    public String getDataNascimento() { return dataNascimento; }
    public String getMatricula() { return matricula; }
}