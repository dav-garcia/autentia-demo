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

import com.autentia.demo.model.Profesor;
import com.autentia.demo.services.ProfesoresService;

@RestController
public class ProfesoresController {
    private static final Logger LOG = Logger.getLogger(ProfesoresController.class.getName());

    private ProfesoresService profesoresService;

    @Autowired
    public ProfesoresController(ProfesoresService profesoresService) {
        this.profesoresService = profesoresService;
    }

    @RequestMapping(value = "/profesor", method = RequestMethod.GET)
    public ResponseEntity<List<Profesor>> getProfesores() {
        List<Profesor> profesores = profesoresService.getProfesores();
        return (profesores.isEmpty() ? new ResponseEntity<List<Profesor>>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(profesores, HttpStatus.OK));
    }

    @RequestMapping(value = "/profesor/{id}", method = RequestMethod.GET)
    public ResponseEntity<Profesor> getProfesor(@PathVariable("id") int id) {
        Profesor profesor = profesoresService.getProfesor(id);
        return (profesor == null ? new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(profesor, HttpStatus.OK));
    }

    @RequestMapping(value = "/profesor", method = RequestMethod.POST)
    public ResponseEntity<Profesor> createProfesor(@RequestBody Profesor profesor, UriComponentsBuilder ucBuilder) {
        Profesor actual = profesoresService.getProfesor(profesor.getId());
        if (actual != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        LOG.fine("Insertando nuevo profesor...");
        profesoresService.saveProfesor(profesor);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/profesor/{id}").buildAndExpand(profesor.getId()).toUri());
        return new ResponseEntity<>(profesor, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/profesor/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Profesor> updateProfesor(@PathVariable("id") int id, @RequestBody Profesor profesor) {
        Profesor actual = profesoresService.getProfesor(profesor.getId());
        if (actual == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        LOG.fine("Actualizando profesor: " + profesor.getId());
        actual.copyFrom(profesor);
        profesoresService.saveProfesor(actual);
        return new ResponseEntity<>(actual, HttpStatus.OK);
    }

    @RequestMapping(value = "/profesor/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Profesor> deleteProfesor(@PathVariable("id") int id) {
        Profesor actual = profesoresService.getProfesor(id);
        if (actual == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        LOG.fine("Eliminando profesor: " + id);
        profesoresService.deleteProfesor(actual);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
