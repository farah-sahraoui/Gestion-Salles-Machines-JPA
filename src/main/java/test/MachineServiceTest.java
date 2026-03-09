package test;

import entities.Machine;
import entities.Salle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import services.MachineService;
import services.SalleService;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class MachineServiceTest {

    private MachineService machineService;
    private Machine machine;
    private Salle salle;
    private SalleService salleService;

    @Before
    public void setUp() {
        machineService = new MachineService();
        salleService = new SalleService();
        salle = new Salle("SALLE-TP-202");

        salleService.create(salle);

        machine = new Machine();
        machine.setRef("PC-PORTABLE-4592");
        machine.setDateAchat(new Date());
        machine.setSalle(salle);

        machineService.create(machine);
    }

    @After
    public void tearDown() {

        Machine foundMachine = machineService.findById(machine.getId());
        if (foundMachine != null) {
            machineService.delete(foundMachine);
        }

        Salle foundSalle = salleService.findById(salle.getId());
        if (foundSalle != null) {
            salleService.delete(foundSalle);
        }
    }

    @Test
    public void testCreate() {
        assertNotNull("La machine devrait être créée avec un ID", machine.getId());
    }

    @Test
    public void testFindById() {
        Machine foundMachine = machineService.findById(machine.getId());
        assertNotNull("La machine devrait être trouvée", foundMachine);
        assertEquals("La machine trouvée devrait correspondre", machine.getRef(), foundMachine.getRef());
    }

    @Test
    public void testUpdate() {
        machine.setRef("PC-BUREAU-7831");
        boolean result = machineService.update(machine);
        assertTrue("La machine devrait être mise à jour avec succès", result);

        Machine updatedMachine = machineService.findById(machine.getId());
        assertEquals("La référence de la machine mise à jour devrait correspondre", "PC-BUREAU-7831", updatedMachine.getRef());
    }

    @Test
    public void testDelete() {
        boolean result = machineService.delete(machine);
        assertTrue("La machine devrait être supprimée avec succès", result);

        Machine foundMachine = machineService.findById(machine.getId());
        assertNull("La machine ne devrait pas être trouvée après suppression", foundMachine);
    }

    @Test
    public void testFindBetweenDate() {
        List<Machine> machines = machineService.findBetweenDate(
                new Date(System.currentTimeMillis() - 86400000),
                new Date()
        );
        assertNotNull("La liste des machines ne devrait pas être nulle", machines);
        assertTrue("La liste des machines devrait contenir au moins une machine", machines.size() > 0);
    }
}