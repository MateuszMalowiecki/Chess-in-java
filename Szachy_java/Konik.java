package ii.po.szachy.core;

import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Konik extends Figura {
    public Konik(Druzyna d) {super(d);}
    public Konik(int posx, int posy, Druzyna d) {
        super(posx, posy, d);
    }
    @Override
    public List<Ruch> mozliweRuchy() {
        List<Ruch> l = new ArrayList<Ruch>();
        Plansza p = Plansza.getPlansza();
        boolean b;
        if (this.posx < Plansza.ROZMIAR - 1 && this.posy < Plansza.ROZMIAR - 2) {
            if (p.getFigura(this.posy + 2, this.posx + 1) == null || p.getFigura(this.posy + 2, this.posx + 1).druzyna != this.druzyna) {
                b=p.getFigura(this.posy+2, this.posx+1) != null;
                addOnList(l, new Ruch(this.posy + 2, this.posx + 1, b));
            }
        }
        if (this.posy < Plansza.ROZMIAR - 1 && this.posx < Plansza.ROZMIAR - 2) {
            if (p.getFigura(this.posy + 1, this.posx + 2) == null || p.getFigura(this.posy + 1, this.posx + 2).druzyna != this.druzyna) {
                b=p.getFigura(this.posy+1, this.posx+2) != null;
                addOnList(l, new Ruch(this.posy + 1, this.posx + 2, b));
            }
        }
        if (this.posy > 0 && this.posx < Plansza.ROZMIAR - 2) {
            if (p.getFigura(this.posy - 1, this.posx + 2) == null || p.getFigura(this.posy - 1, this.posx + 2).druzyna != this.druzyna) {
                b=p.getFigura(this.posy-1, this.posx+2) != null;
                addOnList(l, new Ruch(this.posy - 1, this.posx + 2, b));
            }
        }
        if (this.posx < Plansza.ROZMIAR - 1 && this.posy >= 2) {
            if (p.getFigura(this.posy - 2, this.posx + 1) == null || p.getFigura(this.posy - 2, this.posx + 1).druzyna != this.druzyna) {
                b=p.getFigura(this.posy-2, this.posx+1) != null;
                addOnList(l, new Ruch(this.posy - 2, this.posx + 1, b));
            }
        }
        if (this.posy < Plansza.ROZMIAR - 1 && this.posx >= 2) {
            if (p.getFigura(this.posy + 1, this.posx - 2) == null || p.getFigura(this.posy + 1, this.posx - 2).druzyna != this.druzyna) {
                b=p.getFigura(this.posy+1, this.posx-2) != null;
                addOnList(l, new Ruch(this.posy + 1, this.posx - 2, b));
            }
        }
        if (this.posx >= 1 && this.posy < Plansza.ROZMIAR - 2) {
            if (p.getFigura(this.posy + 2, this.posx - 1) == null || p.getFigura(this.posy + 2, this.posx - 1).druzyna != this.druzyna) {
                b=p.getFigura(this.posy+2, this.posx-1) != null;
                addOnList(l, new Ruch(this.posy + 2, this.posx - 1, b));
            }
        }
        if (this.posy >= 1 && this.posx >= 2) {
            if (p.getFigura(this.posy - 1, this.posx - 2) == null || p.getFigura(this.posy - 1, this.posx - 2).druzyna != this.druzyna) {
                b=p.getFigura(this.posy-1, this.posx-2) != null;
                addOnList(l, new Ruch(this.posy - 1, this.posx - 2, b));
            }
        }
        if (this.posx >= 1 && this.posy >= 2) {
            if (p.getFigura(this.posy - 2, this.posx - 1) == null || p.getFigura(this.posy - 2, this.posx - 1).druzyna != this.druzyna) {
                b=p.getFigura(this.posy-2, this.posx-1) != null;
                addOnList(l, new Ruch(this.posy - 2, this.posx - 1, true));
            }
        }
        return l;
    }
    public boolean czydostepny () {
        return !this.czyZbita && this.mozliweRuchy().size() > 0;
    }
    public boolean przemieszczenie() throws InvalidAlgorithmParameterException {
        List<Ruch> l = this.mozliweRuchy();
        if (this.czy_Król_bezpieczny() && this.czydostepny()) {
            int tmpx=this.posx;
            int tmpy=this.posy;
            System.out.println("Masz nastepujace ruchy: \n");
            for (int i = 0; i < l.size(); ++i) {
                int j = i + 1;
                System.out.println(j + "[" + l.get(i).getNrWiersza() + ", " + l.get(i).getNrKolumny() + "]" + "\n");
            }
            Scanner odczyt1 = new Scanner(System.in);
            int choice = Integer.parseInt(odczyt1.nextLine());
            if (choice <= 0 || choice > l.size()) {
                System.out.println("Zly wybor");
                return false;
            }
            this.posy = l.get(choice - 1).getNrWiersza();
            this.posx = l.get(choice - 1).getNrKolumny();
            if(l.get(choice-1).isCzyJestBicie()) {
                Plansza.getPlansza().getFigura(posy, posx).czyZbita=true;
            }
            Plansza.getPlansza().setFigura(posx, posy, this);
            Plansza.getPlansza().setFigura(tmpx, tmpy, null);
            return true;
        }
        else if (l.size() == 0) {
            System.out.println("Nie ma zadnych ruchow");
            return false;
        }
        else if(!this.czy_Król_bezpieczny()) {
            System.out.println("Król jest w szachu, rusz się krolem");
            return Plansza.getPlansza().getKról(druzyna).przemieszczenie();
        }
        else {
            System.out.println("Pionek zostal zbity");
        }
        return false;
    }
    @Override
    public String toString() {
        if (this.druzyna == Druzyna.CZARNE) return "hc";
        return "hb";
    }
}