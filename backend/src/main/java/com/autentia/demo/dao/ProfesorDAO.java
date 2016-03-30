package com.autentia.demo.dao;

import java.util.List;

import com.autentia.demo.model.Profesor;

public interface ProfesorDAO {
    List<Profesor> find();

    Profesor load(int id);

    void insert(Profesor profesor);

    void update(Profesor profesor);

    void delete(int id);
}
