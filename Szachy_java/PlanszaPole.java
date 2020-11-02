package ii.po.szachy.core;

public class PlanszaPole {
    private Figura figura;
    private char oznaczenieWiersz;
    private char oznaczenieKolumna;
    private char kolor;
    public Figura getFigura() {
        return figura;
    }
    public void setFigura(Figura figura) {
        this.figura = figura;
    }
    public char getOznaczenieWiersz() {
        return oznaczenieWiersz;
    }
    public void setOznaczenieWiersz(char oznaczenieWiersz) {
        this.oznaczenieWiersz = oznaczenieWiersz;
    }
    public char getOznaczenieKolumna() {
        return oznaczenieKolumna;
    }
    public void setOznaczenieKolumna(char oznaczenieKolumna) {
        this.oznaczenieKolumna = oznaczenieKolumna;
    }
    public char getKolor() {
        return kolor;
    }
    public void setKolor(char kolor) {
        this.kolor = kolor;
    }
}
