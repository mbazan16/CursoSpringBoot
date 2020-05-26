package dao;

import java.util.List;

import model.Curso;

public interface DaoCursos {
	void altaCurso(Curso c);
	void actualizarCurso(Curso c);
	void eliminarCurso(int idCurso);
	Curso buscarCurso(int idCurso);
	List<Curso> recuperarTodosCursos();
}
