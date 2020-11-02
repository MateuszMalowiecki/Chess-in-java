package ii.po.szachy.core;
public class Pakiet_Figur {
    private Druzyna d;
    protected Pionek c1;
    protected Pionek c2;
    protected Pionek c3;
    protected Pionek c4;
    protected Pionek c5;
    protected Pionek c6;
    protected Pionek c7;
    protected Pionek c8;
    protected Wieża t1;
    protected Wieża t2;
    protected Wieża t3;
    protected Konik h1;
    protected Konik h2;
    protected Konik h3;
    protected Goniec r1;
    protected Goniec r2;
    protected Goniec r3;
    protected Król k;
    protected Królowa q;
    protected Królowa q2;
    public Pakiet_Figur(Druzyna d1) {
        this.d=d1;
        if (d1==Druzyna.CZARNE) {
            this.c1=new Pionek(0, 1, d);
            this.c2=new Pionek(1, 1, d);
            this.c3=new Pionek(2, 1, d);
            this.c4=new Pionek(3, 1, d);
            this.c5=new Pionek(4, 1, d);
            this.c6=new Pionek(5, 1, d);
            this.c7=new Pionek(6, 1, d);
            this.c8=new Pionek(7, 1, d);
            this.t1=new Wieża(0, 0, d);
            this.t2=new Wieża(7, 0, d);
            this.t3=null;
            this.h1=new Konik(1, 0, d);
            this.h2=new Konik(6, 0, d);
            this.h3=null;
            this.r1=new Goniec(5, 0, d);
            this.r2=new Goniec(2, 0, d);
            this.r3=null;
            this.q=new Królowa(3, 0, d);
            this.q2=null;
            this.k=new Król(4, 0, d);
        }
        else {
            this.c1=new Pionek(0, 6, d);
            this.c2=new Pionek(1, 6, d);
            this.c3=new Pionek(2, 6, d);
            this.c4=new Pionek(3, 6, d);
            this.c5=new Pionek(4, 6, d);
            this.c6=new Pionek(5, 6, d);
            this.c7=new Pionek(6, 6, d);
            this.c8=new Pionek(7, 6, d);
            this.t1=new Wieża(0, 7, d);
            this.t2=new Wieża(7, 7, d);
            this.t3=null;
            this.h1=new Konik(1,7, d);
            this.h2=new Konik(6, 7, d);
            this.h3=null;
            this.r1=new Goniec(5, 7, d);
            this.r2=new Goniec(2, 7, d);
            this.r3=null;
            this.q=new Królowa(3, 7, d);
            this.q2=null;
            this.k=new Król(4, 7, d);
        }
    }
}