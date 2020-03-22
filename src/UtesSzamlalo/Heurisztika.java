package UtesSzamlalo;


public class Heurisztika {
    /*
        Meghatározza, hogy hány darab ütésre van szükségünk ahhoz, hogy célállapotot érjünk
     */
    public static int get(Allapot allapot) {
        int heur = 0;
        for (Koordinata koordinata : allapot.getKoordinatak()) {
            heur += allapot.getMezo(koordinata);
        }
        return heur;
    }
}
