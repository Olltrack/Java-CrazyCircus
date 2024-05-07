package podiums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PodiumTest {
    @Test
    public void testAjouter() {
        Podium podium = new Podium();
        podium.ajouter(0);
        podium.ajouter(1);
        podium.ajouter(2);
        assertEquals("[lion, ours, elephant]", podium.toString());
    }

    @Test
    public void testDescendre() {
        Podium podium = new Podium();
        podium.ajouter(0);
        podium.ajouter(1);
        podium.ajouter(2);
        podium.descendre();
        podium.depiler();
        assertEquals("[ours, elephant]", podium.toString());
    }

    @Test
    public void testIndex() {
        Podium podium = new Podium();
        podium.ajouter(0);
        podium.ajouter(1);
        podium.ajouter(2);
        assertEquals(0, podium.index("lion"));
        assertEquals(1, podium.index("ours"));
        assertEquals(2, podium.index("elephant"));
    }

    @Test
    public void testDepiler() {
        Podium podium = new Podium();
        podium.ajouter(0);
        podium.ajouter(1);
        podium.ajouter(2);
        podium.depiler();
        assertEquals("[lion, ours]", podium.toString());
    }

    @Test
    public void testSommet() {
        Podium podium = new Podium();
        podium.ajouter(0);
        podium.ajouter(1);
        podium.ajouter(2);
        assertEquals("elephant", podium.sommet());
    }

    @Test
    public void testBase() {
        Podium podium = new Podium();
        podium.ajouter(0);
        podium.ajouter(1);
        podium.ajouter(2);
        assertEquals("lion", podium.base());
    }

    @Test
    public void testEstVide() {
        Podium podium = new Podium();
        assertTrue(podium.estVide());
        podium.ajouter(0);
        assertFalse(podium.estVide());
    }

    @Test
    public void testGetNb() {
        Podium podium = new Podium();
        assertEquals(0, podium.getNb());
        podium.ajouter(0);
        assertEquals(1, podium.getNb());
    }

    @Test
    public void testGetAnimal() {
        Podium podium = new Podium();
        podium.ajouter(0);
        podium.ajouter(1);
        podium.ajouter(2);
        assertEquals("lion", podium.getAnimal(0));
        assertEquals("ours", podium.getAnimal(1));
        assertEquals("elephant", podium.getAnimal(2));
    }
}