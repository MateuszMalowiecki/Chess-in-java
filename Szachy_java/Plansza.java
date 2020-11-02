package ii.po.szachy.core;

public class Plansza {
    public static int ROZMIAR = 8;
    private PlanszaPole[][] plansza;
    private static Plansza singleton;
    private Król krolBiale;
    private Król krolCzarne;
    private Plansza() {
        plansza = new PlanszaPole[ROZMIAR][ROZMIAR];
        this.krolBiale=new Król(4, 7, Druzyna.BIALE);
        this.krolCzarne=new Król(4, 0, Druzyna.CZARNE);
        for(int y=this.ROZMIAR-1; y >= 0; --y) {
            for (int x = 0; x < this.ROZMIAR; ++x) {
                PlanszaPole p = new PlanszaPole();
                if ((x + y) % 2 == 0) {
                    p.setKolor('C');
                } else {
                    p.setKolor('B');
                }
                p.setOznaczenieKolumna((char) ('A' + x));
                p.setOznaczenieWiersz((char) (this.ROZMIAR - y + '0'));
                if (y==1) {
                    Pionek c=new Pionek(x, y, Druzyna.CZARNE);
                    p.setFigura(c);
                }
                else if (y==6) {
                    Pionek c=new Pionek(x, y, Druzyna.BIALE);
                    p.setFigura(c);
                }
                else if (y==0) {
                    if (x==0 || x==7) {
                       Wieża t=new Wieża(x, y, Druzyna.CZARNE) ;
                       p.setFigura(t);
                    }
                    else if(x==1 || x==6) {
                        Konik h=new Konik(x, y, Druzyna.CZARNE);
                        p.setFigura(h);
                    }
                    else if (x==2 || x==5) {
                        Goniec r=new Goniec(x, y, Druzyna.CZARNE);
                        p.setFigura(r);
                    }
                    else if(x==3) {
                        Królowa q=new Królowa(x, y, Druzyna.CZARNE);
                        p.setFigura(q);
                    }
                    else if (x==4) {
                        Król k=new Król(x, y, Druzyna.CZARNE);
                        p.setFigura(k);
                    }
                }
                else if(y==7) {
                    if (x==0 || x==7) {
                        Wieża t=new Wieża(x, y, Druzyna.BIALE) ;
                        p.setFigura(t);
                    }
                    else if(x==1 || x==6) {
                        Konik h=new Konik(x, y, Druzyna.BIALE);
                        p.setFigura(h);
                    }
                    else if (x==2 || x==5) {
                        Goniec r=new Goniec(x, y, Druzyna.BIALE);
                        p.setFigura(r);
                    }
                    else if(x==3) {
                        Królowa q=new Królowa(x, y, Druzyna.BIALE);
                        p.setFigura(q);
                    }
                    else if (x==4) {
                        Król k=new Król(x, y, Druzyna.BIALE);
                        p.setFigura(k);
                    }
                }
                plansza[y][x] = p;
            }
        }
    }
    public static Plansza getPlansza() {
        if (singleton == null) {
            singleton = new Plansza();
        }
        return singleton;
    }
    public Figura getFigura(int wiersz, int kolumna) {
        return plansza[wiersz][kolumna].getFigura();
    }
    public void setFigura(int wiersz, int kolumna, Figura f) {
        plansza[kolumna][wiersz].setFigura(f);
        if (! (f==null)) {
            f.posx = wiersz;
            f.posy = kolumna;
        }
    }
    public Król getKrolBiale() {
        return krolBiale;
    }
    public void setKrolBiale(Król krolBiale) {
        this.krolBiale = krolBiale;
    }
    public Król getKrolCzarne() {
        return krolCzarne;
    }
    public void setKrolCzarne(Król krolCzarne) {
        this.krolCzarne = krolCzarne;
    }
    public Król getKról(Druzyna d) {
        if (d == Druzyna.BIALE) {
            return krolBiale;
        }
        if (d == Druzyna.CZARNE) {
            return krolCzarne;
        }

        return null;
    }
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(int y=this.ROZMIAR-1; y >= 0; --y) {
            sb.append((y + 1) + " ");
            for (int x = 0; x < this.ROZMIAR; ++x) {
                Figura f = plansza[y][x].getFigura();
                if (f != null) {
                    sb.append(f);
                } else {
                    sb.append("* ");
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        sb.append("  ");
        for (char x = 'a'; x < 'a' + this.ROZMIAR; ++x) {
            sb.append(x + "  ");
        }
        sb.append("\n");
        return sb.toString();
    }
    protected boolean czy_w_przedziale (int x, int y) {
       return x >= 0 && y >= 0 && x < this.ROZMIAR && y < this.ROZMIAR;
    }
}