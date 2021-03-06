package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.DaoCursos;
import model.Curso;

@RestController
public class ServicioCursos {
	@Autowired
	DaoCursos daoCursos;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> getCursos(){
		return daoCursos.recuperarTodosCursos();
	}
	@GetMapping(value="{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@PathVariable("id") int idCurso) {
		return daoCursos.buscarCurso(idCurso);
	}
	
	@DeleteMapping(value="{id}")
	public void eliminarCurso(@PathVariable("id") int idCurso) {
		daoCursos.eliminarCurso(idCurso);
	}
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public void nuevoCurso(@RequestBody Curso curso) {
		daoCursos.altaCurso(curso);
	}
	
	@PutMapping(value="{id}/{nuevoNombre}")
	public void actualizarCurso(@PathVariable("id") int idCurso,
			@PathVariable("nuevoNombre") String nombre) {
		Curso curso=daoCursos.buscarCurso(idCurso);
		if(curso!=null) {
			curso.setDenominacion(nombre);
			daoCursos.actualizarCurso(curso);
		}
	}
	
}
