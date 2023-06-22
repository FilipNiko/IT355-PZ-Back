package com.metropolitan.it355pzback;


import com.metropolitan.it355pzback.controller.KategorijeController;
import com.metropolitan.it355pzback.data.entities.Kategorije;
import com.metropolitan.it355pzback.service.KategorijeService;
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
public class KategorijaControllerTest {

    @Autowired
    KategorijeController kategorijeController;

    @MockBean
    private KategorijeService kategorijeService;

    @Test
    public void testGetAll() {

        Kategorije kategorija1 = new Kategorije();
        Kategorije kategorija2 = new Kategorije();
        List<Kategorije> kategorijeList = Arrays.asList(kategorija1, kategorija2);

        when(kategorijeService.findAll()).thenReturn(kategorijeList);

        ResponseEntity<List<Kategorije>> response = kategorijeController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(kategorijeList, response.getBody());
        verify(kategorijeService, times(1)).findAll();
    }

    @Test
    public void testGetKategorijaById() {

        int id = 1;
        Kategorije kategorija = new Kategorije();

        when(kategorijeService.findById(id)).thenReturn(Optional.of(kategorija));

        ResponseEntity<Kategorije> response = kategorijeController.getKategorijaById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(kategorija, response.getBody());
        verify(kategorijeService, times(1)).findById(id);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testCreateKategorija() {

        Kategorije kategorija = new Kategorije();

        when(kategorijeService.save(kategorija)).thenReturn(kategorija);

        ResponseEntity<Kategorije> response = kategorijeController.createKategorija(kategorija);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(kategorija, response.getBody());
        verify(kategorijeService, times(1)).save(kategorija);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testUpdateKategorija() {

        Kategorije kategorija = new Kategorije();

        when(kategorijeService.update(kategorija)).thenReturn(kategorija);

        ResponseEntity<Kategorije> response = kategorijeController.updateKategorija(kategorija);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(kategorija, response.getBody());
        verify(kategorijeService, times(1)).update(kategorija);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testDeleteKategorija() {

        int id = 1;

        doNothing().when(kategorijeService).deleteById(id);

        ResponseEntity<HttpStatus> response = kategorijeController.deleteKategorija(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(kategorijeService, times(1)).deleteById(id);
    }

}
