package UtesSzamlalo.Figurak;

import UtesSzamlalo.Allapot;
import UtesSzamlalo.Koordinata;

import java.util.List;

public class Gyalog extends Babu {

    public Gyalog(Koordinata koordinata) {
        super(koordinata);
    }

    @Override
    public boolean uti(Koordinata koordinata, List<Babu> babuk) {
        return koordinata.getY() == getY() - 1 && Math.abs(koordinata.getX() - getX()) == 1;
    }
}
