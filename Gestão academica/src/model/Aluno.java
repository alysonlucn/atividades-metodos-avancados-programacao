package model;

public class Aluno extends Pessoa {
    private String curso;

    public Aluno(String nome, String dataNascimento, String matricula, String curso) {
        super(nome, dataNascimento, matricula);
        this.curso = curso;
    }

    public String getCurso() { return curso; }
}