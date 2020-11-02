package ii.po.szachy.core;

import java.security.InvalidAlgorithmParameterException;
import java.util.List;
public abstract class Figura {
    int posx;
    int posy;
    boolean czyZbita;
    Druzyna druzyna;
    public Figura() {
        czyZbita=false;
    }
    public Figura(Druzyna d) {
        this();
        druzyna = d;
    }
    public Figura(int px, int py, Druzyna d) {
        this(d);
        this.posx=px;
        this.posy=py;
    }
    public abstract List<Ruch> mozliweRuchy();
    protected void addOnList(List<Ruch> l, Ruch r) {
        if (r.czyWGranicy()) {
            l.add(r);
        }
    }
    protected boolean czy_Król_bezpieczny() {
        Plansza p=Plansza.getPlansza();
        Król k = p.getKról(druzyna);
        return k.czy_bezpieczna(k.posx, k.posy);
    }
    public abstract String toString();
    public abstract boolean przemieszczenie() throws InvalidAlgorithmParameterException;
    public abstract boolean czydostepny();
}