package ii.po.szachy.core;

import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Królowa extends Figura {
    public Królowa(Druzyna d) {super(d);}
    public Królowa(int posx, int posy, Druzyna d) {
        super(posx, posy, d);
    }
    @Override
    public List<Ruch> mozliweRuchy() {
        List<Ruch> l = new ArrayList<Ruch>();
        Plansza p = Plansza.getPlansza();
        boolean b;
        int x,y;
        if (this.posy > 0 && this.posx > 0) {
            if (p.getFigura(this.posy - 1, this.posx - 1) == null || p.getFigura(this.posy - 1, this.posx - 1).druzyna != this.druzyna) {
                b=p.getFigura(this.posy-1, this.posx-1) != null;
                addOnList(l, new Ruch(this.posy - 1, this.posx - 1, b));
                for (y = this.posy - 2, x = this.posx - 2; y >= 0 && x >= 0; --y, --x) {
                    if (p.getFigura(y, x) == null || p.getFigura(y, x).druzyna != this.druzyna) {
                        b=p.getFigura(y, x) != null;
                        addOnList(l, new Ruch(y, x, b));
                    }
                    else { break; }
                }
            }
        }
        if (this.posx > 0 && this.posy < Plansza.ROZMIAR-1) {
            if (p.getFigura(this.posy + 1, this.posx - 1) == null || p.getFigura(this.posy + 1, this.posx - 1).druzyna != this.druzyna) {
                b=p.getFigura(this.posy+1, this.posx-1) != null;
                addOnList(l, new Ruch(this.posy + 1, this.posx - 1, b));
                for (y = this.posy + 2, x = this.posx - 2; y < Plansza.ROZMIAR && x >= 0; ++y, --x) {
                    if (p.getFigura(y, x) == null || p.getFigura(y, x).druzyna != this.druzyna) {
                        b=p.getFigura(y, x) != null;
                        addOnList(l, new Ruch(y, x, b));
                    }
                    else { break; }
                }
            }
        }
        if (this.posy > 0 && this.posx < Plansza.ROZMIAR-1) {
            if (p.getFigura(this.posy - 1, this.posx + 1) == null || p.getFigura(this.posy - 1, this.posx + 1).druzyna != this.druzyna) {
                b=p.getFigura(this.posy-1, this.posx+1) != null;
                addOnList(l, new Ruch(this.posy - 1, this.posx + 1, b));
                for (x = this.posx + 2, y = this.posy - 2; y >= 0 && x < Plansza.ROZMIAR; --y, ++x) {
                    if (p.getFigura(y, x) == null || p.getFigura(y, x).druzyna != this.druzyna) {
                        b=p.getFigura(y, x) != null;
                        addOnList(l, new Ruch(y, x, b));
                    }
                    else { break; }
                }
            }
        }
        if (this.posy < Plansza.ROZMIAR-1 && this.posx < Plansza.ROZMIAR-1) {
            if (p.getFigura(this.posy + 1, this.posx + 1) == null || p.getFigura(this.posy + 1, this.posx + 1).druzyna != this.druzyna) {
                b=p.getFigura(this.posy+1, this.posx+1) != null;
                addOnList(l, new Ruch(this.posy + 1, this.posx + 1, b));
                for (x = this.posx + 2, y = this.posy + 2; x < Plansza.ROZMIAR && y < Plansza.ROZMIAR; ++x, ++y) {
                    if (p.getFigura(y, x) == null || p.getFigura(y, x).druzyna != this.druzyna) {
                        b=p.getFigura(y, x) != null;
                        addOnList(l, new Ruch(y, x, b));
                    }
                    else { break; }
                }
            }
        }
        if (this.posy > 0) {
            if (p.getFigura(this.posy - 1, this.posx) == null || p.getFigura(this.posy - 1, this.posx).druzyna != this.druzyna) {
                b=p.getFigura(this.posy-1, this.posx) != null;
                addOnList(l, new Ruch(this.posy - 1, this.posx, b));
                for (y = this.posy - 2; y >= 0; --y) {
                    if (p.getFigura(y, this.posx) == null || p.getFigura(y, this.posx).druzyna != this.druzyna) {
                        b=p.getFigura(y, this.posx) != null;
                        addOnList(l, new Ruch(y, this.posx, b));
                    }
                    else { break; }
                }
            }
        }
        if (this.posy < Plansza.ROZMIAR - 1) {
            if (p.getFigura(this.posy + 1, this.posx) == null || p.getFigura(this.posy + 1, this.posx).druzyna != this.druzyna) {
                b=p.getFigura(this.posy+1, this.posx) != null;
                addOnList(l, new Ruch(this.posy + 1, this.posx, b));
                for (y = this.posy + 2; y < Plansza.ROZMIAR; ++y) {
                    if (p.getFigura(y, this.posx) == null || p.getFigura(y, this.posx).druzyna != this.druzyna) {
                        b=p.getFigura(y, this.posx) != null;
                        addOnList(l, new Ruch(y, this.posx, b));
                    }
                    else { break; }
                }
            }
        }
        if (this.posx > 0) {
            if (p.getFigura(this.posy, this.posx - 1) == null || p.getFigura(this.posy, this.posx - 1).druzyna != this.druzyna) {
                b=p.getFigura(this.posy, this.posx-1) != null;
                addOnList(l, new Ruch(this.posy, this.posx - 1, b));
                for (x = this.posx - 2; x >= 0; --x) {
                    if (p.getFigura(this.posy, x) == null || p.getFigura(this.posy, x).druzyna != this.druzyna) {
                        b=p.getFigura(this.posy, x) != null;
                        addOnList(l, new Ruch(this.posy, x, b));
                    }
                    else { break; }
                }
            }
        }
        if (this.posx < Plansza.ROZMIAR - 1) {
            if (p.getFigura(this.posy, this.posx + 1) == null || p.getFigura(this.posy, this.posx + 1).druzyna != this.druzyna) {
                b=p.getFigura(this.posy, this.posx+1) != null;
                addOnList(l, new Ruch(this.posy, this.posx + 1, b));
                for (x = this.posx + 2; x < Plansza.ROZMIAR; ++x) {
                    if (p.getFigura(this.posy, x) == null || p.getFigura(this.posy, x).druzyna != this.druzyna) {
                        b=p.getFigura(this.posy, x) != null;
                        addOnList(l, new Ruch(this.posy, x, b));
                    }
                    else { break; }
                }
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
            System.out.println("Krolowa zostala zbita");
        }
        return false;
    }
    @Override
    public String toString() {
        if (this.druzyna == Druzyna.CZARNE) return "qc";
        return "qb";
    }
}