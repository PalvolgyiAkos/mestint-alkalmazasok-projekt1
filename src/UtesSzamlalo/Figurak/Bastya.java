package UtesSzamlalo.Figurak;

import UtesSzamlalo.Allapot;
import UtesSzamlalo.Koordinata;

import java.util.List;

public class Bastya extends Babu {

    public Bastya(Koordinata koordinata) {
        super(koordinata);
    }

    @Override
    public boolean uti(Koordinata koordinata, List<Babu> babuk) {
        boolean utesVan = false;
        if (getX() == koordinata.getX() || getY() == koordinata.getY()) {
            utesVan = true;
            for (Babu babu : babuk) {
                if (kozott(babu.getKoordinata(), koordinata, getKoordinata())) {
                    utesVan = false;
                }
            }
        }
        return utesVan;
    }
}
