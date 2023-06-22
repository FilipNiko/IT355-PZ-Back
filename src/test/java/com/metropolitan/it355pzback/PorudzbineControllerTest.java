package com.metropolitan.it355pzback;


import com.metropolitan.it355pzback.controller.PorudzbineController;
import com.metropolitan.it355pzback.data.entities.Porudzbine;
import com.metropolitan.it355pzback.service.PorudzbineService;
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
public class PorudzbineControllerTest {

    @Autowired
    private PorudzbineController porudzbineController;

    @MockBean
    private PorudzbineService porudzbineService;


    @Test
    @WithMockUser(roles = "ADMIN")
    public void testGetAll() {

        Porudzbine porudzbine1 = new Porudzbine();
        Porudzbine porudzbine2 = new Porudzbine();
        List<Porudzbine> porudzbineList = Arrays.asList(porudzbine1, porudzbine2);

        when(porudzbineService.findAll()).thenReturn(porudzbineList);

        ResponseEntity<List<Porudzbine>> response = porudzbineController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(porudzbineList, response.getBody());
        verify(porudzbineService, times(1)).findAll();
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testGetAllDesc() {

        Porudzbine porudzbine1 = new Porudzbine();
        Porudzbine porudzbine2 = new Porudzbine();
        List<Porudzbine> porudzbineList = Arrays.asList(porudzbine2, porudzbine1);

        when(porudzbineService.findAllOrderDescById()).thenReturn(porudzbineList);

        ResponseEntity<List<Porudzbine>> response = porudzbineController.getAllDesc();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(porudzbineList, response.getBody());
        verify(porudzbineService, times(1)).findAllOrderDescById();
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testFindByAllCriteria() {

        String kriterijum = "kriterijum pretrage";
        List<Porudzbine> porudzbineList = Arrays.asList(new Porudzbine());

        when(porudzbineService.findByAllCriteria(kriterijum)).thenReturn(porudzbineList);

        ResponseEntity<List<Porudzbine>> response = porudzbineController.findByAllCriteria(kriterijum);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(porudzbineList, response.getBody());
        verify(porudzbineService, times(1)).findByAllCriteria(kriterijum);
    }

    @Test
    @WithMockUser(roles = "USER")
    public void testGetPorudzbinaById() {

        int id = 1;
        Porudzbine porudzbina = new Porudzbine();

        when(porudzbineService.findById(id)).thenReturn(Optional.of(porudzbina));

        ResponseEntity<Porudzbine> response = porudzbineController.getKPorudzbinaById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(porudzbina, response.getBody());
        verify(porudzbineService, times(1)).findById(id);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testFindByKorisnikId() {

        int korisnikId = 1;
        List<Porudzbine> porudzbineList = Arrays.asList(new Porudzbine());

        when(porudzbineService.findByIdKorisnika(korisnikId)).thenReturn(porudzbineList);

        ResponseEntity<List<Porudzbine>> response = porudzbineController.findByKorisnikId(korisnikId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(porudzbineList, response.getBody());
        verify(porudzbineService, times(1)).findByIdKorisnika(korisnikId);
    }

    @Test
    @WithMockUser(roles = "USER")
    public void testCreatePorudzbina() {
        Porudzbine porudzbina = new Porudzbine();

        when(porudzbineService.save(porudzbina)).thenReturn(porudzbina);

        ResponseEntity<Porudzbine> response = porudzbineController.createPorudzbina(porudzbina);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(porudzbina, response.getBody());
        verify(porudzbineService, times(1)).save(porudzbina);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testUpdatePorudzbina() {
        Porudzbine porudzbina = new Porudzbine();

        when(porudzbineService.update(porudzbina)).thenReturn(porudzbina);

        ResponseEntity<Porudzbine> response = porudzbineController.updatePorudzbina(porudzbina);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(porudzbina, response.getBody());
        verify(porudzbineService, times(1)).update(porudzbina);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testDeletePorudzbina() {
        int id = 1;

        doNothing().when(porudzbineService).deleteById(id);

        ResponseEntity<HttpStatus> response = porudzbineController.deletePorudzbina(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(porudzbineService, times(1)).deleteById(id);
    }


}
