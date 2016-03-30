package com.autentia.demo.dao;

import java.util.List;

import com.autentia.demo.model.Curso;

public interface CursoDAO {
    List<Curso> find();

    Curso load(int id);

    void insert(Curso curso);

    void update(Curso curso);

    void delete(int id);
}
