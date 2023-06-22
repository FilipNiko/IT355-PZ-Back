package com.metropolitan.it355pzback;

import com.metropolitan.it355pzback.controller.PovezController;
import com.metropolitan.it355pzback.data.entities.Povez;
import com.metropolitan.it355pzback.service.PovezService;
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
public class PovezControllerTest {

    @Autowired
    private PovezController povezController;

    @MockBean
    private PovezService povezService;


    @Test
    public void testGetAll() {

        Povez povez1 = new Povez();
        Povez povez2 = new Povez();
        List<Povez> poveziList = Arrays.asList(povez1, povez2);

        when(povezService.findAll()).thenReturn(poveziList);

        ResponseEntity<List<Povez>> response = povezController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(poveziList, response.getBody());
        verify(povezService, times(1)).findAll();
    }

    @Test
    public void testGetPovezById() {

        int id = 1;
        Povez povez = new Povez();

        when(povezService.findById(id)).thenReturn(Optional.of(povez));

        ResponseEntity<Povez> response = povezController.getPovezById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(povez, response.getBody());
        verify(povezService, times(1)).findById(id);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testCreatePovez() {

        Povez povez = new Povez();

        when(povezService.save(povez)).thenReturn(povez);

        ResponseEntity<Povez> response = povezController.createPovez(povez);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(povez, response.getBody());
        verify(povezService, times(1)).save(povez);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testUpdatePovez() {

        Povez povez = new Povez();

        when(povezService.update(povez)).thenReturn(povez);

        ResponseEntity<Povez> response = povezController.updatePovez(povez);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(povez, response.getBody());
        verify(povezService, times(1)).update(povez);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testDeletePovez() {

        int id = 1;

        doNothing().when(povezService).deleteById(id);

        ResponseEntity<HttpStatus> response = povezController.deletePovez(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(povezService, times(1)).deleteById(id);
    }


}
