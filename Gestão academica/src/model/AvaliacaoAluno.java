package model;

public class AvaliacaoAluno {
    private Aluno aluno;
    private Professor professor;
    private double nota;
    private String data;
    private String observacao;

    public AvaliacaoAluno(Aluno aluno, Professor professor, double nota, String data, String observacao) {
        this.aluno = aluno;
        this.professor = professor;
        this.nota = nota;
        this.data = data;
        this.observacao = observacao;
    }

    public Aluno getAluno() { return aluno; }
    public Professor getProfessor() { return professor; }
    public double getNota() { return nota; }
    public String getData() { return data; }
    public String getObservacao() { return observacao; }
}
