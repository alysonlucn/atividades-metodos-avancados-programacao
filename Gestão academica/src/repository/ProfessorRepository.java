package repository;

import model.Professor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {
    private List<Professor> professores = new ArrayList<>();

    public void salvar(Professor professor) {
        professores.add(professor);
    }

    public Professor buscarPorMatricula(String matricula) {
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getMatricula().equals(matricula)) {
                return professores.get(i);
            }
        }
        return null;
    }

    public List<Professor> listarTodos() {
        return professores;
    }
}