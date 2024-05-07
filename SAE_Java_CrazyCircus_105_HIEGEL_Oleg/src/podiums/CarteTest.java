package podiums;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class CarteTest {

    private Podium[] podiums;

    @Before
    public void setUp() {
        podiums = new Podium[3];
        for (int i = 0; i < podiums.length; i++) {
            podiums[i] = new Podium();
        }
    }

    @Test
    public void testInitList() {
        Carte.initList();
        assertEquals(24, Carte.getSize());
        assertFalse(Carte.estVide());
    }

    @Test
    public void testGetCarte() {
        Carte.initList();
        int size = Carte.getSize();
        for (int i = 0; i < size; i++) {
            Carte.getCarte();
            assertEquals(size - i - 1, Carte.getSize());
        }
        assertTrue(Carte.estVide());
    }

    @Test
    public void testInitCartes() {
        Carte.initList();
        int i = 0;
        int j = 1;
        Carte.getCarte();
        Carte.initCartes(podiums, i, j);
        assertFalse(podiums[0].estVide() && podiums[1].estVide());
    }
}