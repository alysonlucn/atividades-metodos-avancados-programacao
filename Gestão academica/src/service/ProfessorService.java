package service;

import model.Professor;
import repository.ProfessorRepository;

public class ProfessorService {
    private ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public void cadastrarProfessor(String nome, String dataNasc, String matricula, String especializacao, double salario) {
        if (repository.buscarPorMatricula(matricula) != null) {
            System.out.println("Erro: Professor com matrícula " + matricula + " já existe!");
            return;
        }
        repository.salvar(new Professor(nome, dataNasc, matricula, especializacao, salario));
        System.out.println("Professor cadastrado com sucesso!");
    }

    public Professor buscarProfessor(String matricula) {
        return repository.buscarPorMatricula(matricula);
    }

    public void listarProfessores() {
        System.out.println("Lista de Professores:");
        for (Professor professor : repository.listarTodos()) {
            System.out.println(" - " + professor);
        }
    }
}