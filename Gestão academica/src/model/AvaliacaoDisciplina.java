package model;

public class AvaliacaoDisciplina {
    private Aluno aluno;
    private double nota;
    private String data;
    private String comentario;

    public AvaliacaoDisciplina(Aluno aluno, double nota, String data, String comentario) {
        this.aluno = aluno;
        this.nota = nota;
        this.data = data;
        this.comentario = comentario;
    }

    public Aluno getAluno() { return aluno; }
    public double getNota() { return nota; }
    public String getData() { return data; }
    public String getComentario() { return comentario; }
}