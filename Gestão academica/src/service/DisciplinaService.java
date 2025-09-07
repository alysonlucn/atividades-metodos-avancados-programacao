package service;

import model.Aluno;
import model.AvaliacaoAluno;
import model.AvaliacaoDisciplina;
import model.Disciplina;
import model.Professor;
import repository.DisciplinaRepository;

public class DisciplinaService {
    private DisciplinaRepository repository;

    public DisciplinaService(DisciplinaRepository repository) {
        this.repository = repository;
    }

    public void cadastrarDisciplina(String codigo, String nome) {
        Disciplina disciplina = repository.buscarPorCodigo(codigo);
        if (disciplina != null) {
            System.out.println("Erro: Disciplina com código " + codigo + " já existe!");
            return;
        }
        repository.salvar(new Disciplina(codigo, nome));
        System.out.println("Disciplina cadastrada com sucesso!");
    }

    public Disciplina buscarDisciplina(String codigo) {
        return repository.buscarPorCodigo(codigo);
    }

    public void definirProfessor(String codigo, Professor professor) {
        Disciplina disciplina = repository.buscarPorCodigo(codigo);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada!");
            return;
        }
        disciplina.setProfessor(professor);
        System.out.println("Professor " + professor.getNome() + " definido para " + disciplina.getNome());
    }

    public void matricularAluno(String codigo, Aluno aluno) {
        Disciplina disciplina = repository.buscarPorCodigo(codigo);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada!");
            return;
        }

        if (aluno == null) {
            System.out.println("Aluno inválido!");
            return;
        }
        disciplina.adicionarAluno(aluno);
        System.out.println(aluno.getNome() + " matriculado(a) em " + disciplina.getNome());
    }

    public void avaliarAluno(String codigo, Aluno aluno, Professor professor, double nota, String data, String obs) {
        Disciplina disciplina = repository.buscarPorCodigo(codigo);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada!");
            return;
        }

        if (aluno == null || professor == null) {
            System.out.println("Aluno/Professor inválido!");
            return;
        }

        boolean matriculado = false;
        for (int i = 0; i < disciplina.getAlunos().size(); i++) {
            if (disciplina.getAlunos().get(i).equals(aluno)) {
                matriculado = true;
                break;
            }
        }

        if (!matriculado) {
            System.out.println("Aluno não está matriculado na disciplina!");
            return;
        }

        disciplina.adicionarAvaliacaoAluno(new AvaliacaoAluno(aluno, professor, nota, data, obs));
        System.out.println("Nota " + nota + " registrada para " + aluno.getNome() + " em " + disciplina.getNome());
    }

    public void avaliarDisciplina(String codigo, Aluno aluno, double nota, String data, String comentario) {
        Disciplina disciplina = repository.buscarPorCodigo(codigo);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada!");
            return;
        }

        if (aluno == null) {
            System.out.println("Aluno inválido!");
            return;
        }

        disciplina.adicionarAvaliacaoDisciplina(new AvaliacaoDisciplina(aluno, nota, data, comentario));
        System.out.println(aluno.getNome() + " avaliou " + disciplina.getNome() + " com nota " + nota);
    }

    public void gerarRelatorioDisciplina(String codigo) {
        Disciplina disciplina = repository.buscarPorCodigo(codigo);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada!");
            return;
        }

        System.out.println("\n================= RELATÓRIO DA DISCIPLINA =================");
        System.out.println("Nome: " + disciplina.getNome());
        System.out.println("Código: " + disciplina.getCodigo());
        System.out.println("Professor: " + (disciplina.getProfessor() != null ? disciplina.getProfessor().getNome() : "(não definido)"));

        System.out.println("\nAlunos e suas notas (professor → aluno):");
        for (int i = 0; i < disciplina.getAlunos().size(); i++) {
            Aluno aluno = disciplina.getAlunos().get(i);
            double soma = 0.0;
            int quantidade = 0;

            for (int j = 0; j < disciplina.getAvaliacoesAlunos().size(); j++) {
                AvaliacaoAluno avaliacaoAluno = disciplina.getAvaliacoesAlunos().get(j);
                if (avaliacaoAluno.getAluno().equals(aluno)) {
                    soma += avaliacaoAluno.getNota();
                    quantidade++;
                }
            }

            if (quantidade == 0) {
                System.out.println(" - " + aluno.getNome() + ": (sem avaliação)");
            } else {
                double mediaAluno = soma / quantidade;
                System.out.println(" - " + aluno.getNome() + ": " + mediaAluno);
            }
        }

        double somaDisciplina = 0.0;
        int quantidadeDisciplina = 0;
        for (int k = 0; k < disciplina.getAvaliacoesDisciplina().size(); k++) {
            somaDisciplina += disciplina.getAvaliacoesDisciplina().get(k).getNota();
            quantidadeDisciplina++;
        }
        double mediaDisciplina = (quantidadeDisciplina == 0) ? 0.0 : (somaDisciplina / quantidadeDisciplina);

        System.out.println("\nMédia da disciplina (notas dos alunos para a disciplina): " + mediaDisciplina);
        System.out.println("===========================================================\n");
    }
}