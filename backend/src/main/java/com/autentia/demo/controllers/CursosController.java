package com.autentia.demo.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.autentia.demo.model.Curso;
import com.autentia.demo.services.CursosService;

@RestController
public class CursosController {
    private static final Logger LOG = Logger.getLogger(CursosController.class.getName());

    private CursosService cursosService;

    @Autowired
    public CursosController(CursosService cursosService) {
        this.cursosService = cursosService;
    }

    @RequestMapping(value = "/curso", method = RequestMethod.GET)
    public ResponseEntity<List<Curso>> getCursos() {
        List<Curso> cursos = cursosService.getCursos();
        return (cursos.isEmpty() ? new ResponseEntity<List<Curso>>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(cursos, HttpStatus.OK));
    }

    @RequestMapping(value = "/curso/{id}", method = RequestMethod.GET)
    public ResponseEntity<Curso> getCurso(@PathVariable("id") int id) {
        Curso curso = cursosService.getCurso(id);

        return (curso == null ? new ResponseEntity<Curso>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(curso, HttpStatus.OK));
    }

    @RequestMapping(value = "/curso", method = RequestMethod.POST)
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso, UriComponentsBuilder ucBuilder) {
        Curso actual = cursosService.getCurso(curso.getId());
        if (actual != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        LOG.fine("Insertando nuevo curso...");
        cursosService.saveCurso(curso);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/curso/{id}").buildAndExpand(curso.getId()).toUri());
        return new ResponseEntity<>(curso, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/curso/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Curso> updateCurso(@PathVariable("id") int id, @RequestBody Curso curso) {
        Curso actual = cursosService.getCurso(curso.getId());
        if (actual == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        LOG.fine("Actualizando curso: " + curso.getId());
        actual.copyFrom(curso);
        cursosService.saveCurso(actual);
        return new ResponseEntity<>(actual, HttpStatus.OK);
    }

    @RequestMapping(value = "/curso/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Curso> deleteCurso(@PathVariable("id") int id) {
        Curso actual = cursosService.getCurso(id);
        if (actual == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        LOG.fine("Eliminando curso: " + id);
        cursosService.deleteCurso(actual);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
