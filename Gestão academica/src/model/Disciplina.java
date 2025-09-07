package model;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String codigo;
    private String nome;
    private Professor professor;
    private List<Aluno> alunos;
    private List<AvaliacaoAluno> avaliacoesAlunos;
    private List<AvaliacaoDisciplina> avaliacoesDisciplina;

    public Disciplina(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.alunos = new ArrayList<>();
        this.avaliacoesAlunos = new ArrayList<>();
        this.avaliacoesDisciplina = new ArrayList<>();
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }
    public List<Aluno> getAlunos() { return alunos; }
    public List<AvaliacaoAluno> getAvaliacoesAlunos() { return avaliacoesAlunos; }
    public List<AvaliacaoDisciplina> getAvaliacoesDisciplina() { return avaliacoesDisciplina; }

    public void adicionarAluno(Aluno aluno) {
        boolean existe = false;
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).equals(aluno)) { existe = true; break; }
        }
        if (!existe) alunos.add(aluno);
    }

    public void adicionarAvaliacaoAluno(AvaliacaoAluno av) {
        avaliacoesAlunos.add(av);
    }

    public void adicionarAvaliacaoDisciplina(AvaliacaoDisciplina av) {
        avaliacoesDisciplina.add(av);
    }
}
