package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Curso;
@Repository
public class DaoCursosImpl implements DaoCursos {
	@PersistenceContext()
	EntityManager em;
	
	@Transactional	
	public void altaCurso(Curso c) {
		em.persist(c);

	}
	
	@Transactional	
	public void actualizarCurso(Curso c) {
		if(em.find(Curso.class,c.getIdCurso())!=null) {
			em.merge(c);
		}
		

	}
	
	@Transactional	
	public void eliminarCurso(int idCurso) {
		Curso curso=em.find(Curso.class, idCurso);
		if(curso!=null) {
			em.remove(curso);
		}

	}

	
	public Curso buscarCurso(int idCurso) {		
		return em.find(Curso.class, idCurso);
	}

	
	public List<Curso> recuperarTodosCursos() {
		String jpql="Select c From Curso c";
		Query query=em.createQuery(jpql);
		return (List<Curso>)query.getResultList();
	}

}
