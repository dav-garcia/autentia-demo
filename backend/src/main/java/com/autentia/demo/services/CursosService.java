package com.autentia.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.autentia.demo.dao.CursoDAO;
import com.autentia.demo.model.Curso;

@Service
public class CursosService {

    private CursoDAO cursoDAO;

    @Autowired
    public CursosService(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    public List<Curso> getCursos() {
        return cursoDAO.find();
    }

    public Curso getCurso(int id) {
        return cursoDAO.load(id);
    }

    @Transactional
    public void saveCurso(Curso curso) {
        if (curso.getId() > 0) {
            cursoDAO.update(curso);
        } else {
            cursoDAO.insert(curso);
        }
    }

    @Transactional
    public void deleteCurso(Curso curso) {
        cursoDAO.delete(curso.getId());
    }
}
