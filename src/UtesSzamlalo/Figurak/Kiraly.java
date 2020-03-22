package UtesSzamlalo.Figurak;

import UtesSzamlalo.Allapot;
import UtesSzamlalo.Koordinata;

import java.util.List;

public class Kiraly extends Babu {

    public Kiraly(Koordinata koordinata) {
        super(koordinata);
    }

    @Override
    public boolean uti(Koordinata koordinata, List<Babu> babuk) {
        return Math.abs(koordinata.getX() - getX()) <= 1 && Math.abs(koordinata.getY() - getY()) <= 1;
    }
}
