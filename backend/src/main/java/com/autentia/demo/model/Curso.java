package com.autentia.demo.model;

public class Curso {
    private int id;
    private String titulo;
    private boolean activo;
    private int horas;
    private NivelCurso nivel;
    private Profesor profesor;

    public Curso() {
        // Vacío.
    }

    public Curso(int id, String titulo, boolean activo, int horas, NivelCurso nivel, Profesor profesor) {
        this.id = id;
        this.titulo = titulo;
        this.activo = activo;
        this.horas = horas;
        this.nivel = nivel;
        this.profesor = profesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public NivelCurso getNivel() {
        return nivel;
    }

    public void setNivel(NivelCurso nivel) {
        this.nivel = nivel;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void copyFrom(Curso curso) {
        titulo = curso.titulo;
        activo = curso.activo;
        horas = curso.horas;
        nivel = curso.nivel;
        profesor = curso.profesor;
    }
}
