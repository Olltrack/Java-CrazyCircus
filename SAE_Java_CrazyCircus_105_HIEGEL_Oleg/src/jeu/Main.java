package jeu;


import podiums.Carte;
import podiums.Podium;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    /**
     * Déplace l'élément au sommet du podium "de" vers le podium "vers".
     *
     * @param de Le podium de départ.
     * @param vers Le podium d'arrivée.
     */
    private static void bouger(Podium de, Podium vers) {
        assert ! de.estVide();
        int d = de.index(de.sommet());
        de.depiler();
        vers.ajouter(d);
    }
    /**
     * Déplace l'élément à la base du podium "p" sur le dessus du podium
     * et déplace l'élément qui se trouvait au sommet sur la base du podium.
     *
     * @param p Le podium dont on veut déplacer les éléments.
     */
    private static void remonter(Podium p){
        int tmp=p.index(p.base());
        p.descendre();
        p.depiler();
        p.ajouter(tmp);
    }
    /**
     * Échange les éléments en haut des podiums "p1" et "p2".
     *
     * @param p1 Le premier podium.
     * @param p2 Le deuxième podium.
     */
    private static void echange(Podium p1, Podium p2){
        int tmp=p1.index(p1.sommet());
        p1.depiler();
        p1.ajouter(p2.index(p2.sommet()));
        p2.depiler();
        p2.ajouter(tmp);
    }
    /**
     * Exécute la commande spécifiée par la chaîne de caractères "s"
     * sur les podiums "p".
     *
     * @param p Les podiums sur lesquels on veut exécuter la commande.
     * @param s La commande à exécuter.
     */
    private static void commandes(Podium[] p,String s){
        switch (s) {
            case "KI" -> {
                bouger(p[0], p[1]);
                return;
            }
            case "LO" -> {
                bouger(p[1], p[0]);
                return;
            }
            case "SO" -> {
                echange(p[0], p[1]);
                return;
            }
            case "NI" -> {
                remonter(p[0]);
                return;
            }
            case "MA" -> {
                remonter(p[1]);
                return;
            }
            default -> {
                System.out.println("Commande inconnue");
            }
        }

    }
    /**
     * Méthode qui exécute une série de commandes pour avancer le jeu.
     * @param p un tableau de 4 Podiums représentant l'état actuel du jeu.
     * @param s une chaîne de caractères représentant les commandes à exécuter.
     * @param Tcommande un entier représentant l'indice de départ des commandes à exécuter dans la chaîne s.
     */
    public static void action(Podium[] p, String s, int Tcommande){
        int T = 2;
        for(;Tcommande<s.length(); Tcommande += T)
            commandes(p, s.substring(Tcommande, Tcommande + T));
    }
    /**
     * Méthode qui vérifie si les deux premiers Podiums sont identiques aux deux derniers.
     * @param p un tableau de 4 Podiums représentant l'état actuel du jeu.
     * @return true si les deux premiers Podiums sont identiques aux deux derniers, false sinon.
     */
    public static boolean reussite(Podium[] p){
        for (int i=0; i<2;++i)
            for(int j=0; j<p[i].getNb();++j) {
                if (!Objects.equals(p[i].getAnimal(j), p[i + 2].getAnimal(j)))
                    return false;

            }
        return true;
    }
    /**
     * Méthode qui affiche le nom d'un animal dans un Podium.
     * @param p un Podium contenant l'animal à afficher.
     * @param i l'indice de l'animal à afficher dans le Podium.
     */
    private static void afficheAnimal(Podium p, int i){
        if (!Objects.equals(p.getAnimal(i), "elephant")){
            System.out.print("  ");
        }
        System.out.print(p.getAnimal(i));
        if (!Objects.equals(p.getAnimal(i), "elephant")){
            System.out.print("  ");
        }
    }
    /**
     * Méthode qui vérifie si tous les joueurs sauf un ont joué au moins une fois.
     * @param joueurs un tableau de joueurs représentant les joueurs dans le jeu.
     * @return true si tous les joueurs sauf un ont joué, false sinon.
     */
    private static boolean dernierJoueur(Joueur[] joueurs){
        int cpt=0;
        for(Joueur j:joueurs)
            if(j.ajoue())
                cpt+=1;
        return cpt == Joueur.getNbj() - 1;
    }
    /**
     * Méthode qui affiche le contenu des Podiums et le menu de commandes.
     * @param podiums un tableau de 4 Podiums représentant l'état actuel du jeu.
     * @param d l'indice de l'animal à afficher dans chaque Podium.
     */
    private static void afficher(Podium[] podiums, int d){
            int cpt=0;
            for(Podium p : podiums){
                cpt+=1;
                if (cpt==3)
                    System.out.print("       ");
                if(p.getNb()>d){
                    afficheAnimal(p,d);
                }
                else
                    System.out.print("        ");
            }

    }
    /**
     * Méthode qui affiche le menu de commandes.
     * @param sl une chaîne de caractères représentant le joueur actuel.
     */
    private static void afficherMenu(String sl){
        System.out.print("    ----    ----    ==>    ----    ----    ");
        System.out.print(sl);
        System.out.println("    BLEU    ROUGE          BLEU    ROUGE   ");
        System.out.println("--------------------------------------------");
        System.out.println("KI : BLEU --> ROUGE NI : BLEU ^");
        System.out.println("LO : BLEU <-- ROUGE MA : ROUGE ^");
        System.out.println("SO : BLEU <-> ROUGE");
    }

    /**
     * Affiche tous les podiums et le menu
     * @param podiums tableau contenant les podiums à afficher
     * @param sl String contenant un saut de ligne
     */
    private static void affichage(Podium[] podiums, String sl){
        for(int i=2;i>=0;--i){
            System.out.print("  ");
            afficher(podiums,i);
            System.out.print(sl);
        }
        afficherMenu(sl);
    }
    public static void main(String[] args){
        String sl=System.getProperty("line.separator");

        //Initialiser les joueurs

        if(args.length==0)
            System.out.println("Il n'y a aucun joueur !");
        Joueur.setnbj(args);
        final int TAILLE1=Joueur.getNbj();
        Joueur[] joueurs = new Joueur[TAILLE1];
        for(int i=0;i<TAILLE1;++i){
            joueurs[i]= new Joueur(args[i]);
        }

        Scanner sc = new Scanner(System.in);

        //Initialiser les podiums

        final int TAILLE2 = 4;
        Podium[] podiums = new Podium[TAILLE2];
        podiums[0] = new Podium();
        podiums[1] = new Podium();
        podiums[2] = new Podium();
        podiums[3] = new Podium();

        //Melanger les cartes, puis obtenir la carte de départ

        Carte.initList();
        Carte.getCarte();
        Carte.initCartes(podiums,0,1);

        do {
            Carte.getCarte();
            podiums[2] = new Podium();
            podiums[3] = new Podium();
            Carte.initCartes(podiums,2,3); //tirer les podiums objectif

            do {
                affichage(podiums, sl);
                int numj = 0;
                String s = sc.nextLine();
                int espaceIndex = s.indexOf(' ');
                String premierePartie = s.substring(0, espaceIndex);
                String deuxiemePartie = s.substring(espaceIndex + 1); //découper la chaine entrée par l'utilisateur en 2 parties : nom du joueur et commandes


                for (int i = 0; i < TAILLE1; ++i) {
                    if (Objects.equals(joueurs[i].getNomj(), premierePartie)) { //verifier si le joueur a deja joué
                        if(joueurs[i].peut_jouer(premierePartie))
                            numj = i;
                        else
                            System.out.println("Ce joueur a deja joue");
                    }
                }


                if (!dernierJoueur(joueurs) && joueurs[numj].peut_jouer(premierePartie) ) { //le joueur peut jouer
                    action(podiums, deuxiemePartie, 0);
                    joueurs[numj].joue();
                }
                if(dernierJoueur(joueurs)) { //si c'est le dernier joueur, recuperer son indice
                    for (int i = 0; i < Joueur.getNbj(); ++i)
                        if (!joueurs[i].ajoue()) {
                            numj = i;
                        }
                }
                else if (!joueurs[numj].joueurexiste(premierePartie))
                    System.out.println("Ce joueur n'existe pas");


                if(reussite(podiums) || dernierJoueur(joueurs)){        //si c'est le dernier joueur ou si la sequence est bonne
                    System.out.println("Manche remportee par : "+joueurs[numj].getNomj());
                    joueurs[numj].scorePlus();
                    podiums[0] = new Podium();
                    podiums[1] = new Podium();
                    Carte.initCartes(podiums,0,1);
                }
                else
                    System.out.println("Sequence incorrecte");

            }while(!reussite(podiums)); //boucle tant que les podiums ne sont pas identiques
            for(Joueur j : joueurs){ //fin de tour, les joueurs peuvent rejouer
                j.fini();
            }
        }while(!Carte.estVide());

        int scoremax=0;
        for(int i=0;i<TAILLE1;++i){
            if(joueurs[i].getScore() > joueurs[scoremax].getScore()) //recuperer le joueur avec le plus haut score
                scoremax=i;
        }
        System.out.println(joueurs[scoremax].getNomj() + " a gagne !");

    }
}