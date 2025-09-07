package repository;

import model.Disciplina;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaRepository {
    private List<Disciplina> disciplinas = new ArrayList<>();

    public void salvar(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public Disciplina buscarPorCodigo(String codigo) {
        for (int i = 0; i < disciplinas.size(); i++) {
            if (disciplinas.get(i).getCodigo().equals(codigo)) {
                return disciplinas.get(i);
            }
        }
        return null;
    }

    public List<Disciplina> listarTodos() {
        return disciplinas;
    }
}