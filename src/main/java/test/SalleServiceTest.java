package test;

import entities.Salle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import services.SalleService;

import java.util.List;

import static org.junit.Assert.*;

public class SalleServiceTest {

    private SalleService salleService;
    private Salle salle;

    @Before
    public void setUp() {
        salleService = new SalleService();
        salle = new Salle();
        salle.setCode("SALLE-INFO-01");

        salleService.create(salle);
    }

    @After
    public void tearDown() {

        Salle foundSalle = salleService.findById(salle.getId());
        if (foundSalle != null) {
            salleService.delete(foundSalle);
        }
    }

    @Test
    public void testCreate() {
        assertNotNull("La salle devrait être créée avec un ID", salle.getId());
    }

    @Test
    public void testFindById() {
        Salle foundSalle = salleService.findById(salle.getId());
        assertNotNull("La salle devrait être trouvée", foundSalle);
        assertEquals("La salle trouvée devrait correspondre", salle.getCode(), foundSalle.getCode());
    }

    @Test
    public void testUpdate() {
        salle.setCode("SALLE-ADMIN-02"); // Nouveau code
        boolean result = salleService.update(salle);
        assertTrue("La salle devrait être mise à jour avec succès", result);

        Salle updatedSalle = salleService.findById(salle.getId());
        assertEquals("Le code de la salle mise à jour devrait correspondre", "SALLE-ADMIN-02", updatedSalle.getCode());
    }

    @Test
    public void testDelete() {
        boolean result = salleService.delete(salle);
        assertTrue("La salle devrait être supprimée avec succès", result);

        Salle foundSalle = salleService.findById(salle.getId());
        assertNull("La salle ne devrait pas être trouvée après suppression", foundSalle);
    }

    @Test
    public void testFindAll() {
        List<Salle> salles = salleService.findAll();
        assertNotNull("La liste des salles ne devrait pas être nulle", salles);
        assertTrue("La liste des salles devrait contenir au moins une salle", salles.size() > 0);
    }
}