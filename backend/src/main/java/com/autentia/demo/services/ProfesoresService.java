package com.autentia.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.autentia.demo.dao.ProfesorDAO;
import com.autentia.demo.model.Profesor;

@Service
public class ProfesoresService {

    private ProfesorDAO profesorDAO;

    @Autowired
    public ProfesoresService(ProfesorDAO profesorDAO) {
        this.profesorDAO = profesorDAO;
    }

    public List<Profesor> getProfesores() {
        return profesorDAO.find();
    }

    public Profesor getProfesor(int id) {
        return profesorDAO.load(id);
    }

    @Transactional
    public void saveProfesor(Profesor profesor) {
        if (profesor.getId() > 0) {
            profesorDAO.update(profesor);
        } else {
            profesorDAO.insert(profesor);
        }
    }

    @Transactional
    public void deleteProfesor(Profesor profesor) {
        profesorDAO.delete(profesor.getId());
    }
}
