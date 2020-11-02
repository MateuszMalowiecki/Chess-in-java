package ii.po.szachy.core;

import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Król extends Figura {
    protected boolean SzachMat;
    protected boolean Pat;
    private int orientacjaY;
    public Król(Druzyna d) {super(d);}
    public Król(int posx, int posy, Druzyna d) {
        super(posx, posy, d);
        SzachMat=false;
        if (druzyna == Druzyna.BIALE) {
            orientacjaY = 1;
        }
        else {
            orientacjaY = -1;
        }
        Pat=false;
    }
    @Override
    public List<Ruch> mozliweRuchy() {
        List<Ruch> l = new ArrayList<Ruch>();
        Plansza p = Plansza.getPlansza();
        boolean b;
        boolean czyFigura = false;
        if (this.posy > 0 && this.posx > 0) {
            if ((p.getFigura(this.posy - 1, this.posx - 1) == null || p.getFigura(this.posy - 1, this.posx - 1).druzyna != this.druzyna) && (czy_bezpieczna(posx-1, posy-1))) {
                b=p.getFigura(this.posy-1, this.posx-1) != null;
                addOnList(l, new Ruch(this.posy - 1, this.posx - 1, b));
            }
        }
        if (this.posx > 0 && this.posy < Plansza.ROZMIAR-1) {
            if ((p.getFigura(this.posy + 1, this.posx - 1) == null || p.getFigura(this.posy + 1, this.posx - 1).druzyna != this.druzyna) && (czy_bezpieczna(posx-1, posy+1))) {
                b=p.getFigura(this.posy+1, this.posx-1) != null;
                addOnList(l, new Ruch(this.posy + 1, this.posx - 1, b));
            }
        }
        if (this.posy > 0 && this.posx < Plansza.ROZMIAR-1) {
            if ((p.getFigura(this.posy - 1, this.posx + 1) == null || p.getFigura(this.posy - 1, this.posx + 1).druzyna != this.druzyna)  && (czy_bezpieczna(posx+1, posy-1))) {
                b=p.getFigura(this.posy-1, this.posx+1) != null;
                addOnList(l, new Ruch(this.posy - 1, this.posx + 1, b));
            }
        }
        if (this.posy < Plansza.ROZMIAR-1 && this.posx < Plansza.ROZMIAR-1) {
            if ((p.getFigura(this.posy + 1, this.posx + 1) == null || p.getFigura(this.posy + 1, this.posx + 1).druzyna != this.druzyna)  && (czy_bezpieczna(posx+1, posy+1))) {
                b=p.getFigura(this.posy+1, this.posx +1) != null;
                addOnList(l, new Ruch(this.posy + 1, this.posx + 1, b));
            }
        }
        if (this.posy > 0) {
            if ((p.getFigura(this.posy - 1, this.posx) == null || p.getFigura(this.posy - 1, this.posx).druzyna != this.druzyna)  && (czy_bezpieczna(posx, posy-1))) {
                b=p.getFigura(this.posy-1, this.posx) != null;
                addOnList(l, new Ruch(this.posy - 1, this.posx, b));
            }
        }
        if (this.posy < Plansza.ROZMIAR - 1) {
            if ((p.getFigura(this.posy + 1, this.posx) == null || p.getFigura(this.posy + 1, this.posx).druzyna != this.druzyna)  && (czy_bezpieczna(posx, posy+1))) {
                b=p.getFigura(this.posy+1, this.posx) != null;
                addOnList(l, new Ruch(this.posy + 1, this.posx, true));
            }
        }
        if (this.posx > 0) {
            if ((p.getFigura(this.posy, this.posx - 1) == null || p.getFigura(this.posy, this.posx - 1).druzyna != this.druzyna)  && (czy_bezpieczna(posx-1, posy))) {
                b=p.getFigura(this.posy, this.posx-1) != null;
                addOnList(l, new Ruch(this.posy, this.posx - 1, true));
            }
        }
        if (this.posx < Plansza.ROZMIAR - 1) {
            if ((p.getFigura(this.posy, this.posx + 1) == null || p.getFigura(this.posy, this.posx + 1).druzyna != this.druzyna)  && (czy_bezpieczna(posx+1, posy))) {
                b=p.getFigura(this.posy, this.posx+1) != null;
                addOnList(l, new Ruch(this.posy, this.posx + 1, true));
            }
        }
        return l;
    }
    private int min(int a, int b) {
        if (a < b) return a;
        return b;
    }
    private int max(int a, int b) {
        if (a < b) return b;
        return a;
    }
    public boolean czydostepny () {
        return this.mozliweRuchy().size() > 0;
    }
    protected boolean czy_bezpieczna(int x, int y) {
        Plansza p=Plansza.getPlansza();
        if (orientacjaY == 1) {
            if ((p.getFigura(x-1, y-1) instanceof Pionek && p.getFigura(x-1, y-1).druzyna != this.druzyna) || (p.getFigura(x+1, y-1) instanceof Pionek && p.getFigura(x+1, y-1).druzyna != this.druzyna)){
                return false;
            }
        }
        else if (orientacjaY == -1) {
            if ((p.getFigura(x-1, y+1) instanceof Pionek && p.getFigura(x-1, y+1).druzyna != this.druzyna) || (p.getFigura(x+1, y+1) instanceof Pionek && p.getFigura(x+1, y+1).druzyna != this.druzyna)) {
                return false;
            }
        }
        int px,py;
        for (px=0; px<Plansza.getPlansza().ROZMIAR; px++) {
            if ((p.getFigura(px, y) instanceof Wieża && p.getFigura(px, y).druzyna != this.druzyna) || (p.getFigura(px, y) instanceof Królowa && p.getFigura(px, y).druzyna != this.druzyna)) {
                for (int i=min(px, x); i<max(px, x); i++) {
                    if (p.getFigura(i, y) !=null) {
                        break;
                    }
                    else if (i==max(x, px) - 1) {
                        return false;
                    }
                }
            }
        }
        for (py=0; py<Plansza.getPlansza().ROZMIAR; py++) {
            if ((p.getFigura(x, py) instanceof Wieża && p.getFigura(x, py).druzyna != this.druzyna) || (p.getFigura(x, py) instanceof Królowa && p.getFigura(x, py).druzyna != this.druzyna)) {
                for (int i=min(py, y); i<max(py, y); i++) {
                    if (p.getFigura(x, i) !=null) {
                        break;
                    }
                    else if (i==max(y, py) - 1) {
                        return false;
                    }
                }
            }
        }
        int diff=y-x;
        int sum=y+x;
        px=(diff > 0) ? 0 : -diff;
        for(; px<p.ROZMIAR && diff+px <p.ROZMIAR; px++) {
            if ((p.getFigura(px, diff+px) instanceof Goniec && p.getFigura(px ,diff+px).druzyna != this.druzyna) || (p.getFigura(px ,diff+px) instanceof Królowa && p.getFigura(px, diff+px).druzyna != this.druzyna)) {
                for (int i=min(px, x); i<max(px, x); i++) {
                    if (p.getFigura(i, i+diff) !=null) {
                        break;
                    }
                    else if (i==max(x, px) - 1) {
                        return false;
                    }
                }
            }
        }
        px=(sum > p.ROZMIAR) ? sum + 1 - p.ROZMIAR : 0;
        for(; px<p.ROZMIAR && sum-px >= 0; px++) {
            if ((p.getFigura(px ,sum-px) instanceof Goniec && p.getFigura(px ,sum-px).druzyna != this.druzyna) || (p.getFigura(px, sum-px) instanceof Królowa && p.getFigura(px ,sum-px).druzyna != this.druzyna)) {
                for (int i=min(px, x); i<max(px, x); i++) {
                    if (p.getFigura(i, sum-i) !=null) {
                        break;
                    }
                    else if (i==max(x, px) - 1) {
                        return false;
                    }
                }
            }
        }
        for (int i=-1; i<=1; ++i){
            for (int j=-1; j<=1; ++j) {
                if ((p.czy_w_przedziale(x+i, y+j)) && p.getFigura(x+i, y+j) instanceof Król && p.getFigura(x+i, y+j).druzyna != this.druzyna) {
                    return false;
                }
            }
        }
        if ((p.czy_w_przedziale(x+1, y+2)) && (p.getFigura(x+1, y+2) instanceof Konik && p.getFigura(x+1, y+2).druzyna != this.druzyna)) {
            return false;
        }
        if ((p.czy_w_przedziale(x+2, y+1)) && (p.getFigura(x+2, y+1) instanceof Konik && p.getFigura(x+2, y+1).druzyna != this.druzyna)) {
            return false;
        }
        if ((p.czy_w_przedziale(x+1, y-2)) && (p.getFigura(x+1, y-2) instanceof Konik && p.getFigura(x+1, y-2).druzyna != this.druzyna)) {
            return false;
        }
        if ((p.czy_w_przedziale(x+2, y-1)) && p.getFigura(x+2, y-1) instanceof Konik && p.getFigura(x+2, y-1).druzyna != this.druzyna) {
            return false;
        }
        if (p.czy_w_przedziale(x-1, y+2) && (p.getFigura(x-1, y+2) instanceof Konik && p.getFigura(x-1, y+2).druzyna != this.druzyna)) {
            return false;
        }
        if (p.czy_w_przedziale(x-2, y+1) && p.getFigura(x-2, y+1) instanceof Konik && p.getFigura(x-2, y+1).druzyna != this.druzyna) {
            return false;
        }
        if ((p.czy_w_przedziale(x-1, y-2)) && (p.getFigura(x-1, y-2) instanceof Konik && p.getFigura(x-1, y-2).druzyna != this.druzyna)) {
            return false;
        }
        if ((p.czy_w_przedziale(x-2, y-1)) && (p.getFigura(x-2, y-1) instanceof Konik && p.getFigura(x-2, y-1).druzyna != this.druzyna)) {
            return false;
        }
        return true;
    }
    public boolean przemieszczenie() throws InvalidAlgorithmParameterException {
        List<Ruch> l = this.mozliweRuchy();
        if (!(czy_bezpieczna(posx, posy) || this.czydostepny())){
            this.SzachMat=true;
            System.out.println("Szach Mat");
            return false;
        }
        else if (!this.czydostepny()) {
            System.out.println("Nie ma zadnych ruchow");
            return false;
        }
        int tmpx=this.posx;
        int tmpy=this.posy;
        System.out.println("Masz nastepujace ruchy: \n");
        for (int i=0; i<l.size(); ++i) {
            int j=i+1;
            System.out.println(j + "[" + l.get(i).getNrWiersza() + "," + l.get(i).getNrKolumny() + "]" + "\n");
        }
        Scanner odczyt1 = new Scanner(System.in);
        int choice= Integer.parseInt(odczyt1.nextLine());
        if (choice <= 0 || choice > l.size()) {
            System.out.println("Zly wybor");
            return false;
        }
        this.posy= l.get(choice - 1).getNrWiersza();
        this.posx = l.get(choice - 1).getNrKolumny();
        if(l.get(choice-1).isCzyJestBicie()) {
            Plansza.getPlansza().getFigura(posy, posx).czyZbita=true;
        }
        Plansza.getPlansza().setFigura(posx, posy, this);
        Plansza.getPlansza().setFigura(tmpx, tmpy, null);
        return true;
    }
    @Override
    public String toString() {
        if (this.druzyna == Druzyna.CZARNE) return "kc";
        return "kb";
    }
}