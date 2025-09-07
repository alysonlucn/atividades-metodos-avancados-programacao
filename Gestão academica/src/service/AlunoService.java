package service;

import model.Aluno;
import repository.AlunoRepository;

public class AlunoService {
    private AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public void cadastrarAluno(String nome, String dataNasc, String matricula, String curso) {
        if (repository.buscarPorMatricula(matricula) != null) {
            System.out.println("Erro: Aluno com matrícula " + matricula + " já existe!");
            return;
        }
        repository.salvar(new Aluno(nome, dataNasc, matricula, curso));
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public Aluno buscarAluno(String matricula) {
        return repository.buscarPorMatricula(matricula);
    }

    public void listarAlunos() {
        System.out.println("Lista de Alunos:");
        for (Aluno aluno : repository.listarTodos()) {
            System.out.println(" - " + aluno);
        }
    }
}