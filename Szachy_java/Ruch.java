package ii.po.szachy.core;

import ii.po.szachy.core.Plansza;

import java.util.List;

public class Ruch {
    private int nrWiersza;
    private int nrKolumny;
    private boolean czyJestBicie;
    public Ruch(int y, int x, boolean b) {
        setNrWiersza(y);
        setNrKolumny(x);
        setCzyJestBicie(b);
    }
    public int getNrWiersza() {
        return nrWiersza;
    }
    public void setNrWiersza(int nrWiersza) {
        this.nrWiersza = nrWiersza;
    }
    public int getNrKolumny() {
        return nrKolumny;
    }
    public void setNrKolumny(int nrKolumny) {
        this.nrKolumny = nrKolumny;
    }
    public boolean isCzyJestBicie() {
        return czyJestBicie;
    }
    public void setCzyJestBicie(boolean czyJestBicie) {
        this.czyJestBicie = czyJestBicie;
    }
    protected boolean czyWGranicy() {
        return  Plansza.getPlansza().ROZMIAR > this.getNrKolumny() && 0 <= this.getNrKolumny() &&
                Plansza.getPlansza().ROZMIAR > this.getNrWiersza() && 0 <= this.getNrWiersza();
    }
    public String toString() {
        StringBuffer sb=new StringBuffer();
        sb.append(nrWiersza);
        sb.append(nrKolumny);
        return sb.toString();
    }
}