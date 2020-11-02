package ii.po.szachy.core;

import java.security.InvalidAlgorithmParameterException;

public class Gra {
    private static int kolej;
    private static Gracz g1;
    private static Gracz g2;
    private Gra() {} // prywatny konstruktor, nie chcemy instancji tej klasy
    private static boolean endCond() {
        return g1.p.k.SzachMat || g1.p.k.Pat || g2.p.k.SzachMat || g2.p.k.Pat;
    }
    private static void playerTurn(Gracz g, Druzyna druzyna) throws InvalidAlgorithmParameterException {
        Plansza p = Plansza.getPlansza();
        boolean tmp;
        tmp = g.ruch_figury(p, g.d);
        while (!(tmp)) {
            tmp = g.ruch_figury(p, g.d);
            g.p.k.Pat=czy_Pat(g);
        }
    }
    private static boolean czy_Pat(Gracz g) {
        if (!(g.p.c1.czydostepny() || g.p.c2.czydostepny() || g.p.c3.czydostepny() || g.p.c4.czydostepny() || g.p.c5.czydostepny() || g.p.c6.czydostepny() || g.p.c7.czydostepny() || g.p.c8.czydostepny())) {
            if (!g.p.h1.czydostepny() && !g.p.h2.czydostepny() && !g.p.t1.czydostepny() && !g.p.t2.czydostepny() && !g.p.r1.czydostepny() && !g.p.r2.czydostepny() && !g.p.q.czydostepny()) {
                if (g.p.k.mozliweRuchy().size() == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    private static void printWinner() {
        if (g2.p.k.SzachMat){
            System.out.println("Gracz bialy wygral");
        } else if (g1.p.k.SzachMat) {
            System.out.println("Gracz czarny wygral");
        } else if (g1.p.k.Pat || g2.p.k.Pat) {
            System.out.println("Remis");
        }
    }
    public static void init() {
        g1 = new Gracz(Druzyna.BIALE);
        g2 = new Gracz(Druzyna.CZARNE);
    }
    public static void loop() throws InvalidAlgorithmParameterException {
        Plansza p = Plansza.getPlansza();
        boolean tmp;
        System.out.println(p);
        while (!endCond()) {
            switch (kolej) {
                case 0:
                    System.out.println("Kolej bialego gracza");
                    playerTurn(g1, Druzyna.BIALE);
                    break;
                case 1:
                    System.out.println("Kolej czarnego gracza");
                    playerTurn(g2, Druzyna.CZARNE);
                    break;
            }
            kolej = (kolej + 1) % 2;
            System.out.println(p);
        }
        printWinner();
    }
}