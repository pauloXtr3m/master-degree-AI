package Model;

/**
 * Created by paulo on 19/04/17.
 */
public class Individuo {
    private long x, y;

    public Individuo(){


        int sinal1 = (int)randSinal();
        int sinal2 = (int)randSinal();

        this.x = (long)(Math.random()*100);
        this.y = (long)(Math.random()*100);

        this.x = converteSinal(x, sinal1);
        this.y = converteSinal(y, sinal2);


    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    public static Individuo parseIndividuo(Object object){
        return (Individuo) object;
    }

    private static long randSinal(){
        return Math.round(Math.random()*1);
    }
    private static long converteSinal(long valor, int sinal){
        if(sinal == 1) {
            return valor;
        } else {
            return -valor;
        }

    }

}
