package model;

/**
 * Created by paulo on 08/05/17.
 */
public class No {

    int key;

    private String name;

    No filhoEsquerdo;

    No filhoDireito;

    No(int key, String name) {

        this.key = key;

        this.name = name;

    }

    public String toString() {

        return name + " has the key " + key;

        /*
218
         * return name + " has the key " + key + "\nLeft Child: " + filhoEsquerdo +
219
         * "\nRight Child: " + filhoDireito + "\n";
220
         */

    }

}
