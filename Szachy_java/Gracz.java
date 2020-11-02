package ii.po.szachy.core;

import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Gracz {
    Druzyna d;
    Pakiet_Figur p;
    public Gracz(Druzyna d1) {
        this.d=d1;
        p=new Pakiet_Figur(d1);
    }
    private Figura wybierz_figure(Plansza p, Druzyna d) throws InvalidAlgorithmParameterException {
        Figura result = null;
        while (result == null) {
            System.out.println("Wybierz figure(P-pionek, T-wieża, H-konik, R-goniec, K-król, Q-królowa): ");
            Scanner odczyt1 = new Scanner(System.in);
            String choice = (odczyt1.nextLine());
            int choice2;
            switch (choice) {
                case "P":
                    System.out.println("Wybierz pionka: ");
                    odczyt1 = new Scanner(System.in);
                    choice2 = Integer.parseInt(odczyt1.nextLine());
                    switch (choice2) {
                        case 1:
                            result=this.p.c1;
                            break;
                        case 2:
                            result=this.p.c2;
                            break;
                        case 3:
                            result=this.p.c3;
                            break;
                        case 4:
                            result=this.p.c4;
                            break;
                        case 5:
                            result=this.p.c5;
                            break;
                        case 6:
                            result=this.p.c6;
                            break;
                        case 7:
                            result=this.p.c7;
                            break;
                        case 8:
                            result=this.p.c8;
                            break;

                    }
                    break;
                case "T":
                    System.out.println("Wybierz wieze: ");
                    odczyt1 = new Scanner(System.in);
                    choice2 = Integer.parseInt(odczyt1.nextLine());
                    switch (choice2) {
                        case 1:
                            result = this.p.t1;
                            break;
                        case 2:
                            result = this.p.t2;
                            break;
                        case 3:
                            result = this.p.t3;
                            break;
                    }
                    break;
                case "R":
                    System.out.println("Wybierz gońca: ");
                    odczyt1 = new Scanner(System.in);
                    choice2 = Integer.parseInt(odczyt1.nextLine());
                    switch (choice2) {
                        case 1:
                            result = this.p.r1;
                            break;
                        case 2:
                            result = this.p.r2;
                            break;
                        case 3:
                            result = this.p.r3;
                    }
                    break;
                    case "K":
                    result = this.p.k;
                    break;
                case "H":
                    System.out.println("Wybierz konia: ");
                    odczyt1 = new Scanner(System.in);
                    choice2 = Integer.parseInt(odczyt1.nextLine());
                    switch (choice2) {
                        case 1:
                            result = this.p.h1;
                            break;
                        case 2:
                            result = this.p.h2;
                            break;
                        case 3:
                            result=this.p.h3;
                    }
                    break;
                case "Q":
                    if (this.p.q2==null) {
                        result = this.p.q;
                    }
                    else {
                        System.out.println("Wybierz Krolowa");
                        odczyt1 = new Scanner(System.in);
                        choice2 = Integer.parseInt(odczyt1.nextLine());
                        switch (choice2) {
                            case 1:
                                result = this.p.q;
                                break;
                            case 2:
                                result = this.p.q2;
                                break;
                        }
                    }
                    break;
                default:
                        System.out.println("Zly wybor figury sprobuj ponownie");
            }
        }
        return result;
    }
    protected boolean ruch_figury(Plansza p1, Druzyna d) throws InvalidAlgorithmParameterException {
        Figura f=this.wybierz_figure(p1, d);
        boolean res= f.przemieszczenie();
        if (f instanceof Pionek && ((Pionek) f).czy_Koniec) {
            dodaj_figure(f);
        }
        return res;
    }
    private void dodaj_figure(Figura f) {
        if (((Pionek) f).promocja() instanceof  Wieża) {
            this.p.t3=new Wieża(((Wieża) ((Pionek) f).promocja()).posx, ((Wieża) ((Pionek) f).promocja()).posy, ((Wieża) ((Pionek) f).promocja()).druzyna);
        }
        else if (((Pionek) f).promocja() instanceof Konik) {
            this.p.h3=new Konik(((Wieża) ((Pionek) f).promocja()).posx, ((Wieża) ((Pionek) f).promocja()).posy, ((Wieża) ((Pionek) f).promocja()).druzyna);
        }
        else if (((Pionek) f).promocja() instanceof Goniec) {
            this.p.r3=new Goniec(((Wieża) ((Pionek) f).promocja()).posx, ((Wieża) ((Pionek) f).promocja()).posy, ((Wieża) ((Pionek) f).promocja()).druzyna);
        }
        else if (((Pionek) f).promocja() instanceof  Królowa) {
            this.p.q2=new Królowa(((Wieża) ((Pionek) f).promocja()).posx, ((Wieża) ((Pionek) f).promocja()).posy, ((Wieża) ((Pionek) f).promocja()).druzyna);
        }
    }
}