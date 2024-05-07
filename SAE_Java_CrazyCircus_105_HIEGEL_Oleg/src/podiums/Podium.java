package podiums;

public class Podium{
    /** Nombre maximal d'animaux qu'un podium peut supporter. */
    private static final int MAX = 3;
    /** Animaux supportés par la tour (chacun étant désigné par son nom). */
    private final static String[] ANIMAUX = {"lion","ours","elephant"};
    private String[] animals;
    /** Nombre d'animaux supportés par le podium. */
    private int nb;

    /**
     * Construit un podium vide de tout animal.
     */
    public Podium(){
        nb=0;
        animals = new String[MAX];
    }

    /**
     * @param position indice du nom de l'animal
     * ajoute un animal a la position donnée (0, 1 ou 2)
     * */
    public void ajouter(int position){

        animals[nb++] = ANIMAUX[position];
    }

    /**
     * Méthode pour descendre tous les animaux d'un rang dans le podium
     */
    public void descendre(){
        for(int i=0;i<MAX-1;++i)
            animals[i]=animals[i+1];
    }

    /**
     * @param s nom de l'animal
     * renvoie la position de l'animal (0, 1 ou 2)
     * */
    public int index(String s){
        assert(s!=null);
        for(int i=0;i< MAX;++i)
            if(s.equals(ANIMAUX[i]))
                return i;
        return 0;
    }

    /**
     * Méthode pour afficher les animaux dans un podium
     * @return String avec les animaux d'un podium
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < nb; ++i) {
            if (i != 0)
                sb.append(", ");
            sb.append(animals[i]);
        }
        return sb.toString() + "]";
    }

    /**
     * Méthode pour enlever un animal d'un podium
     */
    public void depiler() {
        assert ! estVide();
        nb--;
    }

    /**
     * Méthode pour avoir l'animal au sommet du podium
     * @return String l'animal au sommet du podium
     */
    public String sommet() {
        assert ! estVide();
        return animals[nb-1];
    }

    /**
     * Méthode pour avoir l'animal a la base du podium
     * @return String l'animal a la base du podium
     */
    public String base(){
        return animals[0];
    }

    /**
     * Méthode pour vérifier si le podium est vide
     * @return true si il n'y a pas d'aniamux dans le podium
     */
    public boolean estVide() {
        return nb == 0;
    }

    /**
     * Méthode pour obtenir le nombre d'animaux dans le podium
     * @return int nb
     */
    public int getNb() {
        return nb;
    }

    /**
     * Méthode pour obtenir le nom de l'animal à la position demandée
     * @param i position dans le podium
     * @return String nom de l'animal
     */
    public String getAnimal(int i){
        return animals[i];
    }
}
