package ii.po.szachy.core;

import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Pionek extends Figura {
    private int licznik;
    private int orientacjaY;
    protected boolean czy_Koniec;
    public Pionek(Druzyna d) {super(d);}
    public Pionek(int px, int py, Druzyna d) {
        super(px, py, d);
        if (druzyna == Druzyna.BIALE) {
            orientacjaY = 1;
        }
        else {
            orientacjaY = -1;
        }
        licznik=0;
        czy_Koniec=false;
    }
    @Override
    public List<Ruch> mozliweRuchy() {
        List<Ruch> l = new ArrayList<Ruch>();
        boolean b;
        Ruch r = null;
        Plansza p=Plansza.getPlansza();
        for (int i = -1; i < 2; ++i) {
            if (this.posx + i >= 0 && this.posx + i < Plansza.ROZMIAR) {
                b = (i != 0);
                if (p.getFigura(this.posy-orientacjaY, this.posx) == null && !b) {
                    r = new Ruch((char) (this.posy - orientacjaY), this.posx, b);
                }
                else if (p.getFigura(this.posy-orientacjaY, this.posx) != null && p.getFigura(this.posy-orientacjaY, this.posx).druzyna != this.druzyna && b) {
                    r = new Ruch((char) this.posy - orientacjaY, (char)this.posx + i, b);
                }
                if (r != null) addOnList(l, r);
                r=null;
            }
        }
        if (this.licznik == 0 && p.getFigura(this.posy-orientacjaY, this.posx) == null && p.getFigura(this.posy-orientacjaY, this.posx) == null) {
            r = new Ruch(this.posy - (2 * orientacjaY), this.posx, false);
            addOnList(l, r);
        }
        return l;
    }
    public boolean czydostepny () {
        return (!(this.czy_Koniec || this.czyZbita)) && this.mozliweRuchy().size() > 0 ;
    }
    public boolean przemieszczenie() throws InvalidAlgorithmParameterException {
        List<Ruch> l = this.mozliweRuchy();
        if (this.czy_Król_bezpieczny() && this.czydostepny()) {
            int tmpx=posx;
            int tmpy=posy;
            System.out.println("Masz nastepujace ruchy: \n");
            for (int i = 0; i < l.size(); ++i) {
                int j = i + 1;
                System.out.println(j + ". [" + l.get(i).getNrWiersza() + ", " + l.get(i).getNrKolumny() + "]\n");
            }
            Scanner odczyt1 = new Scanner(System.in);
            int choice = Integer.parseInt(odczyt1.nextLine());
            if (choice <= 0 || choice > l.size()) {
                System.out.println("Zly wybor");
                return false;
            }
            this.posx = l.get(choice - 1).getNrWiersza();
            this.posy = l.get(choice - 1).getNrKolumny();
            if (l.get(choice-1).isCzyJestBicie()) {
                Plansza.getPlansza().getFigura(posy, posx).czyZbita=true;
            }
            Plansza.getPlansza().setFigura(posy, posx, this);
            Plansza.getPlansza().setFigura(tmpx, tmpy, null);
            if ((this.orientacjaY == 1 && this.posy==0) || ((this.orientacjaY == -1 && this.posy==Plansza.ROZMIAR - 1))) {
                this.czy_Koniec=true;
            }
            if (this.licznik == 0) this.licznik++;
            return true;
        }
        else if (l.size() == 0) {
            System.out.println("Nie masz zadnych ruchow ta figura");
            return false;
        }
        else if(!this.czy_Król_bezpieczny()) {
            System.out.println("Król jest w szachu, rusz się królem");
            return Plansza.getPlansza().getKról(druzyna).przemieszczenie();
        }
        else if(this.czyZbita) {
            System.out.println("Pionek zostal zbity");
        }
        else {
            System.out.println("Pionek zmienił sie na figure");
        }
        return false;
    }
    protected Figura promocja() {
        System.out.println("Pionek doszedl do końca, wybierz figure: ");
        System.out.println("T-wieza, H-kon, R-goniec, Q-krolowa");
        Scanner odczyt1 = new Scanner(System.in);
        String choice = (odczyt1.nextLine());
        switch (choice) {
            case "T":
                Wieża t=new Wieża(this.posx, this.posy, this.druzyna);
                Plansza.getPlansza().setFigura(this.posx, this.posy, t);
                return t;
            case "H":
                Konik h=new Konik(this.posx, this.posy, this.druzyna);
                Plansza.getPlansza().setFigura(this.posx, this.posy, h);
                return h;
            case "R":
                Goniec r=new Goniec(this.posx, this.posy, this.druzyna);
                Plansza.getPlansza().setFigura(this.posx, this.posy, r);
                return r;
            case "Q":
                Królowa q=new Królowa(this.posx, this.posy, this.druzyna);
                Plansza.getPlansza().setFigura(this.posx, this.posy, q);
                return q;
        }
        return null;
    }
    @Override
    public String toString() {
        if (this.druzyna == Druzyna.CZARNE) return "pc";
        return "pb";
    }
}