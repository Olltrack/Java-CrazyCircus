package jeu;

import java.util.Objects;

public class Joueur {
    //nom du joueur
    private String nomj;
    //score du joueur
    private int score;
    //nombre total de joueurs
    private static int nbj;
    //variable pour savoir si un joueur a joué ou non
    private int ajoue=0;

    /**
     * Constructeur de la classe Joueur
     * @param nom nom du joueur
     */
    public Joueur(String nom){
        nomj=nom;
        score=0;
    }
    public String getNomj(){
        return nomj;
    }

    /**
     * Méthode pour définir le nombre de joueurs à partir d'un tableau de noms de joueurs
     * @param arg tableau de String contenant les noms des joueurs
     */
    public static void setnbj(String[] arg){
        nbj = arg.length;
    }

    /**
     * Méthode pour récupérer le nombre de joueurs
     * @return le nombre de joueurs
     */
    public static int getNbj(){
        return nbj;
    }

    /**
     * Méthode pour indiquer qu'un joueur a joué
     */
    public void joue(){
        ajoue=1;
    }

    /**
     * Méthode pour indiquer qu'un joueur a fini de jouer
     */
    public void fini() {
        ajoue=0;
    }

    /**
     * Méthode pour vérifier si un joueur est en train de jouer
     * @return true si le joueur a dèja joué
     */
    public boolean ajoue(){
        return ajoue==1;
    }

    /**
     * Méthode pour récupérer le score du joueur
     * @return score du joueur
     */
    public int getScore(){
        return score;
    }

    /**
     * Méthode pour vérifier si le joueur peut jouer
     * @param s nom du joueur
     * @return true si le joueur existe et qu'il n'a pas encore joué
     */
    public boolean peut_jouer(String s){
        if(joueurexiste(s))
            return this.ajoue==0;
        return false;
    }

    /**
     * Méthode pour vérifier si le joueur existe
     * @param s nom du joueur
     * @return true si le joueur existe
     */
    public boolean joueurexiste(String s){
        return Objects.equals(nomj, s);
    }

    /**
     * Méthode pour augmenter le score du joueur de 1
     */
    public void scorePlus(){
        score+=1;
    }
}
