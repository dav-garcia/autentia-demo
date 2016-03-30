package com.autentia.demo.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.autentia.demo.dao.CursoDAO;
import com.autentia.demo.model.Curso;
import com.autentia.demo.services.CursosService;

public class CursosTest {
    @Mock
    private Curso curso;
    @Mock
    private CursoDAO cursoDAO;
    private CursosService servicio;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        servicio = new CursosService(cursoDAO);
    }

    @Test
    public void testCreate() {
        Assert.assertNotNull(cursoDAO);
        Assert.assertNotNull(curso);
    }

    @Test
    public void testLoad() {
        Mockito.when(curso.getId()).thenReturn(1);
        Mockito.when(cursoDAO.load(1)).thenReturn(curso);
        Curso elem = servicio.getCurso(1);
        Mockito.verify(cursoDAO).load(1);
        Assert.assertNotNull(elem);
        Assert.assertEquals(elem.getId(), 1);
    }
}
