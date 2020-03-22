package UtesSzamlalo.Figurak;

import UtesSzamlalo.Allapot;
import UtesSzamlalo.Koordinata;

import java.util.List;

public class Vezer extends Babu {

    public Vezer(Koordinata koordinata) {
        super(koordinata);
    }

    @Override
    public boolean uti(Koordinata koordinata, List<Babu> babuk) {
        boolean utesVan = false;
        if ((getX() == koordinata.getX() || getY() == koordinata.getY()) ||
                (Math.abs(getX() - koordinata.getX()) == Math.abs(getY()- koordinata.getY()))) {
            utesVan = true;
            //System.out.println(babuk.size());
            for (Babu babu : babuk) {
                if (kozott(babu.getKoordinata(), koordinata, getKoordinata())) {
                    utesVan = false;
                }
            }
        }
        return utesVan;
    }
}
