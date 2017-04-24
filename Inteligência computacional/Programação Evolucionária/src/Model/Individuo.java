package Model;

/**
 * Created by paulo on 19/04/17.
 */
public class Individuo {
    private long x, y;

    public Individuo(){
        this.x = (long)(Math.random()*Long.MAX_VALUE);
        this.y = (long)(Math.random()*Long.MAX_VALUE);
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
}
