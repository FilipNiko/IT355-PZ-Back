package com.metropolitan.it355pzback;

import com.metropolitan.it355pzback.controller.StavkeController;
import com.metropolitan.it355pzback.data.entities.Stavke;
import com.metropolitan.it355pzback.service.StavkeService;
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
public class StavkeControllerTest {

    @Autowired
    private StavkeController stavkeController;

    @MockBean
    private StavkeService stavkeService;

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testGetAll() {

        Stavke stavka1 = new Stavke();
        Stavke stavka2 = new Stavke();
        List<Stavke> stavkeList = Arrays.asList(stavka1, stavka2);

        when(stavkeService.findAll()).thenReturn(stavkeList);

        ResponseEntity<List<Stavke>> response = stavkeController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stavkeList, response.getBody());
        verify(stavkeService, times(1)).findAll();
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testGetStavkaById() {

        int id = 1;
        Stavke stavka = new Stavke();

        when(stavkeService.findById(id)).thenReturn(Optional.of(stavka));

        ResponseEntity<Stavke> response = stavkeController.getStavkaById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stavka, response.getBody());
        verify(stavkeService, times(1)).findById(id);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testFindByPorudzbinaId() {

        int porudzbinaId = 1;
        List<Stavke> stavkeList = Arrays.asList(new Stavke());

        when(stavkeService.findByIdPorudzbine(porudzbinaId)).thenReturn(stavkeList);

        ResponseEntity<List<Stavke>> response = stavkeController.findByPorudzbinaId(porudzbinaId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stavkeList, response.getBody());
        verify(stavkeService, times(1)).findByIdPorudzbine(porudzbinaId);
    }

    @Test
    @WithMockUser(roles = "USER")
    public void testCreateStavka() {

        Stavke stavka = new Stavke();

        when(stavkeService.save(stavka)).thenReturn(stavka);

        ResponseEntity<Stavke> response = stavkeController.createStavka(stavka);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stavka, response.getBody());
        verify(stavkeService, times(1)).save(stavka);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testUpdateStavka() {

        Stavke stavka = new Stavke();

        when(stavkeService.update(stavka)).thenReturn(stavka);

        ResponseEntity<Stavke> response = stavkeController.updateStavka(stavka);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stavka, response.getBody());
        verify(stavkeService, times(1)).update(stavka);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testDeleteStavka() {

        int id = 1;

        doNothing().when(stavkeService).deleteById(id);

        ResponseEntity<HttpStatus> response = stavkeController.deleteStavka(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(stavkeService, times(1)).deleteById(id);
    }
}
