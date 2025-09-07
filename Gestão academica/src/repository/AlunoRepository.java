package repository;

import model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {
    private List<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno aluno) {
        alunos.add(aluno);
    }

    public Aluno buscarPorMatricula(String matricula) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getMatricula().equals(matricula)) {
                return alunos.get(i);
            }
        }
        return null;
    }

    public List<Aluno> listarTodos() {
        return alunos;
    }
}