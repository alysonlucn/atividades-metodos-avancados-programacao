package view;

import model.Aluno;
import model.Professor;
import repository.AlunoRepository;
import repository.ProfessorRepository;
import repository.DisciplinaRepository;
import service.AlunoService;
import service.ProfessorService;
import service.DisciplinaService;

public class Main {
    public static void main(String[] args) {

        // Repositórios
        AlunoRepository alunoRepo = new AlunoRepository();
        ProfessorRepository professorRepo = new ProfessorRepository();
        DisciplinaRepository disciplinaRepo = new DisciplinaRepository();

        // Serviços
        AlunoService alunoService = new AlunoService(alunoRepo);
        ProfessorService professorService = new ProfessorService(professorRepo);
        DisciplinaService disciplinaService = new DisciplinaService(disciplinaRepo);

        // =========================
        // Cadastro inicial
        // =========================
        System.out.println("\n--- Cadastro de Alunos ---");
        alunoService.cadastrarAluno("João", "01/01/2000", "A001", "Engenharia");
        alunoService.cadastrarAluno("Maria", "02/02/2001", "A002", "Medicina");
        alunoService.cadastrarAluno("Duplicado", "03/03/2002", "A001", "Direito"); // <- erro

        System.out.println("\n--- Cadastro de Professores ---");
        professorService.cadastrarProfessor("Dr. Carlos", "10/10/1980", "P001", "Matemática", 5000.0);
        professorService.cadastrarProfessor("Duplicado", "11/11/1981", "P001", "Física", 6000.0); // <- erro

        System.out.println("\n--- Cadastro de Disciplinas ---");
        disciplinaService.cadastrarDisciplina("D001", "Cálculo I");
        disciplinaService.cadastrarDisciplina("D001", "Duplicada"); // <- deve dar erro

        // =========================
        // Vínculos
        // =========================
        System.out.println("\n--- Vínculos ---");
        Professor prof = professorService.buscarProfessor("P001");
        disciplinaService.definirProfessor("D001", prof);

        Aluno a1 = alunoService.buscarAluno("A001");
        Aluno a2 = alunoService.buscarAluno("A002");

        disciplinaService.matricularAluno("D001", a1);
        disciplinaService.matricularAluno("D001", a2);

        // =========================
        // Avaliações
        // =========================
        System.out.println("\n--- Avaliações ---");
        disciplinaService.avaliarAluno("D001", a1, prof, 8.5, "01/09/2025", "Prova 1");
        disciplinaService.avaliarAluno("D001", a2, prof, 7.0, "01/09/2025", "Prova 1");

        disciplinaService.avaliarDisciplina("D001", a1, 9.0, "01/09/2025", "Excelente disciplina!");
        disciplinaService.avaliarDisciplina("D001", a2, 8.0, "01/09/2025", "Boa, mas difícil.");

        // =========================
        // Relatório
        // =========================
        System.out.println("\n--- Relatório da Disciplina ---");
        disciplinaService.gerarRelatorioDisciplina("D001");
    }
}