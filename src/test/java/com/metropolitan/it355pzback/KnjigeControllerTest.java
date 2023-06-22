package com.metropolitan.it355pzback;

import com.metropolitan.it355pzback.controller.KnjigeController;
import com.metropolitan.it355pzback.data.entities.Knjige;
import com.metropolitan.it355pzback.service.KnjigeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class KnjigeControllerTest {

    @Autowired
    private KnjigeController knjigeController;

    @MockBean
    private KnjigeService knjigeService;


    @Test
    void testGetAll() {

        List<Knjige> knjigeList = new ArrayList<>();
        knjigeList.add(new Knjige());
        knjigeList.add(new Knjige());
        when(knjigeService.findAll()).thenReturn(knjigeList);

        ResponseEntity<List<Knjige>> response = knjigeController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(knjigeList, response.getBody());
        verify(knjigeService, times(1)).findAll();
    }


    @Test
    void testGetLimited() {

        int limit = 4;
        Pageable pageable = PageRequest.of(0, limit);
        List<Knjige> limitedKnjigeList = new ArrayList<>();
        limitedKnjigeList.add(new Knjige());
        limitedKnjigeList.add(new Knjige());
        when(knjigeService.findAll(pageable)).thenReturn(new PageImpl<>(limitedKnjigeList));

        ResponseEntity<List<Knjige>> response = knjigeController.getLimited(limit);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(limitedKnjigeList, response.getBody());
        verify(knjigeService, times(1)).findAll(pageable);
    }


    @Test
    void testFindByAllCriteria() {

        String kriterijum = "kriterijum pretrage";
        List<Knjige> knjigeList = new ArrayList<>();
        knjigeList.add(new Knjige());
        when(knjigeService.findLikeNazivOrAutorOrOpis(kriterijum)).thenReturn(knjigeList);

        ResponseEntity<List<Knjige>> response = knjigeController.findByAllCriteria(kriterijum);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(knjigeList, response.getBody());
        verify(knjigeService, times(1)).findLikeNazivOrAutorOrOpis(kriterijum);
    }

    @Test
    void testFindByKategorijaId() {

        int idKategorije = 1;
        List<Knjige> knjigeList = new ArrayList<>();
        knjigeList.add(new Knjige());
        when(knjigeService.findByKategorijaId(idKategorije)).thenReturn(knjigeList);

        ResponseEntity<List<Knjige>> response = knjigeController.findByKategorijaId(idKategorije);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(knjigeList, response.getBody());
        verify(knjigeService, times(1)).findByKategorijaId(idKategorije);
    }


    @Test
    void testGetKnjigaById() {
        int id = 1;
        Knjige knjiga = new Knjige();
        when(knjigeService.findById(id)).thenReturn(Optional.of(knjiga));

        ResponseEntity<Knjige> response = knjigeController.getKnjigaById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(knjiga, response.getBody());
        verify(knjigeService, times(1)).findById(id);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void testCreateKnjiga() {

        Knjige knjiga = new Knjige();
        when(knjigeService.save(knjiga)).thenReturn(knjiga);

        ResponseEntity<Knjige> response = knjigeController.createKnjiga(knjiga);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(knjiga, response.getBody());
        verify(knjigeService, times(1)).save(knjiga);
    }

    @Test
    @WithMockUser(roles = "USER")
    void testUpdateKnjiga() {

        Knjige knjiga = new Knjige();
        when(knjigeService.update(knjiga)).thenReturn(knjiga);

        ResponseEntity<Knjige> response = knjigeController.updateKnjiga(knjiga);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(knjiga, response.getBody());
        verify(knjigeService, times(1)).update(knjiga);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void testDeleteKnjiga() {

        int id = 1;
        doNothing().when(knjigeService).deleteById(id);

        ResponseEntity<HttpStatus> response = knjigeController.deleteKnjiga(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(knjigeService, times(1)).deleteById(id);
    }

}
