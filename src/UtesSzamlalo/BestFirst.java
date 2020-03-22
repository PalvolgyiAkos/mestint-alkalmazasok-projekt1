package UtesSzamlalo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BestFirst {

    public static void main(String[] args) {
        Problema p = new Problema();
        List<Operator> megoldas = keres(p);
        if (megoldas == null) {
            System.out.println("Nem találtunk megoldást!");
        } else {
            System.out.println();
            for (int i = 0; i < megoldas.size(); i++) {
                System.out.println(i + 1 + ". " + megoldas.get(megoldas.size() - i - 1));
            }
        }
    }

    /*
        Best-first kereső algoritmus
     */
    private static List<Operator> keres(Problema p) {
        LinkedList<Csucs> nyiltak = new LinkedList<BestFirst.Csucs>();
        LinkedList<Csucs> zartak = new LinkedList<BestFirst.Csucs>();
        nyiltak.add(new Csucs(p.kezdo(), null, null));
        int tesztSzamlalo = 0;
        while (true) {
            if (nyiltak.isEmpty()) {
                return null;
            }
            Csucs kivalasztott = null;
            for (Csucs vizsgalt : nyiltak) {
                if (kivalasztott == null || kivalasztott.heurisztika > vizsgalt.heurisztika) {
                    kivalasztott = vizsgalt;
                }
            }
            System.out.println("________________");
            tesztSzamlalo++;
            System.out.println(tesztSzamlalo + ". lépés");
            kivalasztott.allapot.kiir();
            if (kivalasztott.allapot.cel()) {
                List<Operator> megoldas = new ArrayList<>();
                for (Csucs c = kivalasztott; c.szulo != null; c = c.szulo) {
                    megoldas.add(c.eloallito);
                }
                return megoldas;
            }
            kiterjeszt(p, nyiltak, zartak, kivalasztott);
        }
    }

    /*
        Csomópontok kiterjesztése
     */
    private static void kiterjeszt(Problema p, LinkedList<Csucs> nyiltak, LinkedList<Csucs> zartak, Csucs kivalasztott) {
        for (Operator o : p.operatorok()) {
            if (o.alkalmazhato(kivalasztott.allapot)) {
                Allapot uj = o.alkalmaz(kivalasztott.allapot);
                boolean voltMar = false;
                for (Csucs c : nyiltak) {
                    if (c.allapot.equals(uj)) {
                        voltMar = true;
                        break;
                    }
                }
                if (!voltMar) {
                    for (Csucs c : zartak) {
                        if (c.allapot.equals(uj)) {
                            voltMar = true;
                            break;
                        }
                    }
                }

                if (!voltMar) {
                    nyiltak.add(new Csucs(uj, o, kivalasztott));
                }
            }
        }
        nyiltak.remove(kivalasztott);
        zartak.add(kivalasztott);
    }

    private static class Csucs {
        Allapot allapot;
        Operator eloallito;
        Csucs szulo;
        double heurisztika;

        public Csucs(Allapot allapot, Operator eloallito, Csucs szulo) {
            this.allapot = allapot;
            this.eloallito = eloallito;
            this.szulo = szulo;
            this.heurisztika = Heurisztika.get(allapot);
        }
    }
}
