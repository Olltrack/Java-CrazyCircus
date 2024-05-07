package jeu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JoueurTest {

    @Test
    public void testGetNomj() {
        Joueur j = new Joueur("Jean");
        assertEquals("Jean", j.getNomj());
    }

    @Test
    public void testSetNbj() {
        String[] noms = {"Jean", "Marie", "Pierre"};
        Joueur.setnbj(noms);
        assertEquals(3, Joueur.getNbj());
    }

    @Test
    public void testJoue() {
        Joueur j = new Joueur("Jean");
        assertFalse(j.ajoue());
        j.joue();
        assertTrue(j.ajoue());
        j.fini();
        assertFalse(j.ajoue());
    }

    @Test
    public void testPeutJouer() {
        String[] noms = {"Jean", "Marie", "Pierre"};
        Joueur.setnbj(noms);

        Joueur j1 = new Joueur("Jean");
        assertFalse(j1.peut_jouer("Marie"));
        assertTrue(j1.peut_jouer("Jean"));
        j1.joue();
        assertFalse(j1.peut_jouer("Jean"));
    }

    @Test
    public void testScorePlus() {
        Joueur j = new Joueur("Jean");
        assertEquals(0, j.getScore());
        j.scorePlus();
        assertEquals(1, j.getScore());
        j.scorePlus();
        assertEquals(2, j.getScore());
    }

}