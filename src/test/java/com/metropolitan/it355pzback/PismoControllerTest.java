package com.metropolitan.it355pzback;

import com.metropolitan.it355pzback.controller.PismaController;
import com.metropolitan.it355pzback.data.entities.Pisma;
import com.metropolitan.it355pzback.service.PismaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PismoControllerTest {

    @Autowired
    private PismaController pismaController;

    @MockBean
    private PismaService pismaService;


    @Test
    public void testGetAll() {

        Pisma pismo1 = new Pisma();
        Pisma pismo2 = new Pisma();
        List<Pisma> pismaList = Arrays.asList(pismo1, pismo2);

        when(pismaService.findAll()).thenReturn(pismaList);

        ResponseEntity<List<Pisma>> response = pismaController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(pismaList, response.getBody());
        verify(pismaService, times(1)).findAll();
    }

    @Test
    public void testGetPismoById() {

        int id = 1;
        Pisma pismo = new Pisma();

        when(pismaService.findById(id)).thenReturn(Optional.of(pismo));

        ResponseEntity<Pisma> response = pismaController.getPismoById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(pismo, response.getBody());
        verify(pismaService, times(1)).findById(id);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testCreatePismo() {

        Pisma pismo = new Pisma();

        when(pismaService.save(pismo)).thenReturn(pismo);

        ResponseEntity<Pisma> response = pismaController.createPismo(pismo);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(pismo, response.getBody());
        verify(pismaService, times(1)).save(pismo);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testUpdatePismo() {

        Pisma pismo = new Pisma();

        when(pismaService.update(pismo)).thenReturn(pismo);

        ResponseEntity<Pisma> response = pismaController.updatePismo(pismo);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(pismo, response.getBody());
        verify(pismaService, times(1)).update(pismo);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testDeletePismo() {

        int id = 1;

        doNothing().when(pismaService).deleteById(id);

        ResponseEntity<HttpStatus> response = pismaController.deletePismo(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(pismaService, times(1)).deleteById(id);
    }

}
