package UtesSzamlalo.Figurak;

import UtesSzamlalo.Koordinata;

import java.util.List;
import java.util.Objects;

public abstract class Babu {
    private Koordinata koordinata;

    /*
        Bábút létrehozom a megadott helyre
     */
    public Babu(Koordinata koordinata) {
        this.koordinata = koordinata;
    }

    /*
        Vizsgálja, hogy az adott bábú, üti-e a megadott koordinátát, annak függvényében, hogy milyen bábúk vannak még rajta kívül a pályán
     */
    public abstract boolean uti(Koordinata koordinata, List<Babu> babuk);

    public int getX() {
        return koordinata.getX();
    }

    public int getY() {
        return koordinata.getY();
    }

    public Koordinata getKoordinata() {
        return koordinata;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    /*
        Megvizsgálja, hogy két koordináta között található-e másik koordináta
     */
    protected boolean kozott(Koordinata vizsgalt, Koordinata elso, Koordinata masodik) {
        return tavolsag(elso, masodik) == (tavolsag(elso, vizsgalt) + tavolsag(vizsgalt, masodik)) &&
                !elso.equals(masodik) && !elso.equals(vizsgalt) && !masodik.equals(vizsgalt);
    }

    /*
        Visszaadja két koordináta távolságát
     */
    private double tavolsag(Koordinata elso, Koordinata masodik) {
        double a = Math.pow(masodik.getX() - elso.getX(), 2);
        double b = Math.pow(masodik.getY() - elso.getY(), 2);
        return Math.sqrt(a + b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Babu babu = (Babu) o;
        return Objects.equals(koordinata, babu.koordinata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(koordinata);
    }
}
