package podiums;

import java.util.ArrayList;
import java.util.Collections;


public class Carte {
    // tableau contenant les numéros de cartes disponibles
    private final static int[] cartes = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
    // liste contenant les cartes mélangées
    private static ArrayList<Integer> l;
    // numéro de la dernière carte tirée
    private static int d = 0;

    /**
     * méthode pour initialiser la liste de cartes mélangées
     */

    public static void initList(){
        l = new ArrayList<>();
        for(int i: cartes)
            l.add(i);
        Collections.shuffle(l);
    }
    /**
     * méthode pour distribuer la prochaine carte de la liste
     */
    public static void getCarte(){
        int c=l.get(0);
        l.remove(0);
        d=c;
    }
    /**
     * méthode pour obtenir le nombre de cartes restantes dans la liste
     */
    public static int getSize(){
        return l.size();
    }
    /**
     * méthode pour vérifier si la liste de cartes est vide
     */
    public static boolean estVide(){
        return l.isEmpty();
    }
    /** @param p : tableau de podiums
     *  @param i : indice du premier podium
     *  @param j : indice du deuxieme podium
     *  méthode pour initialiser les podiums selon le numéro de la dernière carte distribuée
     */
    public static void initCartes(Podium[] p, int i, int j) {
        switch (d) {
            case 1 -> {
                p[i].ajouter(0);
                p[i].ajouter(1);
                p[i].ajouter(2);
            }
            case 2 -> {
                p[i].ajouter(0);
                p[i].ajouter(1);
                p[j].ajouter(2);
            }
            case 3 -> {
                p[i].ajouter(0);
                p[j].ajouter(1);
                p[j].ajouter(2);
            }
            case 4 -> {
                p[j].ajouter(0);
                p[j].ajouter(1);
                p[j].ajouter(2);
            }
            case 5 -> {
                p[i].ajouter(1);
                p[i].ajouter(0);
                p[i].ajouter(2);
            }
            case 6 -> {
                p[i].ajouter(1);
                p[i].ajouter(0);
                p[j].ajouter(2);
            }
            case 7 -> {
                p[i].ajouter(1);
                p[j].ajouter(0);
                p[j].ajouter(2);
            }
            case 8 -> {
                p[j].ajouter(1);
                p[j].ajouter(0);
                p[j].ajouter(2);
            }
            case 9 -> {
                p[i].ajouter(1);
                p[i].ajouter(2);
                p[i].ajouter(0);
            }
            case 10 -> {
                p[i].ajouter(1);
                p[i].ajouter(2);
                p[j].ajouter(0);
            }
            case 11 -> {
                p[i].ajouter(1);
                p[j].ajouter(2);
                p[j].ajouter(0);
            }
            case 12 -> {
                p[j].ajouter(1);
                p[j].ajouter(2);
                p[j].ajouter(0);
            }
            case 13 -> {
                p[i].ajouter(0);
                p[i].ajouter(2);
                p[i].ajouter(1);
            }
            case 14 -> {
                p[i].ajouter(0);
                p[i].ajouter(2);
                p[j].ajouter(1);
            }
            case 15 -> {
                p[i].ajouter(0);
                p[j].ajouter(2);
                p[j].ajouter(1);
            }
            case 16 -> {
                p[j].ajouter(0);
                p[j].ajouter(2);
                p[j].ajouter(1);
            }
            case 17 -> {
                p[i].ajouter(2);
                p[i].ajouter(0);
                p[i].ajouter(1);
            }
            case 18 -> {
                p[i].ajouter(2);
                p[i].ajouter(0);
                p[j].ajouter(1);
            }
            case 19 -> {
                p[i].ajouter(2);
                p[j].ajouter(0);
                p[j].ajouter(1);
            }
            case 20 -> {
                p[j].ajouter(2);
                p[j].ajouter(0);
                p[j].ajouter(1);
            }
            case 21 -> {
                p[i].ajouter(2);
                p[i].ajouter(1);
                p[i].ajouter(0);
            }
            case 22 -> {
                p[i].ajouter(2);
                p[i].ajouter(1);
                p[j].ajouter(0);
            }
            case 23 -> {
                p[i].ajouter(2);
                p[j].ajouter(1);
                p[j].ajouter(0);
            }
            case 24 -> {
                p[j].ajouter(2);
                p[j].ajouter(1);
                p[j].ajouter(0);
            }


        }
    }
}
