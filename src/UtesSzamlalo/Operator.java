package UtesSzamlalo;

import UtesSzamlalo.Figurak.*;

public class Operator {
    private Babu babu;

    public Operator(Babu babu) {
        this.babu = babu;
    }

    /*
        Egy operátor alkalmazhatóságát vizsgáljuk
     */
    public boolean alkalmazhato(Allapot allapot) {
        for (Koordinata koordinata : allapot.getKoordinatak()) {
            if (koordinata.equals(babu.getKoordinata())) {
                return false;
            }
        }
        for (Babu b : allapot.getBabuk()) {
            if (babu.getKoordinata().equals(b.getKoordinata())) {
                return false;
            }
        }
        for (Babu b : allapot.getBabuk()) {
            if (b.getName().equals(babu.getName())) {
                return false;
            }
        }
        Allapot vizsgalando = alkalmaz(allapot);
        for (Koordinata k : allapot.getKoordinatak()) {
            if (vizsgalando.rosszLepes() || Heurisztika.get(vizsgalando) >= Heurisztika.get(allapot)) {
                return false;
            }
        }
        return true;
    }

    /*
        Egy állapotra alkalmazza a kiválasztott operátort
     */
    public Allapot alkalmaz(Allapot allapot) {
        Allapot ujAllapot = new Allapot();
        ujAllapot.getBabuk().addAll(allapot.getBabuk());
        ujAllapot.getBabuk().add(babu);
        for (Koordinata koordinata : ujAllapot.getKoordinatak()) {
            for (Babu b : ujAllapot.getBabuk()) {
                if (b.uti(koordinata, ujAllapot.getBabuk())) {
                    ujAllapot.utMezo(koordinata);
                }
            }
        }
        return ujAllapot;
    }

    @Override
    public String toString() {
        return babu.getName() + " " + babu.getY() + " " + babu.getX();
    }
}
